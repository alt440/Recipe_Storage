/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 *
 * @author user
 */
public class Ingredient extends Recipe{
    private String nameIngredient;
    private double quantity;
    private String unitOfMeasure;
    
    public Ingredient(String ingredient, double quantity, String unitOfMeasure){
        this.nameIngredient = ingredient;
        this.unitOfMeasure = unitOfMeasure;
        this.quantity = quantity;
    }
    
    public void setIngredient(String ingredient, double quantity, String unitOfMeasure){
        this.nameIngredient = ingredient;
        this.unitOfMeasure = unitOfMeasure;
        this.quantity = quantity;
    }
    
    public void setIngredientName(String ingredient){
        this.nameIngredient = ingredient;
    }
    
    public void setUnitMeasure(String unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
    }
    
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    public String getIngredientName(){
        return nameIngredient;
    }
    
    public double getIngredientQuantity(){
        return quantity;
    }
    
    public String getIngredientUnitMeasure(){
        return unitOfMeasure;
    }
    
    
}
