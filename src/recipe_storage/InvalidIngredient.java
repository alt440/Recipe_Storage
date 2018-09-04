package recipe_storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * InvalidIngredient exception is thrown when an ingredient not from the list of valid
 * ingredients is being added to the fridge.
 * @author user
 */
public class InvalidIngredient extends Exception{
    
    public InvalidIngredient(){
        System.err.println("The ingredient is invalid");
    }
}
