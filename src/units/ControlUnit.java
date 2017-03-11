/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Register;


public class ControlUnit{
    
    private final Register instructionRegistry;

    public ControlUnit() {
        this.instructionRegistry = new Register();
    }
    
    public void setInstruction(int value){
        this.instructionRegistry.putRegistry(value);
    }
    
    public int getLastInstruction(){
        return this.instructionRegistry.getLastRegistry();
    }
    
    public Register getInstructionRegister(){
        return instructionRegistry;
    }
}
