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
public class StopWatch {
    private long startTime;
    private long endTime;
    
    public void start(){
        startTime = System.currentTimeMillis();
    }
    
    public void end(){
        endTime = System.currentTimeMillis();
    }
    
    public double secondsElapsed(){
        return (System.currentTimeMillis()-startTime)/1000;
    }
}
