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
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

/*
This class is used to more easily build the recipes. In other words, to more easily
access the data fields methods of each object of the recipe class.
*/

public class RecipeBuilder {
    private Recipe recipeToBuild = new Recipe();
    
    public Recipe getRecipe(){
        return recipeToBuild;
    }
    
    public void setTitle(String title){
        recipeToBuild.setTitle(title);
    }
    
    public String getTitle(){
        return recipeToBuild.getTitle();
    }
    
    public int getRating(){
        return recipeToBuild.getRating();
    }
    
    public void setRating(int rating){
        recipeToBuild.setRating(rating);
    }
    
    public void addSummary(LinkedList<String> summary){
        recipeToBuild.getRecipeSummary().modifySummary(summary);
    }
    
    public LinkedList<String> getSummary(){
        return recipeToBuild.getRecipeSummary().getSummary();
    }
    
    public void setPictureURI(String URI){
        recipeToBuild.getRecipePicture().setPictureURI(URI);
    }
    
    public String getPictureURI(){
        return recipeToBuild.getRecipePicture().getPictureURI();
    }
    /*
    Method below not accessible to users. Only used for organization of
    the application.
    */
    public void setNamePicture(String titleRecipe, File picture){
        recipeToBuild.getRecipePicture().setName(titleRecipe, picture);
    }
    
    public Instructions getInstructions(){
        return recipeToBuild.getRecipeInstructions();
    }
    
    public void addInstruction(int number, String instruction) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().addInstruction(number, instruction);
    }
    
    public void modifyInstruction(int number, String newInstruction) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().modifyInstruction(number-1, newInstruction);
    }
    
    public void getInstruction(int number) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().getInstruction(number-1);
    }
    
    public void removeInstruction(int number) throws InvalidIndex{
        recipeToBuild.getRecipeInstructions().removeInstruction(number-1);
    }
    
    public LinkedList<Ingredient> getIngredients(){
        return recipeToBuild.getIngredients();
    }
    
    public void addIngredient(String name, double quantity, String unit){
        recipeToBuild.getIngredients().add(new Ingredient(name, quantity, unit));
    }
    
    public void modifyIngredientName(int number, String ingredient) throws InvalidIndex{
        if(number < 1 || number > recipeToBuild.getIngredients().size())
            throw new InvalidIndex();
        
        recipeToBuild.getIngredients().get(number-1).setIngredientName(ingredient);
    }
    
    public void modifyIngredientQuantity(int number, double quantity) throws InvalidIndex{
        if(number < 1 || number > recipeToBuild.getIngredients().size())
            throw new InvalidIndex();
        
        recipeToBuild.getIngredients().get(number-1).setQuantity(quantity);
    }
    
    public void modifyIngredientUnit(int number, String unit) throws InvalidIndex{
        if(number < 1 || number > recipeToBuild.getIngredients().size())
            throw new InvalidIndex();
        
        recipeToBuild.getIngredients().get(number-1).setUnitMeasure(unit);
    }
    
    public void removeIngredient(int number) throws InvalidIndex{
        recipeToBuild.removeIngredient(number);
    }
    
    public void writeRecipeJson() throws IOException, EmptyTitleException, UniqueTitleException{
        JSONBuild.writeJSON(recipeToBuild);
    }
    
    /*
    Making a deep copy of the Recipe object received from JSON.
    */
    public Recipe readRecipeJson() throws FileNotFoundException, InvalidIndex{
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
        
        return recipeToBuild;
    }
    
    public String toString(){
        return recipeToBuild.toString();
    }
}
