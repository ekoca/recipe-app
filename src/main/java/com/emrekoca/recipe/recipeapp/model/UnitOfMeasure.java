package com.emrekoca.recipe.recipeapp.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Emre.
 */
@Data
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
