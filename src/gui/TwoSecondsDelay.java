/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author user
 */
public class TwoSecondsDelay extends Thread {
    public void run(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
