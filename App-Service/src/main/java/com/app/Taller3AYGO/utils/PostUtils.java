package com.app.Taller3AYGO.utils;

import com.app.Taller3AYGO.dto.PostDto;
import com.app.Taller3AYGO.dto.UserDto;
import com.app.Taller3AYGO.model.Post;
import com.app.Taller3AYGO.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostUtils {

    public static Post mapPostDtoToPost(PostDto postDto){

        return Post
                .builder()
                .message(postDto.getMessage())
                .owner(postDto.getOwner())
                .creationDate(new Date())
                .build();
    }

    public static List<PostDto> mapPostToPostDto(List<Post> posts){

        List<PostDto> postsDtoList = new ArrayList<>();
        for(Post post : posts){
            var postDto = PostDto
                    .builder()
                    .message(post.getMessage())
                    .owner(post.getOwner())
                    .creationDate(post.getCreationDate())
                    .build();
            postsDtoList.add(postDto);
        }
        return postsDtoList;
    }

}
