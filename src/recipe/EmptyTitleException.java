/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * The EmptyTitleException is thrown when there is no title
 * given to the recipe, which would result in pictures with 
 * no name, and possible conflict between two recipes with
 * no title.
 * @author user
 */
public class EmptyTitleException extends Exception{
    public EmptyTitleException(){
        System.err.println("The title has not been set.");
    }
}
