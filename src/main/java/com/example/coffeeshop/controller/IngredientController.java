package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Address;
import com.example.coffeeshop.model.Ingredient;
import com.example.coffeeshop.repository.IngredientRepository;
import com.example.coffeeshop.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {
    private final IngredientRepository ingredientRepository;
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository, IngredientService ingredientService) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/allIngredients")
    public ResponseEntity<List<Ingredient>> ingredient() {
        List<Ingredient> ingredients = ingredientService.ingredients();
        return new ResponseEntity<List<Ingredient>>(ingredients, HttpStatus.OK);
    }

    @PostMapping("/newIngredient")
    public ResponseEntity<Ingredient> addNewProduct(@RequestBody Ingredient ing) {
        Ingredient ingredient = null;
        try {
            ingredient = ingredientService.addNewProduct(ing);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }

    @DeleteMapping("deleteIngredient/{id}")
    public void delete(@PathVariable Long id) {
        ingredientService.deleteProduct(id);
    }

    @PutMapping("updateIngredient/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable Long id, @RequestBody Ingredient ingredients) {
        Optional<Ingredient> ing = ingredientRepository.findById(id);
        if (ing.isPresent()) {
            Ingredient ingredient = ing.get();
            ingredient.setName(ingredients.getName());
            ingredient.setPrice(ingredients.getPrice());
            ingredient.setStock(ingredients.getStock());
            return new ResponseEntity<>(ingredientService.addNewProduct(ingredient), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("ingredient/{id}")
    public Optional<Ingredient> getProductById(@PathVariable Long id) {
        return ingredientService.findProduct(id);
    }
}

