package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Address;
import com.example.coffeeshop.model.Recipe;
import com.example.coffeeshop.repository.RecipeRepository;
import com.example.coffeeshop.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {
    private final RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository, RecipeService recipeService) {
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
    }

    @GetMapping("/allRecipes")
    public ResponseEntity<List<Recipe>> recipe() {
        List<Recipe> recipes = recipeService.recipes();
        return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
    }

    @PostMapping("/newRecipe")
    public ResponseEntity<Recipe> addNewProduct(@RequestBody Recipe rec) {
        Recipe recipe = null;
        try {
            recipe = recipeService.addNewProduct(rec);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("deleteRecipe/{id}")
    public void delete(@PathVariable Long id) {
        recipeService.deleteProduct(id);
    }

    @PutMapping("updateRecipe/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipes) {
        Optional<Recipe> rec = recipeRepository.findById(id);
        if (rec.isPresent()) {
            Recipe recipe = rec.get();
            recipe.setName(recipes.getName());
            recipe.setPrice(recipes.getPrice());
            recipe.setCustom(recipes.getCustom());
            return new ResponseEntity<>(recipeService.addNewProduct(recipe), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("recipe/{id}")
    public Optional<Recipe> getProductById(@PathVariable Long id) {
        return recipeService.findProduct(id);
    }
}
