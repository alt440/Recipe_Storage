/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * The RecipeBuilder class is used to manipulate the 
 * recipe object to more easily change information.
 * @author user
 */

import java.util.LinkedList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

/*
This class is used to more easily build the recipes. In other words, to more easily
access the data fields methods of each object of the recipe class.
*/

public class RecipeBuilder {
    private Recipe recipeToBuild = new Recipe();
    
    /**
     * Basic constructor.
     */
    public RecipeBuilder(){
        
    }
    
    /**
     * Constructor containing the title of the recipe as a parameter.
     * @param title Title of the recipe.
     */
    public RecipeBuilder(String title){
        recipeToBuild.setTitle(title);
    }
    
    /**
     * Grab the recipe object.
     * @return Recipe object from the RecipeBuilder class.
     */
    public Recipe getRecipe(){
        return recipeToBuild;
    }
    
    /**
     * Sets the title of the recipe.
     * @param title Title of the recipe.
     */
    public void setTitle(String title){
        recipeToBuild.setTitle(title);
    }
    
    /**
     * Gets the title of the recipe.
     * @return Title of the recipe.
     */
    public String getTitle(){
        return recipeToBuild.getTitle();
    }
    
    /**
     * Gets the rating of the recipe.
     * @return Rating of the recipe.
     */
    public int getRating(){
        return recipeToBuild.getRating();
    }
    
    /**
     * Sets the rating for the recipe (on 10).
     * @param rating Rating of the recipe on 10
     */
    public void setRating(int rating){
        recipeToBuild.setRating(rating);
    }
    
    /**
     * Add the summary to the recipe.
     * @param summary Summary of the recipe as a LinkedList containing Strings
     */
    public void addSummary(LinkedList<String> summary){
        recipeToBuild.getRecipeSummary().modifySummary(summary);
    }
    
    /**
     * Gets the summary of the recipe in the form of a LinkedList containing Strings.
     * @return The LinkedList that contains all the summary.
     */
    public LinkedList<String> getSummary(){
        return recipeToBuild.getRecipeSummary().getSummary();
    }
    
    /**
     * Sets the picture's file path.
     * @param URI Picture's location in PC.
     */
    public void setPictureURI(String URI){
        recipeToBuild.getRecipePicture().setPictureURI(URI);
    }
    
    /**
     * Get the picture's file path.
     * @return Picture's location in computer.
     */
    public String getPictureURI(){
        return recipeToBuild.getRecipePicture().getPictureURI();
    }
    /*
    Method below not accessible to users. Only used for organization of
    the application.
    */
    /**
     * To rename the picture to that of the title of the recipe.
     * @param titleRecipe The title of the recipe as a string.
     * @param picture The file that is going to be renamed.
     */
    public void setNamePicture(String titleRecipe, File picture){
        recipeToBuild.getRecipePicture().setName(titleRecipe, picture);
    }
    
    /**
     * Gets the instructions object of the recipe.
     * @return The instructions object of the recipe.
     */
    public Instructions getInstructions(){
        return recipeToBuild.getRecipeInstructions();
    }
    
    /**
     * Adds an instruction to the list of instructions of the recipe.
     * @param number Index defining the location of the instruction to be added.
     * @param instruction Instruction that is being added as a string.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void addInstruction(int number, String instruction) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().addInstruction(number, instruction);
    }
    
    /**
     * Modifies an already existing instruction at the location of number.
     * @param number The index of the instruction being modified.
     * @param newInstruction The new instruction as a string.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void modifyInstruction(int number, String newInstruction) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().modifyInstruction(number-1, newInstruction);
    }
    
    /**
     * Gets the instruction at the index number.
     * @param number Represents the index in the list of instructions.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void getInstruction(int number) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().getInstruction(number-1);
    }
    
    /**
     * Removes the instruction at the index number.
     * @param number Represents the index in the list of instructions.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void removeInstruction(int number) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().removeInstruction(number-1);
    }
    
    /**
     * Returns the list of ingredients of the recipe as a linkedlist containing ingredient objects.
     * @return The linkedlist containing ingredient objects.
     */
    public LinkedList<Ingredient> getIngredients(){
        return recipeToBuild.getIngredients();
    }
    
