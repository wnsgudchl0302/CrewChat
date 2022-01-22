package com.jun.crewchat.service.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jun.crewchat.security.dto.AuthUserDTO;

import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public String signIn(AuthUserDTO authUserDTO) {
        return authUserDTO != null ? "main.html" : "sign.html";
    }

    public String signUp(UserDTO userDTO, BindingResult bindingResult) {
        String validationResponse = validation(bindingResult);
        if (bindingResult.hasErrors()) {
            return validationResponse;
        }
        userDTO.addUserRole(UserRole.USER);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        userRepository.save(userEntity);
        return validationResponse;
    }

    private String validation(BindingResult bindingResult) {
        JsonObject validationJsonObject = new JsonObject();
        if (bindingResult.hasErrors()) {
            JsonArray validationArray = new JsonArray();
            JsonObject validationMessage = new JsonObject();
            for (FieldError error : bindingResult.getFieldErrors()) {
                validationMessage.addProperty(error.getField(), error.getDefaultMessage());
            }
            validationArray.add(validationMessage);
            validationJsonObject.addProperty("validation", false);
            validationJsonObject.add("message", validationArray);
            return validationJsonObject.toString();
        }
        validationJsonObject.addProperty("validation", true);
        validationJsonObject.add("message", null);
        return validationJsonObject.toString();
    }
}
