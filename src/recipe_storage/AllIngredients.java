package recipe_storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
/**
 * This class stores all the ingredients from the file ingredients.txt. 
 * It is used to access and modify the list of ingredients.
 * @author user
 */
public class AllIngredients {
    
    private static LinkedList<String> listIngredients;
    
    /**
     * This is the singleton constructor for the AllIngredients class.
     */
    private AllIngredients(){
        
    }
    
    //to fill the linkedList. There must be a better way than to individually 
    //add all the ingredients
    /**
     * Unefficient way of adding ingredients to the program, because adding as LinkedList.
     * Uses the file at src/recipe_storage/Ingredients/ingredients.txt for reference
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static void fillIngredientsList() throws FileNotFoundException, IOException{
        /*for now reading from file, but this is insecure.*/
        if(listIngredients == null){
            listIngredients = new LinkedList<String>();
        }
        
        File ingredientsListing = new File(".\\src\\recipe_storage\\Ingredients\\ingredients.txt");
        
        if(!ingredientsListing.exists())
            ingredientsListing.createNewFile();
        
        Scanner ingredientsReader = new Scanner(ingredientsListing);
        while(ingredientsReader.hasNextLine()){
            listIngredients.add(ingredientsReader.nextLine());
        }
        
        //close scanner
        ingredientsReader.close();
        
        //sort the LinkedList
        Collections.sort(listIngredients);
    }
    
    /**
     * Finds ingredients beginning with string a.
     * @param a String that we are looking for at the beginning of the ingredients.
     * @return ArrayList of all the possible strings.
     */
    public static ArrayList<String> getIngredientBeginningWith(String a){
        
        ArrayList<String> relevantMatches = new ArrayList<>();
        
        for(int i=0;i<listIngredients.size();i++){
            if(listIngredients.get(i).startsWith(a))
                relevantMatches.add(listIngredients.get(i));
        }
        
        return relevantMatches;
    }
    
    /**
     * Gets all the ingredients containing the string a.
     * @param a String that serves as a reference.
     * @return All the ingredients containing the string a as an ArrayList.
     */
    public static ArrayList<String> getIngredientsContaining(String a){
        
        ArrayList<String> relevantMatches = new ArrayList<>();
        
        for(int i=0;i<listIngredients.size();i++){
            if(listIngredients.get(i).contains(a)){
                relevantMatches.add(listIngredients.get(i));
            }
        }
        
        return relevantMatches;
    }
    
    /**
     * Gets the list of ingredients, and if not initialized, then initialize the list at the same time.
     * 
     * @return List of ingredients
     * @throws FileNotFoundException If the file ingredients.txt is not found.
     * @throws IOException 
     */
    public static LinkedList<String> getIngredients() throws FileNotFoundException, IOException{
        /*
        Is this the right implementation? https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
        I feel like this could slow down the application first time it is used.
        */
        if(listIngredients == null){
            fillIngredientsList();
        }
        return listIngredients; 
    }
    
    /**
     * Adds an ingredient to the already existing list of ingredients. Important because
     * cannot add an ingredient to the fridge if it does not exist.
     * @param ingredient Ingredient being added to the list.
     * @throws FileNotFoundException If ingredient.txt is not found.
     * @throws IOException 
     */
    public static void addIngredient(String ingredient) throws FileNotFoundException, IOException{
        if(listIngredients == null){
            fillIngredientsList();
        }
        if(!listIngredients.contains(ingredient)){
            listIngredients.add(ingredient);
        }
        else{
            System.err.println("Ingredient already in list.");
        }
    }
    
    /**
     * To remove an ingredient from the list, but not secure because could just remove them
     * all.
     * @param ingredient Ingredient to be removed from the list.
     * @throws FileNotFoundException If ingredients.txt is not found.
     * @throws IOException 
     */
    public static void removeIngredient(String ingredient) throws FileNotFoundException, IOException{
        /*not secure. i would like to conserve every ingredient in the original listing.
        Only personalized ingredients can be deleted.*/
        
        if(listIngredients == null)
            fillIngredientsList();
        
        if(listIngredients.contains(ingredient))
            listIngredients.remove(ingredient);
        else
            System.err.println("Ingredient not found");
    }
    
    /**
     * This method puts the modified or unmodified list of ingredients back into ingredients.txt.
     * @throws FileNotFoundException If ingredients.txt is not found.
     * @throws IOException 
     */
    public static void putIngredientsInFile() throws FileNotFoundException, IOException{
        File ingredientsListing = new File(".\\src\\recipe_storage\\Ingredients\\ingredients.txt");
        
        if(!ingredientsListing.exists())
            ingredientsListing.createNewFile();
        
        PrintWriter ingredientsToFile = new PrintWriter(ingredientsListing);
        
        //sorting array before storing
        Collections.sort(listIngredients);
        
        for(int i=0;i<listIngredients.size();i++){
            ingredientsToFile.println(listIngredients.get(i));
        }
        
        ingredientsToFile.close();
    }
}
