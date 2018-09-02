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
import java.util.LinkedList;
/*
This way of inputting information needs to be modified. Not efficient.
*/


public class Summary {
    private LinkedList<String> summary = new LinkedList<>();
    
    public void modifySummary(LinkedList<String> newSummary){
        this.summary = newSummary;
    }
<<<<<<< HEAD
    
    public LinkedList<String> getSummary(){
        return this.summary;
=======
    
    public LinkedList<String> getSummary(){
        return this.summary;
    }
    
    public void clearSummary(){
        summary.clear();
    }
    
    public String toString(){
        String allSummary = "";
        for (int i=0;i<summary.size();i++){
            allSummary+= summary.get(i)+"\n";
        }
        if(summary.size()==0)
            return "Summary: No Summary";
        
        return "Summary: \n"+allSummary+"\n";
>>>>>>> recipeBuilder
    }
}
