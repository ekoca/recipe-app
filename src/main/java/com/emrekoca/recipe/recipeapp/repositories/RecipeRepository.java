package com.emrekoca.recipe.recipeapp.repositories;

import com.emrekoca.recipe.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Emre.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
