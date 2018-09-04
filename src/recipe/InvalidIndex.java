/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * InvalidIndex exception thrown when the index receives
 * creates an exception when reading an invalid index that
 * does not fit with the array.
 * @author user
 */
public class InvalidIndex extends Exception{
    public InvalidIndex(){
        System.err.println("Invalid index inputted.");
    }
}
