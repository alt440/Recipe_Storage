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
    
    
    public void addInstruction(int number, String instruction)throws InvalidIndex{
        //we also include instructions.size()+1 as upper bound in case the 
        //instruction is added at the end of the list.
        if(number < 1 || number > instructions.size()+1)
            throw new InvalidIndex();
        
        if(number !=instructions.size()+1){
            String instructionAtNumber = instructions.get(number-1);
            instructions.set(number-1, instruction);
        
            //pushing the next instructions down
            for(int i=number; i< instructions.size();i++){
                String nextInstruction = instructions.get(i);
                instructions.set(i, instructionAtNumber);
                instructionAtNumber = nextInstruction;   
            }
        }
        
        else{
            instructions.add(instruction);
        }
    }
    
    public String getInstruction(int number) throws InvalidIndex{
        if(number<1 || number > instructions.size())
            throw new InvalidIndex();
        
        return instructions.get(number-1); //because instructions start at 1, and linked list start at 0
    }
    
    public void modifyInstruction(int number, String instruction) throws InvalidIndex{
        if(number < 1 || number > instructions.size())
            throw new InvalidIndex();
        
        instructions.set(number-1, instruction);
    }
    
    public void removeInstruction(int number) throws InvalidIndex{
        if(number < 1 || number > instructions.size())
            throw new InvalidIndex();
        
        instructions.remove(number-1);
    }
    
    public String toString(){
        String allInstructions = "";
        for(int i=0;i< instructions.size();i++){
            allInstructions+=i+". "+instructions.get(i)+"\n";
        }
        if(instructions.size()==0)
            return "Instructions: No instructions.\n";
        
        return "Instructions: \n"+allInstructions;
    }
}
