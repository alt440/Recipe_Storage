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
public class UniqueTitleException extends Exception{
    public UniqueTitleException(){
        System.err.println("Please change your title. It has already been used.");
    }
}
