/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import gui.RecipeObjectGUI;
import gui.TopBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import javafx.scene.layout.StackPane;
import recipe.RecipeBuilder;
import recipe.InvalidIndex;
/**
 *
 * @author user
 */

/*
This class will grab all the recipes to make the search for recipes' ingredients easy.
The parameter recipes will be very useful later on.
*/
public class GetRecipes extends Thread{
    private static LinkedList<RecipeBuilder> recipes;
    private static String path = ".\\src\\recipe_storage\\Recipes";
    private static StackPane[] recipeObjects;
    
    public void run(){
        File folder = new File(path);
        //System.out.println("IS FOLDER DIRECTORY? "+folder.isDirectory());
        recipes = new LinkedList<>();
        for (File fileName : folder.listFiles()) {
            try{
                if(!fileName.getName().startsWith("README"))
                    recipes.add(new RecipeBuilder(fileName.getName()).readRecipeJson());
            }
            catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            catch(InvalidIndex ex){
                ex.printStackTrace();
            }
        }
        
        collectRecipeGUIs();
    }
    
    private static void collectRecipeGUIs(){
        recipeObjects = new StackPane[GetRecipes.recipes.size()];
        for(int i=0;i<GetRecipes.recipes.size();i++){
            recipeObjects[i]=RecipeObjectGUI.getRecipeObject(GetRecipes.recipes.get(i));
        }
    }
    
    public static StackPane[] getRecipesGUIObjects(){
        return recipeObjects;
    }
    
    public static LinkedList<RecipeBuilder> getRecipes(){
        return recipes;
    }

}
