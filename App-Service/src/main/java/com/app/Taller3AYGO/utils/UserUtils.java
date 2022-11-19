package com.app.Taller3AYGO.utils;

import com.app.Taller3AYGO.dto.UserDto;
import com.app.Taller3AYGO.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserUtils {

    public static User mapUserDtoToUser(UserDto userDto) throws UnsupportedEncodingException {

        return User
                .builder()
                .name(userDto.getName())
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .password(encryptPassword(userDto.getPassword()))
                .creationDate(new Date())
                .build();
    }

    public static List<UserDto> mapUserToUserDto(List<User> users){

        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            var userDto = UserDto
                    .builder()
                    .name(user.getName())
                    .userName(user.getUserName())
                    .email(user.getEmail())
                    .creationDate(user.getCreationDate())
                    .build();
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    private static String encryptPassword(final String password) throws UnsupportedEncodingException {

        return new BCryptPasswordEncoder().encode(password);
    }

}
