package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.Recipe;
import de.htwberlin.webtech.persistence.RecipeRepository;
import de.htwberlin.webtech.service.RecipeService;
import de.htwberlin.webtech.web.api.RecipeCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path = "/api/v1/recipe")
    public ResponseEntity<Void> createRecipe(@RequestBody RecipeCreateRequest request) throws URISyntaxException {
        var recipe = recipeService.create(request);
        URI uri = new URI("api/v1/recipe" + recipe.getId());
        return ResponseEntity.created(uri).build();
    }

}
