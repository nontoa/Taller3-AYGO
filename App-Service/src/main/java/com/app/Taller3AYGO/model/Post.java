package com.app.Taller3AYGO.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {

    private String message;
    private String owner;
    private Date creationDate;

}
