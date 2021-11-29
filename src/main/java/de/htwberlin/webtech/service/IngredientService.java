package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Ingredient;
import de.htwberlin.webtech.persistence.IngredientEntity;
import de.htwberlin.webtech.persistence.IngredientRepository;
import de.htwberlin.webtech.web.api.IngredientCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll(){
        List<IngredientEntity> ingredients = ingredientRepository.findAll();
        return ingredients.stream()
                .map(this::transformIngredientEntity)
                .collect(Collectors.toList());
    }

    public Ingredient findById(Long id) {
        var  recipeEntity = ingredientRepository.findById(id);
        return recipeEntity.map(this::transformIngredientEntity).orElse(null);
    }

    public Ingredient create(IngredientCreateOrUpdateRequest request) {
        var ingredientEntity = new IngredientEntity(request.getIngredientName(), request.getPrice(), request.getCalories(), request.isVegan());
        ingredientEntity = ingredientRepository.save(ingredientEntity);
        return transformIngredientEntity(ingredientEntity);
    }

    public Ingredient update(Long id, IngredientCreateOrUpdateRequest request) {
        var  ingredientEntityOptional = ingredientRepository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }
        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setIngredientName(request.getIngredientName());
        ingredientEntity.setPrice(request.getPrice());
        ingredientEntity.setCalories(request.getCalories());
        ingredientEntity.setVegan(request.isVegan());
        ingredientRepository.save(ingredientEntity);

        return transformIngredientEntity(ingredientEntity);
    }

    public boolean deleteById(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return false;
        }
        ingredientRepository.deleteById(id);
        return true;
    }

    private Ingredient transformIngredientEntity(IngredientEntity ingredientEntity) {
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getIngredientName(),
                ingredientEntity.getPrice(),
                ingredientEntity.getCalories(),
                ingredientEntity.getVegan()
        );
    }
}
