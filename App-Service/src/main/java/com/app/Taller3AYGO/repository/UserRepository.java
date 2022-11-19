package com.app.Taller3AYGO.repository;

import com.app.Taller3AYGO.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'$or':[ {'email': ?0}, {'userName': ?1} ] }")
    User findUserByEmailAndUserName(String email, String userName);

    @Query("{'userName': ?0}")
    User findOneByUserName(String userName);

    @Query(value="{'userName' : ?0}", delete = true)
    void deleteByUserName (String userName);
}
