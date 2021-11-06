package de.htwberlin.webtech;

import de.htwberlin.webtech.api.Recipe;
import de.htwberlin.webtech.persistence.RecipeRepository;
import de.htwberlin.webtech.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;

    public RecipeRestController(RecipeRepository recipeRepository, RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/api/v1/recipe")
    public ResponseEntity<List<Recipe>> fetchRecipes() {
        return ResponseEntity.ok(recipeService.findAll());
    }

}
