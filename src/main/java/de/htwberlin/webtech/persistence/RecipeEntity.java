package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity (name = "recipes")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "recipe_name", nullable = false)
    private String recipeName;

    @Column (name = "description", nullable = false)
    private String description;

    @Column (name = "vegan")
    private Boolean vegan;

    public RecipeEntity(String recipeName, String description, Boolean vegan) {

        this.recipeName = recipeName;
        this.description = description;
        this.vegan = vegan;
    }

    protected RecipeEntity() {}

    public Long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

}
