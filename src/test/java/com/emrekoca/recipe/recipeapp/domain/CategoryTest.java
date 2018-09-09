package com.emrekoca.recipe.recipeapp.domain;

import com.emrekoca.recipe.recipeapp.model.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Emre.
 */

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception{
        Long id = 4L;
        category.setId(id);
        Assert.assertEquals(id, category.getId());
    }


}
