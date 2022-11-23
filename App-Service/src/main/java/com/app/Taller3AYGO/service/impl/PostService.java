package com.app.Taller3AYGO.service.impl;

import com.app.Taller3AYGO.dto.PostDto;
import com.app.Taller3AYGO.model.Post;
import com.app.Taller3AYGO.repository.PostRepository;
import com.app.Taller3AYGO.service.api.IPostService;
import com.app.Taller3AYGO.utils.PostUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {

        Post newPost = PostUtils.mapPostDtoToPost(postDto);
        postRepository.save(newPost);
    }

    @Override
    public List<PostDto> getPosts() {

        List<Post> posts = postRepository.findPosts();
        return PostUtils.mapPostToPostDto(posts);
    }
}
