/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * Ingredient objects store the name, quantity, and unit of measure
 * of an ingredient inside a recipe.
 * @author user
 */
public class Ingredient extends Recipe{
    private String nameIngredient;
    private double quantity;
    private String unitOfMeasure;
    
    /**
     * Initializes an ingredient with all the necessary parameters.
     * @param ingredient Name of the ingredient
     * @param quantity Quantity of the ingredient
     * @param unitOfMeasure Unit of measure relating to the quantity
     */
    public Ingredient(String ingredient, double quantity, String unitOfMeasure){
        this.nameIngredient = ingredient;
        this.unitOfMeasure = unitOfMeasure;
        this.quantity = quantity;
    }
    
    /**
     * Sets the ingredient with all the necessary parameters.
     * @param ingredient Name of the ingredient
     * @param quantity Quantity of the ingredient
     * @param unitOfMeasure Unit of measure relating to the quantity of the ingredient
     */
    public void setIngredient(String ingredient, double quantity, String unitOfMeasure){
        this.nameIngredient = ingredient;
        this.unitOfMeasure = unitOfMeasure;
        this.quantity = quantity;
    }
    
    /**
     * Sets the name of the ingredient.
     * @param ingredient Name of the ingredient
     */
    public void setIngredientName(String ingredient){
        this.nameIngredient = ingredient;
    }
    
    /**
     * Sets the unit of measure relating to the quantity.
     * @param unitOfMeasure Unit of measure relating to the quantity.
     */
    public void setUnitMeasure(String unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
    }
    
    /**
     * Sets the quantity of the ingredient.
     * @param quantity Quantity of the ingredient.
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * Gets the ingredient's name.
     * @return 
     */
    public String getIngredientName(){
        return nameIngredient;
    }
    
    /**
     * Gets the ingredient's quantity.
     * @return 
     */
    public double getIngredientQuantity(){
        return quantity;
    }
    
    /**
     * Gets the ingredient's unit of measure.
     * @return 
     */
    public String getIngredientUnitMeasure(){
        return unitOfMeasure;
    }
    
    /**
     * Returns a string representing the whole object ingredient.
     * @return 
     */
    public String toString(){
        return nameIngredient+" Quantity: "+quantity+" "+unitOfMeasure+"\n";
    }
}
