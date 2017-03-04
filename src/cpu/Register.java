/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import java.util.Stack;

/**
 *
 * @author juandavid
 */
public class Register {
    private final Stack<Integer> registries = new Stack<>();

    public Register() {
    }
    
    public void putRegistry(int value){
        this.registries.add(value);
    }
    
    public int getLastRegistry(){
        return this.registries.peek();
    }
}
