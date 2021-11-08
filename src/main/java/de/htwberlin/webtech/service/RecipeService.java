package de.htwberlin.webtech.service;

import de.htwberlin.webtech.web.api.Recipe;
import de.htwberlin.webtech.persistence.RecipeEntity;
import de.htwberlin.webtech.persistence.RecipeRepository;
import de.htwberlin.webtech.web.api.RecipeCreateOrUpdateRequest;
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

    public Recipe findById(Long id) {
        var  recipeEntity = recipeRepository.findById(id);
        return recipeEntity.map(this::transformEntity).orElse(null);
    }

    public Recipe create(RecipeCreateOrUpdateRequest request) {
        var recipeEntity = new RecipeEntity(request.getFirstName(), request.getLastName(), request.isVaccinated());
        recipeEntity = recipeRepository.save(recipeEntity);
        return transformEntity(recipeEntity);
    }

    public Recipe update(Long id, RecipeCreateOrUpdateRequest request) {
        var  recipeEntityOptional = recipeRepository.findById(id);
        if (recipeEntityOptional.isEmpty()) {
            return null;
        }
        var recipeEntity = recipeEntityOptional.get();
        recipeEntity.setFirstName(request.getFirstName());
        recipeEntity.setLastName(request.getLastName());
        recipeEntity.setVaccinated(request.isVaccinated());
        recipeRepository.save(recipeEntity);

        return transformEntity(recipeEntity);
    }

    public boolean deleteById(Long id) {
        if (!recipeRepository.existsById(id)) {
            return false;
        }
        recipeRepository.deleteById(id);
        return true;
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
