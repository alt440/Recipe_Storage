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
public class InvalidQuantity extends Exception{
    
    public InvalidQuantity(){
        System.err.println("Invalid quantity of ingredient");
    }
}
