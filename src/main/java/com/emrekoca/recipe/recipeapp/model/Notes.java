package com.emrekoca.recipe.recipeapp.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Emre.
 */

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    // JPA expect CLOB field in db.
    @Lob
    private String recipeNotes;

    public Notes() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof Notes;
    }

}
