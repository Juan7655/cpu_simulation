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
public class Synchronizer implements Clock {

    private final ControlUnit controlUnit = new ControlUnit();
    private final MemoryUnit memoryUnit = new MemoryUnit();
    private final Alu alu = new Alu();
    private final Register directionRegistry = new Register();
    private final DataRegister dataRegistry = new DataRegister();
    private boolean continueRun;
    private int runs = 0;

    public Synchronizer() {
        this.continueRun = true;
    }

    @Override
    public void tick() {
        if (dataRegistry.getLastRegistry() == -1) {
            directionRegistry.putRegistry(Counter.nextVal());
        }
        dataRegistry.putRegistry(memoryUnit.getContent(directionRegistry.getLastRegistry()));

        Integer[] tempValues = dataRegistry.getDividedValue();
        directionRegistry.putRegistry(tempValues[0]);
        controlUnit.setInstruction(tempValues[1]);

        Operation operation = controlUnit.decode(controlUnit.getLastInstruction());
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
                int content = memoryUnit.getContent(directionRegistry.getLastRegistry());
                dataRegistry.putRegistry(content);
                int data = dataRegistry.getLastRegistry();
                alu.setInput(data);
                alu.execute(operation);
        }

        runs++;
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
            default:
                return null;
        }
    }
}
