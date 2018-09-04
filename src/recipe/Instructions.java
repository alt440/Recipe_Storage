/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * This class is used to store the list of instructions
 * of a recipe.
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
    
    /**
     * Adds an instruction to the list at the emplacement indicated by the 
     * parameter number
     * @param number Indicates the position where the instruction will get added.
     * @param instruction The instruction that will be included.
     * @throws InvalidIndex If the index is smaller than 0 or bigger than the 
     * size of the array, the InvalidIndex exception is thrown.
     */
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
    
    /**
     * Gets the instruction at the index number.
     * @param number Represents the index of the instruction.
     * @return The instruction at index number.
     * @throws InvalidIndex If the index is smaller than 0 or
     * bigger than the size of the array.
     */
    public String getInstruction(int number) throws InvalidIndex{
        if(number<1 || number > instructions.size())
            throw new InvalidIndex();
        
        return instructions.get(number-1); //because instructions start at 1, and linked list start at 0
    }
    
    /**
     * Modifies the instruction at index number for a new instruction.
     * @param number Index of instruction to modify.
     * @param instruction New instruction to be put at the index number.
     * @throws InvalidIndex If the index is smaller than 0 or bigger 
     * than the size of the array, the exception is thrown.
     */
    public void modifyInstruction(int number, String instruction) throws InvalidIndex{
        if(number < 1 || number > instructions.size())
            throw new InvalidIndex();
        
        instructions.set(number-1, instruction);
    }
    
    /**
     * Removes the instruction at the index number.
     * @param number The index of the instruction being removed.
     * @throws InvalidIndex If the index is smaller than 0 or bigger 
     * than the size of the array, the exception is thrown.
     */
    public void removeInstruction(int number) throws InvalidIndex{
        if(number < 1 || number > instructions.size())
            throw new InvalidIndex();
        
        instructions.remove(number-1);
    }
    
    /**
     * Gets the LinkedList containing all of the instructions.
     * @return The LinkedList containing all the instructions.
     */
    public LinkedList<String> getInstructions(){
        return instructions;
    }
    
    /**
     * Clears all of the instructions established.
     */
    public void clearInstructions(){
        instructions.clear();
    }
    
    /**
     * Returns the list of instructions as a string.
     * @return The representation of the object as a string.
     */
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
