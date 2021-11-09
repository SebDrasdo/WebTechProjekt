package de.htwberlin.webtech.web.api;

public class RecipeCreateOrUpdateRequest {

    private String recipeName;
    private String description;
    private boolean vegan;

    public RecipeCreateOrUpdateRequest(String recipeName, String description, boolean vegan) {
        this.recipeName = recipeName;
        this.description = description;
        this.vegan = vegan;
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

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
}
