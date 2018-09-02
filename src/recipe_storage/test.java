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
import java.io.IOException;

public class test {
    
    public static void main(String[] args){
        
        
        
        try{
            
            LinkedList<String> ingredientsFridge = FridgeIngredients.getIngredientsInFridge();
            System.out.println(ingredientsFridge.size());
            AllIngredients.addIngredient("abc");
            FridgeIngredients.addToFridge("abc", 3);
            LinkedList<String> ingredients = AllIngredients.getIngredients();
            for(int i=0;i<ingredients.size();i++)
                System.out.println(ingredients.get(i));
            FridgeIngredients.putIngredientsInFile();
            AllIngredients.putIngredientsInFile();
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");
            ex.printStackTrace();
        }
        catch(InvalidQuantity ex){
            ex.printStackTrace();
        }
        catch(InvalidIngredient ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
}
