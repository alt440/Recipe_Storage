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

public class test {
    
    public static void main(String[] args){
        
        LinkedList<String> ingredientsFridge = FridgeIngredients.getIngredientsInFridge();
        System.out.println(ingredientsFridge.size());
        
        try{
        LinkedList<String> ingredients = AllIngredients.getIngredients();
        for(int i=0;i<ingredients.size();i++)
            System.out.println(ingredients.get(i));
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");
        }
        
        
    }
}
