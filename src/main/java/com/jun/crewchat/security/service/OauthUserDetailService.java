package com.jun.crewchat.security.service;

import com.jun.crewchat.define.ESocialClient;
import com.jun.crewchat.define.EUserRole;
import com.jun.crewchat.security.dto.AuthUserDTO;
import com.jun.crewchat.service.user.UserDTO;
import com.jun.crewchat.service.user.UserEntity;
import com.jun.crewchat.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OauthUserDetailService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        Map<String, Object> attributes = super.loadUser(userRequest).getAttributes();

        String clientName = userRequest.getClientRegistration().getClientName();
        log.info("123");
        log.info(clientName);
        UserDTO dto = new UserDTO();
        if (clientName.equals(ESocialClient.GOOGLE.getName())) {
            String email = attributes.get("email").toString();
            String name = attributes.get("name").toString();
            dto = signUp(email, name, ESocialClient.GOOGLE.name());
        }
        if (clientName.equals(ESocialClient.KAKAO.getName())) {
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            String email = kakaoAccount.get("email").toString();
            String name = properties.get("nickname").toString();
            dto = signUp(email, name, ESocialClient.KAKAO.name());
        }

        AuthUserDTO userDTO = new AuthUserDTO(
                dto.getEmail()
                , dto.getPassword()
                , dto.isFromSocial()
                , dto.getRoleSet().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet())
        );
        return userDTO;
    }

    private UserDTO signUp(String email, String name, String socialType) {
        Optional<UserEntity> result = userRepository.findByEmail(email, true);
        if (result.isPresent()) {
            return modelMapper.map(result.get(), UserDTO.class);
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(passwordEncoder.encode("ABC123!"));
        userDTO.setName(name);
        userDTO.setFromSocial(true);
        userDTO.setSocialType(socialType);
        userDTO.setSocialImg(true);

        userDTO.addUserRole(EUserRole.USER);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userRepository.save(userEntity);
        return userDTO;
    }
}
