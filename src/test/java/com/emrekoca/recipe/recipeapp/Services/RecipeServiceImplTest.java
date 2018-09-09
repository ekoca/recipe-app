package com.emrekoca.recipe.recipeapp.Services;

import com.emrekoca.recipe.recipeapp.model.Recipe;
import com.emrekoca.recipe.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Emre.
 */
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception{
        Set<Recipe> recipes = setUpRecipeData();
        when(recipeService.getRecipes()).thenReturn(recipes);

        Set<Recipe> aRecipes = recipeService.getRecipes();
        assertEquals(recipes.size(), aRecipes.size());
        verify(recipeRepository, times(1)).findAll();
    }

    private Set<Recipe> setUpRecipeData() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        return recipes;
    }
}