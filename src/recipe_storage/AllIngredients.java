package recipe_storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
/*
This class will facilitate the search of ingredients to be able to add them
easily using the search tool provided to add ingredients to the fridge.
*/
/*
NOTE: could also add expiration dates
NOTE: could use design patterns for this project
*/
public class AllIngredients {
    
    private static LinkedList<String> listIngredients;
    
    protected AllIngredients(){
        
    }
    
    //to fill the linkedList. There must be a better way than to individually 
    //add all the ingredients
    private static void fillIngredientsList() throws FileNotFoundException{
        /*for now reading from file, but this is insecure.*/
        if(listIngredients == null){
            listIngredients = new LinkedList<String>();
        }
        
        File ingredientsListing = new File(".\\src\\ingredients.txt");
        
        Scanner ingredientsReader = new Scanner(ingredientsListing);
        while(ingredientsReader.hasNextLine()){
            listIngredients.add(ingredientsReader.nextLine());
        }
        
        //sort the LinkedList
        Collections.sort(listIngredients);
    }
    
    public static ArrayList<String> getIngredientBeginningWith(String a){
        
        ArrayList<String> relevantMatches = new ArrayList<>();
        
        
        
        return relevantMatches;
    }
    
    public static ArrayList<String> getIngredientsContaining(String a){
        
        ArrayList<String> relevantMatches = new ArrayList<>();
        
        for(int i=0;i<listIngredients.size();i++){
            if(listIngredients.get(i).contains(a)){
                relevantMatches.add(listIngredients.get(i));
            }
        }
        
        return relevantMatches;
    }
    
    public static LinkedList<String> getIngredients() throws FileNotFoundException{
        /*
        Is this the right implementation? https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
        I feel like this could slow down the application first time it is used.
        */
        if(listIngredients == null){
            fillIngredientsList();
        }
        return listIngredients; 
    }
    
    public static void addIngredient(String ingredient){
        if(!listIngredients.contains(ingredient)){
            listIngredients.add(ingredient);
        }
        else{
            System.err.println("Ingredient already in list.");
        }
    }
    
    public static void removeIngredient(String ingredient){
        /*not secure. i would like to conserve every ingredient in the original listing.
        Only personalized ingredients can be deleted.*/
        
        if(listIngredients.contains(ingredient))
            listIngredients.remove(ingredient);
        else
            System.err.println("Ingredient not found");
    }
}
