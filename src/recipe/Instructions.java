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
The way to store instructions is not good enough. Needs to be thought of
    again.
The index of the instruction will give away the number attributed to the instruction.
The number will be added later in case an instruction gets deleted during the process.
*/

public class Instructions {
    private LinkedList<String> instructions = new LinkedList<>();
    
    
    public void addInstruction(String instruction){
        instructions.add(instruction);
    }
    
    public String getInstruction(int number) throws InvalidIndex{
        if(number<1)
            throw new InvalidIndex();
        
        return instructions.get(number-1); //because instructions start at 1, and linked list start at 0
    }
    
    public void modifyInstruction(int number, String instruction) throws InvalidIndex{
        if(number < 1)
            throw new InvalidIndex();
        
        instructions.set(number-1, instruction);
    }
    
    public void removeInstruction(int number) throws InvalidIndex{
        if(number < 1)
            throw new InvalidIndex();
        
        instructions.remove(number-1);
    }
    
}
