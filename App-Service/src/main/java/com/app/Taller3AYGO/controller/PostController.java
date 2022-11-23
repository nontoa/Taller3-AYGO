package com.app.Taller3AYGO.controller;

import com.app.Taller3AYGO.constant.RestEndpoint;
import com.app.Taller3AYGO.dto.PostDto;
import com.app.Taller3AYGO.service.api.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestEndpoint.POSTS)
@CrossOrigin(origins = "https://localhost:3000")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody PostDto post){

        try {
            postService.createPost(post);
            return new ResponseEntity<>("Post created", HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("There was a problem creating the post", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){

        try {
            List<PostDto> posts = postService.getPosts();
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("There was a problem getting the posts", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
