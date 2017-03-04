/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import units.Alu;
import units.ControlUnit;
import units.MemoryUnit;

/**
 *
 * @author juandavid
 */
public class Synchronizer implements Clock{
    
    private final ControlUnit controlUnit = new ControlUnit();
    private final MemoryUnit memoryUnit = new MemoryUnit();
    private final Alu alu = new Alu();
    private final Register directionRegistry = new Register();
    private final Register dataRegistry = new Register();

    @Override
    public void tick() {
        dataRegistry.putRegistry(memoryUnit.getContent(directionRegistry.getLastRegistry()));
        
        Operation operation = Operation.DIRECTION;
        switch(operation){
            case DIRECTION:
                break;
            case CALULATION:
                alu.setInput(dataRegistry.getLastRegistry());
                alu.decode(controlUnit.getLastInstruction());
                break;
            case MOVING:
                dataRegistry.putRegistry(alu.getCollector());
                memoryUnit.insertRam(directionRegistry.getLastRegistry(), dataRegistry.getLastRegistry());
                break;
        }
    }
    
    enum Operation{
        DIRECTION, CALULATION, MOVING
    }
}
