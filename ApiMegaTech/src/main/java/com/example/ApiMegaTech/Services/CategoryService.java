package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.CategoryDTO;
import com.example.ApiMegaTech.Models.BannerModel;
import com.example.ApiMegaTech.Models.CategoryModel;
import com.example.ApiMegaTech.Repositories.CategoryRepository;
import com.example.ApiMegaTech.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryModel> findById(String id) {
        return categoryRepository.findById(id);
    }

    public CategoryModel save(CategoryModel categoryModel){
        return categoryRepository.save(categoryModel);
    }

    public void updateCategory(String id, CategoryDTO categoryDTO) {
        Optional<CategoryModel> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()){
            CategoryModel categoryModel = categoryOptional.get();
            categoryModel.setName(categoryDTO.getName());
            categoryModel.setDescription(categoryDTO.getDescription());
            categoryModel.setImageUrl(categoryDTO.getImageUrl());

            categoryRepository.save(categoryModel);
        }
    }

    public void deleteCategoryById(String id) {
        if (!categoryRepository.existsById(id)){
            throw new RuntimeException();
        }
        categoryRepository.deleteById(id);
    }
}
