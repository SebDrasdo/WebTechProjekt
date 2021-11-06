package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Recipe;
import de.htwberlin.webtech.persistence.RecipeEntity;
import de.htwberlin.webtech.persistence.RecipeRepository;
import de.htwberlin.webtech.web.api.RecipeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll(){
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe create(RecipeCreateRequest request) {
        var recipeEntity = new RecipeEntity(request.getFirstName(), request.getLastName(), request.isVaccinated());
        recipeEntity = recipeRepository.save(recipeEntity);
        return transformEntity(recipeEntity);
    }

    private Recipe transformEntity(RecipeEntity recipeEntity) {
        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getFirstName(),
                recipeEntity.getLastName(),
                recipeEntity.getVaccinated()
        );
    }
}
