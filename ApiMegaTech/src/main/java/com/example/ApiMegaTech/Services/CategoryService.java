package com.example.ApiMegaTech.Services;

import com.example.ApiMegaTech.DTO.CategoryDTO;
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
    }

    public Optional<CategoryModel> findById(int id) {
    }

    public boolean register(CategoryModel categoryModel) {
    }

    public void updateItem(int id, CategoryDTO categoryDTO) {
    }

    public void deleteById(int id) {

    }
}
