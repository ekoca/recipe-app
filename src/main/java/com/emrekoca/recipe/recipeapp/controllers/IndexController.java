package com.emrekoca.recipe.recipeapp.controllers;

import com.emrekoca.recipe.recipeapp.Services.RecipeService;
import com.emrekoca.recipe.recipeapp.model.Category;
import com.emrekoca.recipe.recipeapp.model.UnitOfMeasure;
import com.emrekoca.recipe.recipeapp.repositories.CategoryRepository;
import com.emrekoca.recipe.recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by Emre.
 */
@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("/index controller");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
