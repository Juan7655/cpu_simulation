/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Clock;
import cpu.Operation;
import cpu.Register;

/**
 *
 * @author juandavid
 */
public class ControlUnit implements Clock {

    private final Counter counter = new Counter();
    private final Register instructionRegistry = new Register();

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setInstruction(int value){
        this.instructionRegistry.putRegistry(value);
    }
    
    public int getLastInstruction(){
        return this.instructionRegistry.getLastRegistry();
    }
    
    public Operation decode(int value) {
        switch (value) {
            case 0b0000: return Operation.SUM;
            case 0b0001: return Operation.SUBTRACTION;
            case 0b0010: return Operation.SQUARE;
            case 0b0011: return Operation.MOVE;
            case 0b0100: return Operation.END;
            default: throw new IllegalArgumentException("No se reconoce la operacion seleccionada-ALU");
        }
    }
}
