package com.emrekoca.recipe.recipeapp.repositories;

import com.emrekoca.recipe.recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Emre.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
