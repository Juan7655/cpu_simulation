/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import units.*;

public class Synchronizer implements Clock {

    private final ControlUnit controlUnit;
    private final MemoryUnit memoryUnit;
    private final Alu alu;
    private final Register directionRegistry;
    private final DataRegister dataRegistry;
    private boolean continueRun;

    public Synchronizer(int ejercicio) {
        this.alu = new Alu();
        this.controlUnit = new ControlUnit();
        this.memoryUnit = new MemoryUnit(ejercicio);
        this.dataRegistry = new DataRegister();
        this.directionRegistry = new Register();
        this.continueRun = true;
    }

    /**
     * Synchronizes all internal component activity with the clocks pulse.
     */
    @Override
    public void tick() {
        if (dataRegistry.getLastRegistry() == -1) {
            directionRegistry.putRegistry(Counter.nextVal());
        }

        dataRegistry.putRegistry(memoryUnit.getContent(directionRegistry.getLastRegistry()));

        Integer[] tempValues = dataRegistry.getDividedValue();
        directionRegistry.putRegistry(tempValues[0]);
        controlUnit.setInstruction(tempValues[1]);

        Operation operation = Operation.decode(controlUnit.getLastInstruction());
        switch (operation) {
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
        if (continueRun) {
            this.tick();
        }
    }

    public String[] getValues(int value) {
        switch (value) {
            case 0:
                return directionRegistry.getAllItems(4);
            case 1:
                return controlUnit.getInstructionRegister().getAllItems(4);
            case 2:
                return dataRegistry.getAllItems(8);
            case 3:
                return ((Register) alu.getRegistryEntry()).getAllItems(8);
            case 4:
                return ((Register) alu.getRegistryCollector()).getAllItems(8);
            case 5:
                return memoryUnit.getAllItemsRam()[0];
            case 6:
                return memoryUnit.getAllItemsRam()[1];
            case 7:
                return Counter.getAllItems();
            case 8:
                return memoryUnit.getAllItemsRom()[0];
            case 9:
                return memoryUnit.getAllItemsRom()[1];
            default:    
                return null;
        }
    }
}
