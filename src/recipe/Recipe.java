/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * Recipe class holds every information each recipe object needs.
 * Rating, title, picture, instructions, summary, ingredients.
 * @author user
 */
import java.util.LinkedList; 

public class Recipe implements RecipeInterface{
    
    private String title;
    private Picture recipePicture;
    private Instructions instructions;
    private Summary summary;
    private LinkedList<Ingredient> ingredients = new LinkedList<>();
    private int rating = 10; //set the default rating of 10/10
    
    /**
     * Default constructor that initializes the picture, instructions, and summary object.
     */
    public Recipe(){
        recipePicture = new Picture();
        instructions = new Instructions();
        summary = new Summary();
    }
    
    /**
     * Sets the title for the recipe.
     * @param title The title set for the recipe.
     */
    public void setTitle(String title){
        this.title = title;
    }
    
    /**
     * Gets the title of the recipe.
     * @return The title of the recipe.
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Gets the rating of the recipe.
     * @return The rating of the recipe on 10.
     */
    public int getRating(){
        return this.rating;
    }
    
    /**
     * Gets the picture object associated with the recipe.
     * @return Gets the picture object associated with the recipe.
     */
    public Picture getRecipePicture(){
        return recipePicture;
    }
    
    /**
     * Gets the instructions object associated with the recipe.
     * @return Gets the instructions object associated with the recipe.
     */
    public Instructions getRecipeInstructions(){
        return instructions;
    }
    
    /**
     * Clears all the instructions that were set for the recipe.
     */
    public void clearRecipeInstructions(){
        instructions.clearInstructions();
    }
    
    /**
     * Gets the summary object for the recipe.
     * @return 
     */
    public Summary getRecipeSummary(){
        return summary;
    }
    
    /**
     * Clears the summary for the recipe.
     */
    public void clearRecipeSummary(){
        summary.clearSummary();
    }
    
    /**
     * Gets the linkedlist containing all the ingredients of the recipe.
     * @return The linkedlist containing all the ingredients
     */
    public LinkedList<Ingredient> getIngredients(){
        return ingredients;
    }
    
    /**
     * Clears the linkedlist containing all the ingredients.
     */
    public void clearIngredients(){
        ingredients.clear();
    }
    
    /*
    need to check validity of number
    */
    /**
     * Removes an ingredient from the linkedlist containing all of the ingredients.
     * @param number The index of the ingredient being removed.
     * @throws InvalidIndex If the index is invalid for the linkedlist.
     */
    public void removeIngredient(int number) throws InvalidIndex{
        if(number < 1 || number > ingredients.size()){
            throw new InvalidIndex();
        }
        
        ingredients.remove(number-1);
    }
    
    /**
     * Sets the rating for the recipe
     * @param ratingGiven Rating on 10 given for the recipe.
     */
    public void setRating(int ratingGiven){
        this.rating = ratingGiven;
    }
    
    /**
     * Returns a string representing the whole recipe.
     * @return String including all the information of the recipe.
     */
    public String toString(){
        String allIngredients = "";
        for (int i=0;i<ingredients.size();i++){
            allIngredients+=ingredients.get(i).toString();
        }
        if(ingredients.size()==0)
            allIngredients = "No ingredients";
        
        return "Title: "+title+"\n\n"+recipePicture.toString()+"\n"+summary.toString()+
                instructions.toString()+"\nIngredients: \n"+allIngredients;
    }
}
