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
        firstRecipe.setNamePicture("The AB mix");
        
        System.out.println(firstRecipe.toString());
        
        try{
            firstRecipe.writeRecipeJson();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(EmptyTitleException ex){
        }
        try{
            firstRecipe.readRecipeJson();
            System.out.println("\n"+firstRecipe.toString());
        }
        catch(IOException ex){
            
        }
        catch(InvalidIndex ex){
            ex.printStackTrace();
        }
    }
}
