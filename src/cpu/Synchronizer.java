/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import units.*;

/**
 *
 * @author juandavid
 */
public class Synchronizer implements Clock{
    
    private final ControlUnit controlUnit = new ControlUnit();
    private final MemoryUnit memoryUnit = new MemoryUnit();
    private final Alu alu = new Alu();
    private final Register directionRegistry = new Register();
    private final DataRegister dataRegistry = new DataRegister();
    private boolean continueRun = true;

    @Override
    public void tick() {
        if(dataRegistry.getLastRegistry()==-1)directionRegistry.putRegistry(Counter.nextVal());
        dataRegistry.putRegistry(memoryUnit.getContent(directionRegistry.getLastRegistry()));
        
        Integer[] tempValues = dataRegistry.getDividedValue();
        directionRegistry.putRegistry(tempValues[0]);
        controlUnit.setInstruction(tempValues[1]);
        
        Operation operation = controlUnit.decode(controlUnit.getLastInstruction());
        switch(operation){
            case MOVE:
                dataRegistry.putRegistry(alu.getCollector());
                memoryUnit.insertRam(directionRegistry.getLastRegistry(), dataRegistry.getLastRegistry());
                break;
            case END:
                directionRegistry.putRegistry(0);
                this.continueRun = false;
                break;
            default:
                dataRegistry.putRegistry(memoryUnit.getContent(directionRegistry.getLastRegistry()));
                alu.setInput(dataRegistry.getLastRegistry());
                alu.execute(operation);
        }
        
        if(continueRun)this.tick();
        
    }
}
