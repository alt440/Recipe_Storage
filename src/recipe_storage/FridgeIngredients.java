package recipe_storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class stores the list of ingredients inside the fridge.
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
public class FridgeIngredients{
    //lets make it simple for now. a to z
    private static LinkedList<String> ingredientsInFridge;
    private static LinkedList<Integer> ingredientsQuantitiesInFridge;
    
    private FridgeIngredients(){
        
    }
    
    //add all the ingredients
    /**
     * Initializes the list of ingredients in the fridge from getting all the ingredients
     * in ingredientsInFridge.txt
     * @throws FileNotFoundException If ingredientsInFridge is not found.
     * @throws IOException 
     */
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
    /**
     * Adds an ingredient with its quantity to the fridge.
     * @param ingredient Name of the ingredient
     * @param quantity Quantity added to the fridge
     * @throws InvalidQuantity If the quantity is zero or less
     * @throws InvalidIngredient If the ingredient does not exist in the list of ingredients
     * @throws FileNotFoundException If ingredientsInFridge is not found.
     * @throws IOException 
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
    
    /**
     * To remove a quantity of an ingredient from the fridge, if not to remove it completely.
     * @param ingredient Name of the ingredient.
     * @param quantity Quantity to be removed from the fridge.
     * @throws InvalidQuantity Quantity greater from what is left in the fridge, or quantity smaller or equal to zero.
     * @throws InvalidIngredient Ingredient that is to be removed that is not in the list of all ingredients.
     * @throws FileNotFoundException If the ingredientsInFridge file is not found.
     * @throws IOException 
     */
    public static void removeFromFridge(String ingredient, int quantity) throws InvalidQuantity, InvalidIngredient, FileNotFoundException, IOException{
        
        int index = ingredientsInFridge.indexOf(ingredient);
        
        if(quantity > ingredientsQuantitiesInFridge.get(index) || quantity <= 0)
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
    
    /**
     * To get the list of ingredients in the fridge, and also initializes the list if it's not already done.
     * @return The list of ingredients in the fridge.
     * @throws FileNotFoundException If the file ingredientsInFridge is not found.
     * @throws IOException 
     */
    public static LinkedList<String> getIngredientsInFridge() throws FileNotFoundException, IOException{
        /*
        Is this the right implementation? https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
        I feel like this could slow down the application first time it is used.
        */
        if(ingredientsInFridge == null)
            fillIngredientsList();
        return ingredientsInFridge; 
    }
    
    /**
     * Returns the quantity of an ingredient in the fridge as an integer.
     * @param ingredient The ingredient queried.
     * @return The integer representing the quantity of the ingredient.
     */
    public static Integer getIngredientQuantityInFridge(String ingredient){
        int quantityIngredient = ingredientsInFridge.indexOf(ingredient);
        return ingredientsQuantitiesInFridge.get(quantityIngredient);
    }
    
    /**
     * The list of ingredients from the fridge are put into the file storing the list of ingredients from the fridge.
     * Still needs the sorting before putting into a file. Both quantity and name of ingredients
     * must be sorted.
     * @throws FileNotFoundException If ingredientsInFridge.txt is not found.
     * @throws IOException 
     */
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
