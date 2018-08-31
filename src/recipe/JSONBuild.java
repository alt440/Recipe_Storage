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

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  

/*
This class is used to save the recipes as JSON objects for further consultation,
even after the program has closed.
*/

public class JSONBuild {
    
    private JSONBuild(){
        
    }
    
    public static void writeJSON(Recipe recipe) throws IOException, EmptyTitleException { 
      
      /*
        Condition made because the title is used to set the name of the JSON
      */
      if(recipe.getTitle() == null || recipe.getTitle().equals(""))
          throw new EmptyTitleException();
        
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      FileWriter writer = new FileWriter(recipe.getTitle()+".json");   
      writer.write(gson.toJson(recipe));   
      writer.close(); 
      
   }  
   public static Recipe readJSON(String recipeName) throws FileNotFoundException { 
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      BufferedReader bufferedReader = new BufferedReader(
         new FileReader(recipeName+".json"));   
      
      Recipe recipe = gson.fromJson(bufferedReader, Recipe.class); 
      return recipe; 
   }
    
}
