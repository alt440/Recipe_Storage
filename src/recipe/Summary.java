/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * Used for developing the summary of the recipe.
 * @author user
 */
import java.util.LinkedList;
/*
This way of inputting information needs to be modified. Not efficient.
*/


public class Summary {
    private LinkedList<String> summary = new LinkedList<>();
    
    /**
     * To modify the summary for a different content.
     * @param newSummary LinkedList containing all the text that is going to be in the summary.
     */
    public void modifySummary(LinkedList<String> newSummary){
        this.summary = newSummary;
    }
    
    /**
     * Gets the whole summary of the recipe.
     * @return The linkedlist containing the summary.
     */
    public LinkedList<String> getSummary(){
        return this.summary;
    }
    
    /**
     * Empties the summary.
     */
    public void clearSummary(){
        summary.clear();
    }
    
    /**
     * The string representation of the summary.
     * @return The string representation of the whole summary.
     */
    public String toString(){
        String allSummary = "";
        for (int i=0;i<summary.size();i++){
            allSummary+= summary.get(i)+"\n";
        }
        if(summary.size()==0)
            return "Summary: No Summary";
        
        return "Summary: \n"+allSummary+"\n";
    }
}
