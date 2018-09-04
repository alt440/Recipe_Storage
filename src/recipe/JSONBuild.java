/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * JSONBuild class allows to read and write JSON
 * objects, used especially for the reading and writing
 * of recipes.
 * @author user
 */
import java.io.IOException;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.File;

import java.util.LinkedList;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  

/*
This class is used to save the recipes as JSON objects for further consultation,
even after the program has closed.
*/

public class JSONBuild {
    private static String pathToJson = ".\\src\\recipe_storage\\Recipes\\";
    private static String folderOfJson = ".\\src\\recipe_storage\\Recipes";
    
    private JSONBuild(){
        
    }
    
    /*
    This method will be used to determine if the new recipe object that is going
    to be written is Json is unique to avoid any conflict with resources of a 
    different recipe.
    */
    /**
     * Determines if the title is unique to make sure there is no
     * conflict between a recipe's resources and another's.
     * @param title The title that is going to be identified to be valid or not.
     * @return Whether the title is valid or not.
     */
    private static boolean isTitleValid(String title) {
        File folder = new File(folderOfJson);
        System.out.println("IS FOLDER DIRECTORY? "+folder.isDirectory());
        for (String fileName : folder.list()) { 
            System.out.println("Files in folder: " +fileName);
            if(fileName.equals(title))
                return false;
        }
        return true;
    }
    
    /**
     * Writes a recipe object into a JSON object.
     * @param recipe The recipe object that is going to be put into JSON
     * @throws IOException
     * @throws EmptyTitleException If the recipe has no title, exception thrown.
     * @throws UniqueTitleException If the recipe has a title common to another recipe, exception thrown.
     */
    public static void writeJSON(Recipe recipe) throws IOException, EmptyTitleException, UniqueTitleException { 
      
      /*
        Condition made because the title is used to set the name of the JSON
      */
      if(recipe.getTitle() == null || recipe.getTitle().equals(""))
          throw new EmptyTitleException();
      
      if(!isTitleValid(recipe.getTitle()))
          throw new UniqueTitleException();
        
      
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      FileWriter writer = new FileWriter(pathToJson+recipe.getTitle()+".json");   
      writer.write(gson.toJson(recipe));   
      writer.close(); 
      
   }  
    
   /*
    We do not add the extension at the end of the string of filereader because
    this method is only used when we give the file.getName() string as parameter.
    */ 
    /**
     * Reads a JSON object that represents a recipe object.
     * @param recipeName A string representing the recipe's title to read the recipe.
     * @return The recipe object with the same name as the recipe.
     * @throws FileNotFoundException If the file is not found, exception thrown.
     */
    public static Recipe readJSON(String recipeName) throws FileNotFoundException { 
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      BufferedReader bufferedReader = new BufferedReader(
         new FileReader(pathToJson+recipeName));   
      
      Recipe recipe = gson.fromJson(bufferedReader, Recipe.class); 
      return recipe; 
   }
    
}
