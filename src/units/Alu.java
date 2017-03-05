/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Operation;
import cpu.Register;

/**
 *
 * @author juandavid
 */
public class Alu {
    
    private Register collector = new Register();
    private Register input = new Register();
    
    public Alu() {
    }

    public void setInput(int input) {
        this.input.putRegistry(input);
    }

    public int getCollector() {
        int temp = collector.getLastRegistry();
                
        return temp;
    }

    private void setCollector(int collector) {
        this.collector.putRegistry(collector);
    }
    
    private void sum(){
        setCollector(collector.getLastRegistry() + input.getLastRegistry());
    }
    
    private void subtraction(){
        setCollector(collector.getLastRegistry() - input.getLastRegistry());
    }
    
    private void square(){
        int tempVal = input.getLastRegistry();
        setCollector(tempVal * tempVal);
    }
    
    public void execute(Operation operation) {
        switch (operation) {
            case SUM: sum();
                break;
            case SUBTRACTION: subtraction();
                break;
            case SQUARE: square();
                break;
            default: throw new IllegalArgumentException("No se reconoce la operacion seleccionada-ALU");
        }
    }
    
    public Object getRegistryEntry(){
        return input;
    }
    
    public Object getRegistryCollector(){
        return collector;
    }
}
