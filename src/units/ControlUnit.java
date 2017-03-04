/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Clock;
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
    
    public int getLastInstruction(){
        return this.instructionRegistry.getLastRegistry();
    }
}
