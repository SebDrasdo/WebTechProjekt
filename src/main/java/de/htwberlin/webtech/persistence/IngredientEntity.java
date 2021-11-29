package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Column (name = "price", nullable = false)
    private Float price;

    @Column (name = "calories")
    private Long calories;

    @Column (name = "vegan")
    private Boolean vegan;

    public IngredientEntity(String ingredientName, Float price, Long calories, Boolean vegan) {

        this.ingredientName = ingredientName;
        this.price = price;
        this.calories = calories;
        this.vegan = vegan;
    }

    protected IngredientEntity() {}

    public Long getId() {
        return id;
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

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

}

