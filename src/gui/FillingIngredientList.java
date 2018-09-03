/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import recipe_storage.AllIngredients;
import recipe_storage.FridgeIngredients;
/**
 *
 * @author user
 */
public class FillingIngredientList extends Thread {
    private static LinkedList<String> listIngredients;
    private static LinkedList<String> listFridgeIngredients;
    
    public void run(){
        
        try{
            listIngredients = AllIngredients.getIngredients();
            listFridgeIngredients = FridgeIngredients.getIngredientsInFridge();
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
            System.err.println("Error catching ingredients");
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static LinkedList<String> getListIngredients(){
        return listIngredients;
    }
    
    public static LinkedList<String> getListIngredientsInFridge(){
        return listFridgeIngredients;
    }
}
