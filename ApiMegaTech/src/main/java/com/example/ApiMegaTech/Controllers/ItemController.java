package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.ItemDTO;
import com.example.ApiMegaTech.Models.ItemModel;
import com.example.ApiMegaTech.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public List<ItemModel> getAllItems(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItemModel> getItemById(@PathVariable String id){
        return itemService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ItemModel> createItem(@RequestBody ItemModel itemModel){
        ItemModel createItem = itemService.save(itemModel);
        return new ResponseEntity<>(createItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO){
        try{
            itemService.updateItem(id, itemDTO);
            return new ResponseEntity<>(itemDTO, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(itemDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        try {
            itemService.deleteItemById(id);
            return new ResponseEntity<>("Categoría eliminada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoría", HttpStatus.NOT_FOUND);
        }
    }
}
