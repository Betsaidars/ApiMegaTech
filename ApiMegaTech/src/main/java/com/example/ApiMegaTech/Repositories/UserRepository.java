package com.example.ApiMegaTech.Repositories;

import com.example.ApiMegaTech.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, Long> {

    UserModel findByName(String username);
}
