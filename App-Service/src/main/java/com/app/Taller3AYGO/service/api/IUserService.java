package com.app.Taller3AYGO.service.api;

import com.app.Taller3AYGO.dto.UserDto;
import com.app.Taller3AYGO.model.User;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
public interface IUserService {

    void createUser(final UserDto userDto) throws UnsupportedEncodingException;

    List<UserDto> getUsers();

    User findUserByEmailAndUsername(final String email, final String userName);

    void deleteUserByUserName(final String userName);

}
