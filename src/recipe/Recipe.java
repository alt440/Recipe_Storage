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
import java.util.LinkedList; 

public class Recipe implements RecipeInterface{
    
    private String title;
    private Picture recipePicture;
    private Instructions instructions;
    private Summary summary;
    private LinkedList<Ingredient> ingredients;
    
    public Recipe(){
        recipePicture = new Picture();
        instructions = new Instructions();
        summary = new Summary();
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public Picture getRecipePicture(){
        return recipePicture;
    }
    
    public Instructions getRecipeInstructions(){
        return instructions;
    }
    
    public Summary getRecipeSummary(){
        return summary;
    }
    
    public LinkedList<Ingredient> getIngredients(){
        return ingredients;
    }
    
    /*
    need to check validity of number
    */
    public void removeIngredient(int number) throws InvalidIndex{
        if(number < 1 || number > ingredients.size()){
            throw new InvalidIndex();
        }
        
        ingredients.remove(number-1);
    }
}
