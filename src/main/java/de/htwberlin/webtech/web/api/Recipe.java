package de.htwberlin.webtech.web.api;

public class Recipe {

    private long id;
    private String recipeName;
    private String description;
    private boolean vegan;

    public Recipe(long id, String recipeName, String description, boolean vegan) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.vegan = vegan;
    }

    public long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
}
