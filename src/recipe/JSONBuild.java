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
    
    public static void writeJSON(Recipe recipe) throws IOException, EmptyTitleException, UniqueTitleException { 
      
      /*
        Condition made because the title is used to set the name of the JSON
      */
      if(recipe.getTitle() == null || recipe.getTitle().equals(""))
          throw new EmptyTitleException();
      
      if(!isTitleValid(recipe.getTitle()))
          throw new UniqueTitleException();
        
      System.out.println("Reach here?");
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      FileWriter writer = new FileWriter(pathToJson+recipe.getTitle()+".json");   
      writer.write(gson.toJson(recipe));   
      writer.close(); 
      
   }  
   public static Recipe readJSON(String recipeName) throws FileNotFoundException { 
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      BufferedReader bufferedReader = new BufferedReader(
         new FileReader(pathToJson+recipeName+".json"));   
      
      Recipe recipe = gson.fromJson(bufferedReader, Recipe.class); 
      return recipe; 
   }
    
}
