/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import recipe.Recipe;
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
    public static LinkedList<RecipeBuilder> recipes;
    private static String path = ".\\src\\recipe_storage\\Recipes";
    
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
        
        /*System.out.println(recipes.size());
        for(int i=0;i<recipes.size();i++)
            System.out.println(recipes.get(i).toString());*/
        
    }
}
