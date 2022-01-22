package com.jun.crewchat.security.service;

import com.jun.crewchat.security.dto.AuthUserDTO;
import com.jun.crewchat.service.user.UserEntity;
import com.jun.crewchat.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetailService loadUserByUsername : " + username);
        Optional<UserEntity> result = userRepository.findByEmail(username, false);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Check Email or Social");
        }
        UserEntity user = result.get();

        AuthUserDTO userDTO = new AuthUserDTO(
                user.getEmail(),
                user.getPassword(),
                user.isFromSocial(),
                user.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet())
        );
        userDTO.setName(user.getName());
        userDTO.setFromSocial(user.isFromSocial());
        log.info(userDTO+"");
        return userDTO;

    }
}
