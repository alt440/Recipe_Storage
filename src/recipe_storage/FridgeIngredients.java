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
import java.io.FileNotFoundException;
/*
Singleton
*/
public class FridgeIngredients extends AllIngredients{
    //lets make it simple for now. a to z
    private static LinkedList<String> ingredientsInFridge;
    private static LinkedList<Integer> ingredientsQuantitiesInFridge;
    
    private FridgeIngredients(){
        
    }
    
    /*
    Must be some input validation to avoid any bad input of some ingredient
    that is not present in the list of ingredients, or quantity is below or equal
    to zero.
    */
    public static void addToFridge(String ingredient, int quantity) throws InvalidQuantity, InvalidIngredient, FileNotFoundException{
        if(quantity<=0)
            throw new InvalidQuantity();
        
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
    
    public static void removeFromFridge(String ingredient, int quantity) throws InvalidQuantity, InvalidIngredient, FileNotFoundException{
        
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
    
    public static LinkedList<String> getIngredientsInFridge(){
        /*
        Is this the right implementation? https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
        I feel like this could slow down the application first time it is used.
        */
        if(ingredientsInFridge == null)
            ingredientsInFridge = new LinkedList<String>();
        return ingredientsInFridge; 
    }
    
    public static Integer getIngredientQuantityInFridge(String ingredient){
        int quantityIngredient = ingredientsInFridge.indexOf(ingredient);
        return ingredientsQuantitiesInFridge.get(quantityIngredient);
    }
}