    /**
     * Adds an ingredient to the list of ingredients of the recipe.
     * @param name Name of the ingredient.
     * @param quantity Quantity of the ingredient.
     * @param unit Unit of measure associated with the quantity.
     */
    public void addIngredient(String name, double quantity, String unit){
        recipeToBuild.getIngredients().add(new Ingredient(name, quantity, unit));
    }
    
    /**
     * Modifies the ingredient's name.
     * @param number Index of the ingredient to be modified.
     * @param ingredient Name of the ingredient as a string.
     * @throws InvalidIndex If the index is lower than 0 or greater than the size of the list.
     */
    public void modifyIngredientName(int number, String ingredient) throws InvalidIndex{
        if(number < 1 || number > recipeToBuild.getIngredients().size())
            throw new InvalidIndex();
        
        recipeToBuild.getIngredients().get(number-1).setIngredientName(ingredient);
    }
    
    /**
     * Modifies the ingredient's quantity.
     * @param number Index of the ingredient in the list of ingredients.
     * @param quantity New quantity that is being set for that ingredient
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void modifyIngredientQuantity(int number, double quantity) throws InvalidIndex{
        if(number < 1 || number > recipeToBuild.getIngredients().size())
            throw new InvalidIndex();
        
        recipeToBuild.getIngredients().get(number-1).setQuantity(quantity);
    }
    
    /**
     * Modifies an ingredient's unit of measure.
     * @param number Index of the ingredient in the list of ingredients.
     * @param unit New unit of measure of the ingredient.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void modifyIngredientUnit(int number, String unit) throws InvalidIndex{
        if(number < 1 || number > recipeToBuild.getIngredients().size())
            throw new InvalidIndex();
        
        recipeToBuild.getIngredients().get(number-1).setUnitMeasure(unit);
    }
    
    /**
     * Removes an ingredient from the list of ingredients.
     * @param number Index of the ingredient to remove from the list.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public void removeIngredient(int number) throws InvalidIndex{
        recipeToBuild.removeIngredient(number);
    }
    
    /**
     * Transforms a recipe object to a JSON object.
     * @throws IOException
     * @throws EmptyTitleException If the title is empty.
     * @throws UniqueTitleException If the title is not unique from every other recipe.
     */
    public void writeRecipeJson() throws IOException, EmptyTitleException, UniqueTitleException{
        JSONBuild.writeJSON(recipeToBuild);
    }
    
    /*
    Making a deep copy of the Recipe object received from JSON.
    */
    /**
     * Reads a recipe that was transformed into the JSON format.
     * @return The RecipeBuilder object representing the recipe.
     * @throws FileNotFoundException If the file is not found.
     * @throws InvalidIndex If the index is below 0 or greater than the size of the list.
     */
    public RecipeBuilder readRecipeJson() throws FileNotFoundException, InvalidIndex{
        Recipe recipe = JSONBuild.readJSON(this.getTitle());
        
        //Ingredients
        this.recipeToBuild.clearIngredients();
        
        for(int i=0;i<recipe.getIngredients().size();i++){
            this.addIngredient(recipe.getIngredients().get(i).getIngredientName(),
                    recipe.getIngredients().get(i).getIngredientQuantity(),
                    recipe.getIngredients().get(i).getIngredientUnitMeasure());
        }
        
        //Picture
        this.setPictureURI(recipe.getRecipePicture().getPictureURI());
        this.setNamePicture(recipe.getTitle(), new File(recipe.getRecipePicture().getPictureURI()+"\\"+recipe.getTitle()+".jpg"));
        
        //Instructions
        this.recipeToBuild.clearRecipeInstructions();
        
        for(int i=0;i<recipe.getRecipeInstructions().getInstructions().size();i++){
            this.addInstruction(i+1, recipe.getRecipeInstructions().getInstructions().get(i));
        }
        
        //Summary
        this.recipeToBuild.clearRecipeSummary();
        
        this.addSummary(recipe.getRecipeSummary().getSummary());
        
        //Rating
        this.recipeToBuild.setRating(recipe.getRating());
        
        return this;
    }
    
    /**
     * Returns the string representation of the RecipeBuilder object.
     * @return The string representation of the object.
     */
    public String toString(){
        return recipeToBuild.toString();
    }
}
