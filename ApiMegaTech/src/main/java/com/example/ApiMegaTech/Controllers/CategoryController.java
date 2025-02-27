package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.BannerDTO;
import com.example.ApiMegaTech.DTO.CategoryDTO;
import com.example.ApiMegaTech.Models.BannerModel;
import com.example.ApiMegaTech.Models.CategoryModel;
import com.example.ApiMegaTech.Repositories.BannerRepository;
import com.example.ApiMegaTech.Repositories.CategoryRepository;
import com.example.ApiMegaTech.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategoryById(@PathVariable int id){
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO){
        boolean ok = categoryService.register(categoryDTO);
        if (ok){
            return new ResponseEntity<>("Se ha insertado correctamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha insertado correctamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO){
        try{
            categoryService.updateItem(id, categoryDTO);
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(categoryDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
        categoryService.deleteById(id);
    }




}
