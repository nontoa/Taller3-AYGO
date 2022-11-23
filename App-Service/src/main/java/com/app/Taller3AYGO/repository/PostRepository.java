package com.app.Taller3AYGO.repository;

import com.app.Taller3AYGO.model.Post;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Aggregation(pipeline = {
            "{ '$sort' : { 'creationDate' : -1 } }"
    })
    List<Post> findPosts();
}
