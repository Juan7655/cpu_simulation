/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Register;

/**
 *
 * @author juandavid
 */
public class Alu {
    
    private Register collector;
    private Register input;
    
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
    
    public void sum(){
        setCollector(collector.getLastRegistry()+input.getLastRegistry());
    }
    
    public void subtraction(){
        setCollector(collector.getLastRegistry()-input.getLastRegistry());
    }
    
    public void square(){
        setCollector(input.getLastRegistry()*input.getLastRegistry());
    }
    
    public void move(){
        
    }
    
    public void end(){
        
    }
    
    public void decode(int value) {
        switch (value) {
            case 0b0000: sum();
                break;
            case 0b0001: subtraction();
                break;
            case 0b0010: square();
                break;
            case 0b0011: move();
                break;
            case 0b0100: end();
                break;
            default: throw new IllegalArgumentException("No se reconoce la operacion seleccionada-ALU");
        }
    }
}
