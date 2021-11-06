package de.htwberlin.webtech.service;

import de.htwberlin.webtech.api.Recipe;
import de.htwberlin.webtech.persistence.RecipeEntity;
import de.htwberlin.webtech.persistence.RecipeRepository;
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
                .map(recipeEntity -> new Recipe(
                        recipeEntity.getId(),
                        recipeEntity.getFirstName(),
                        recipeEntity.getLastName(),
                        recipeEntity.getVaccinated()
                ))
                .collect(Collectors.toList());
    }
}
