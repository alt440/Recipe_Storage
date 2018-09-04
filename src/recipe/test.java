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
import java.io.File;

public class test {
    public static void main(String[] args){
        
        RecipeBuilder firstRecipe = new RecipeBuilder();
        firstRecipe.addIngredient("a", 0.5, "lbs");
        firstRecipe.addIngredient("b", 2.2, "ml");
        
        try{
            firstRecipe.addInstruction(1, "Get out a");
            firstRecipe.addInstruction(2, "FUDGE OFF");
        }
        catch(InvalidIndex ex){
            
        }
        
        LinkedList<String> summary = new LinkedList<>();
        summary.add("This recipe is awesome.");
        summary.add("Just like you are awesome.");
        firstRecipe.addSummary(summary);
        
        firstRecipe.setTitle("The AB mix");
        firstRecipe.setRating(8);
        
        //must add the emplacement of the picture
        firstRecipe.setNamePicture("The AB mix", new File(firstRecipe.getPictureURI()+"\\someImg.jpg"));
        
        System.out.println(firstRecipe.toString());
        
        try{
            firstRecipe.writeRecipeJson();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(EmptyTitleException ex){
            ex.printStackTrace();
        }
        catch(UniqueTitleException ex){
            ex.printStackTrace();
        }
        try{
            firstRecipe.readRecipeJson();
            System.out.println("\n"+firstRecipe.toString());
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(InvalidIndex ex){
            ex.printStackTrace();
        }
    }
}
