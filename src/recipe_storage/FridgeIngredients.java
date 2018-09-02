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
import java.io.File;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
/*
Singleton
*/
/*
To increase efficiency, could make one copy of both linkedlists so 
that when comes time to save the list of ingredients it only saves 
those that are not in both lists.
*/
public class FridgeIngredients extends AllIngredients{
    //lets make it simple for now. a to z
    private static LinkedList<String> ingredientsInFridge;
    private static LinkedList<Integer> ingredientsQuantitiesInFridge;
    
    private FridgeIngredients(){
        
    }
    
    //add all the ingredients
    private static void fillIngredientsList() throws FileNotFoundException, IOException{
        /*for now reading from file, but this is insecure.*/
        if(ingredientsInFridge == null){
            ingredientsInFridge = new LinkedList<>();
            ingredientsQuantitiesInFridge = new LinkedList<>();
        }
        
        File ingredientsListing = new File(".\\src\\recipe_storage\\Ingredients\\ingredientsInFridge.txt");
        
        if(!ingredientsListing.exists())
            ingredientsListing.createNewFile();
        
        Scanner ingredientsReader = new Scanner(ingredientsListing);
        while(ingredientsReader.hasNextLine()){
            ingredientsInFridge.add(ingredientsReader.nextLine());
        }
        
        //close scanner
        ingredientsReader.close();
        
        //sort the LinkedList
        Collections.sort(ingredientsInFridge);
        
        for(int i=0;i<ingredientsInFridge.size();i++){
            String[] object = ingredientsInFridge.get(i).split(" ");
            ingredientsInFridge.set(i, object[0]);
            ingredientsQuantitiesInFridge.add(Integer.parseInt(object[1]));
        }
    }
    
    /*
    Must be some input validation to avoid any bad input of some ingredient
    that is not present in the list of ingredients, or quantity is below or equal
    to zero.
    */
    public static void addToFridge(String ingredient, int quantity) throws InvalidQuantity, InvalidIngredient, FileNotFoundException, IOException{
        if(quantity<=0)
            throw new InvalidQuantity();
        
        /*
        Every ingredient shall be added to the list of ingredients before being added in the fridge.
        */
        if(!AllIngredients.getIngredients().contains(ingredient))
            throw new InvalidIngredient();
            
        if(ingredientsInFridge.contains(ingredient)){
            int index = ingredientsInFridge.indexOf(ingredient);
            int quantityInFridge = ingredientsQuantitiesInFridge.get(index);
            ingredientsQuantitiesInFridge.set(index, quantityInFridge+quantity);
            /*
            For debug purposes
            */
            System.out.println(ingredientsQuantitiesInFridge.get(index));
        }
        else{
            ingredientsInFridge.add(ingredient);
            ingredientsQuantitiesInFridge.add(quantity);
        }
    }
    
    public static void removeFromFridge(String ingredient, int quantity) throws InvalidQuantity, InvalidIngredient, FileNotFoundException, IOException{
        
        int index = ingredientsInFridge.indexOf(ingredient);
        
        if(quantity > ingredientsQuantitiesInFridge.get(index))
            throw new InvalidQuantity();
        
        if(!AllIngredients.getIngredients().contains(ingredient))
            throw new InvalidIngredient();
        
        else if(quantity == ingredientsQuantitiesInFridge.get(index)){
            ingredientsQuantitiesInFridge.remove(index);
            ingredientsInFridge.remove(index);
        }
        
        else if(quantity < ingredientsQuantitiesInFridge.get(index)){
            int quantityIngredient = ingredientsQuantitiesInFridge.get(index);
            quantityIngredient-=quantity;
            ingredientsQuantitiesInFridge.set(index, quantityIngredient);
        }
        
    }
    
    public static LinkedList<String> getIngredientsInFridge() throws FileNotFoundException, IOException{
        /*
        Is this the right implementation? https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
        I feel like this could slow down the application first time it is used.
        */
        if(ingredientsInFridge == null)
            fillIngredientsList();
        return ingredientsInFridge; 
    }
    
    public static Integer getIngredientQuantityInFridge(String ingredient){
        int quantityIngredient = ingredientsInFridge.indexOf(ingredient);
        return ingredientsQuantitiesInFridge.get(quantityIngredient);
    }
    
    public static void putIngredientsInFile() throws FileNotFoundException, IOException{
        File ingredientsListing = new File(".\\src\\recipe_storage\\Ingredients\\ingredientsInFridge.txt");
        
        if(!ingredientsListing.exists())
            ingredientsListing.createNewFile();
        
        PrintWriter ingredientsToFile = new PrintWriter(ingredientsListing);
        
        //sorting array before putting it in a file
        
        
        for(int i=0;i<ingredientsInFridge.size();i++){
            ingredientsToFile.println(ingredientsInFridge.get(i)+" "+ingredientsQuantitiesInFridge.get(i));
        }
        
        ingredientsToFile.close();
    }
}
