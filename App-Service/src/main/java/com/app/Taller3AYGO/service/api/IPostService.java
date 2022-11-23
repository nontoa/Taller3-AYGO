package com.app.Taller3AYGO.service.api;

import com.app.Taller3AYGO.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IPostService {

    void createPost(final PostDto postDto);

    List<PostDto> getPosts();

}
