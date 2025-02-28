package com.example.ApiMegaTech.Controllers;

import com.example.ApiMegaTech.DTO.CategoryDTO;
import com.example.ApiMegaTech.Models.CategoryModel;
import com.example.ApiMegaTech.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CategoryModel> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategoryById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryModel) {
        CategoryModel createCategory = categoryService.save(categoryModel);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable String id, @RequestBody CategoryDTO categoryDTO) {
        try {
            categoryService.updateCategory(id, categoryDTO);
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(categoryDTO, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id) {
        try {
            categoryService.deleteCategoryById(id);
            return new ResponseEntity<>("Categoría eliminada correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoría", HttpStatus.NOT_FOUND);
        }
    }

}
