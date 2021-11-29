package de.htwberlin.webtech.web.api;

public class IngredientCreateOrUpdateRequest {

    private String ingredientName;
    private Float price;
    private Long calories;
    private boolean vegan;

    public IngredientCreateOrUpdateRequest(String IngredientName, Float price, Long calories, boolean vegan) {
        this.ingredientName = ingredientName;
        this.price = price;
        this.calories = calories;
        this.vegan = vegan;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
}
