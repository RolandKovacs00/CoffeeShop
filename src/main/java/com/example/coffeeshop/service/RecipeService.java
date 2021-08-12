package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Recipe;
import com.example.coffeeshop.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> recipes() {
        return recipeRepository.findAll();
    }

    public Recipe addNewProduct(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> findProduct(Long id) {
        return recipeRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        recipeRepository.deleteById(id);
    }
}