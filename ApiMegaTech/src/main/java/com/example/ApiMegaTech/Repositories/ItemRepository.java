package com.example.ApiMegaTech.Repositories;

import com.example.ApiMegaTech.Models.ItemModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<ItemModel, String> {

    List<ItemModel> findByCategoryId(int categoryId);
    List<ItemModel> findByName(String name);

    void deteleItemById(String id);


}
