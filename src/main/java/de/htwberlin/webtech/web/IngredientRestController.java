package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.Ingredient;
import de.htwberlin.webtech.persistence.IngredientRepository;
import de.htwberlin.webtech.service.IngredientService;
import de.htwberlin.webtech.web.api.IngredientCreateOrUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class IngredientRestController {

    private final IngredientService ingredientService;

    public IngredientRestController(IngredientRepository ingredientRepository, IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(path = "/api/v1/ingredients")
    public ResponseEntity<List<Ingredient>> fetchIngredients() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @GetMapping(path = "api/v1/ingredients/{id}")
    public ResponseEntity<Ingredient> fetchIngredientById(@PathVariable Long id) {
        var ingredient = ingredientService.findById(id);
        return ingredient != null? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/ingredients")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientCreateOrUpdateRequest request) throws URISyntaxException {
        var ingredient = ingredientService.create(request);
        URI uri = new URI("api/v1/ingredients" + ingredient.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "api/v1/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody IngredientCreateOrUpdateRequest request) {
        var ingredient = ingredientService.update(id, request);
        return ingredient != null? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "api/v1/ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        boolean successful = ingredientService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
