package com.app.Taller3AYGO.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {

    private String message;
    private String owner;
    private Date creationDate;
}
