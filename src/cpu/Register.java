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
    private final Stack<Integer> records = new Stack<>();
    private int currentValue = -1;

    public Register() {
    }
    
    public void putRegistry(int value){
        this.records.add(value);
        this.currentValue = value;
    }
    
    public int getLastRegistry(){
        int temp = this.currentValue;
        if(temp != -1)this.currentValue = -1;
        
        return temp;
    }
    
    public Integer[] getAllItems(){
        Integer[] array = new Integer[this.records.size()];
        this.records.toArray(array);
        
        return array;
    }
}
