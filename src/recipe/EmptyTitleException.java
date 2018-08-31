/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 *
 * @author user
 */
public class EmptyTitleException extends Exception{
    public EmptyTitleException(){
        System.err.println("The title has not been set.");
    }
}
