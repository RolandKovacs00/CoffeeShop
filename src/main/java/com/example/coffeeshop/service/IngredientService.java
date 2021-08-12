package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Ingredient;
import com.example.coffeeshop.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> ingredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient addNewProduct(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Optional<Ingredient> findProduct(Long id) {
        return ingredientRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        ingredientRepository.deleteById(id);
    }
}
