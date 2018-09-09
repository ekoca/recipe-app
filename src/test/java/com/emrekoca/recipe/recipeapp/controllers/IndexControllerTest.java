package com.emrekoca.recipe.recipeapp.controllers;

import com.emrekoca.recipe.recipeapp.Services.RecipeServiceImpl;
import com.emrekoca.recipe.recipeapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class IndexControllerTest {
    IndexController indexController;

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getIndexPage() throws Exception {
        Set<Recipe> recipes = setUpRecipeData();
        when(recipeService.getRecipes()).thenReturn(recipes);

        final String index = indexController.getIndexPage(model);

        assertEquals("index", index);
        verify(recipeService, times(1)).getRecipes();
        // any set
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
        // set that we setup above
        verify(model, times(1)).addAttribute("recipes", recipes);
    }

    @Test
    public void getIndexPageWithArgumentCapture() throws Exception {
        Set<Recipe> recipes = setUpRecipeData();
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        final String index = indexController.getIndexPage(model);

        assertEquals("index", index);
        verify(recipeService, times(1)).getRecipes();
        // any set
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
        // set that we setup above
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        assertEquals(recipes.size(), argumentCaptor.getValue().size());
    }

    private Set<Recipe> setUpRecipeData() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        assertEquals(1, recipes.size());
        return recipes;
    }
}