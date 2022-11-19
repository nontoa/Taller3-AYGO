package com.app.Taller3AYGO.service.impl;

import com.app.Taller3AYGO.dto.UserDto;
import com.app.Taller3AYGO.model.User;
import com.app.Taller3AYGO.repository.UserRepository;
import com.app.Taller3AYGO.service.api.IUserService;
import com.app.Taller3AYGO.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(final UserDto userDto) throws UnsupportedEncodingException {

        User newUser = UserUtils.mapUserDtoToUser(userDto);
        userRepository.save(newUser);
    }

    @Override
    public List<UserDto> getUsers() {

        List<User> users = userRepository.findAll();
        return UserUtils.mapUserToUserDto(users);
    }

    @Override
    public User findUserByEmailAndUsername(final String email, final String userName) {

        return userRepository.findUserByEmailAndUserName(email, userName);
    }

    @Override
    public void deleteUserByUserName(final String userName) {

        userRepository.deleteByUserName(userName);
    }

}
