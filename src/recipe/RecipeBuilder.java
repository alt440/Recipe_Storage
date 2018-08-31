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
    public void setNamePicture(String titleRecipe){
        recipeToBuild.getRecipePicture().setName(titleRecipe);
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
    
    public String toString(){
        return recipeToBuild.toString();
    }
}
