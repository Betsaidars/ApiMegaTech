package com.example.ApiMegaTech.Repositories;

import com.example.ApiMegaTech.Models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<CategoryModel, String> {

}
