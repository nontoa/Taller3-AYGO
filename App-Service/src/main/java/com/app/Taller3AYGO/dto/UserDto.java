package com.app.Taller3AYGO.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

    private String name;
    private String userName;
    private String email;
    private String password;
    private Date creationDate;

}
