package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.ItemDTO;
import com.example.ApiMegaTech.Models.ItemModel;
import com.example.ApiMegaTech.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public List<ItemModel> findAll() {
        return itemRepository.findAll();
    }

    public Optional<ItemModel> findById(String id) {
        return itemRepository.findById(id);
    }

    public ItemModel save(ItemModel itemModel) {
        return itemRepository.save(itemModel);
    }

    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<ItemModel> itemOptional = itemRepository.findById(id);

        if (itemOptional.isPresent()){
            ItemModel itemModel = itemOptional.get();
            itemModel.setName(itemDTO.getName());
            itemModel.setCategoryId(itemDTO.getCategoryId());
            itemModel.setDescription(itemDTO.getDescription());
            itemModel.setBrand(itemDTO.getBrand());
            itemModel.setModel(itemDTO.getModel());
            itemModel.setAvailableColor(itemDTO.getAvailableColor());
            itemModel.setImageUrl(itemDTO.getImageUrl());
            itemModel.setPrice(itemDTO.getPrice());
            itemModel.setRating(itemDTO.getRating());

            itemRepository.save(itemModel);
        }else {
            throw new RuntimeException("No existe el item con id: " +id);
        }
    }

    public void deleteItemById(String id) {
        try {
            itemRepository.deteleItemById(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
