package com.jun.crewchat.service.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jun.crewchat.define.EUserRole;
import com.jun.crewchat.security.dto.AuthUserDTO;

import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public List<UserDTO> getList(UserDTO dto){
        log.info("DTO : " +dto);
        return userRepository.getList(dto);
    }

    public UserDTO getMyInfo(UserDTO dto){
        log.info("DTO : " +dto);
        return userRepository.getMyInfo(dto);
    }

    public String sign() {
        return "/main";
    }

    public String signIn(AuthUserDTO authUserDTO) {
        return authUserDTO != null ? "redirect:/crewchat" : "sign";
    }

    public String signUp(UserDTO userDTO, BindingResult bindingResult) {
        Optional<UserEntity> result = userRepository.findByEmail(userDTO.getEmail(), userDTO.fromSocial);

        String validationResponse = validation(bindingResult, result);

        if (bindingResult.hasErrors() || result.isPresent()) {
            return validationResponse;
        }
        userDTO.addUserRole(EUserRole.USER);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return validationResponse;
    }

    private String validation(BindingResult bindingResult, Optional<UserEntity> result) {
        JsonObject validationJsonObject = new JsonObject();
        if (bindingResult.hasErrors() || result.isPresent()) {
            JsonArray validationArray = new JsonArray();
            JsonObject validationMessage = new JsonObject();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationMessage.addProperty(error.getField(), error.getDefaultMessage());
            }
            validationArray.add(validationMessage);
            validationJsonObject.addProperty("isUser", true);
            validationJsonObject.addProperty("validation", false);
            validationJsonObject.add("message", validationArray);
            return validationJsonObject.toString();
        }
        validationJsonObject.addProperty("isUser", false);
        validationJsonObject.addProperty("validation", true);
        validationJsonObject.add("message", null);
        return validationJsonObject.toString();
    }
}
