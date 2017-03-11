/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import java.util.Stack;


public class Register {
    private final Stack<Integer> records;
    private int currentValue;

    public Register() {
        this.currentValue = -1;
        this.records = new Stack<>();
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
    
    /**
     * This method return the historical records of the values that the Register has taken
     * with the size given. This is due to the fact that some registers work with nibbles 
     * whilst others work with bytes.
     *
     * @param regSize the size of the values to return.
     * @return String array with the records the Register has taken in.
     */
    public String[] getAllItems(int regSize){
        String[] array = new String[this.records.size()];
        
        for (int i = 0; i < this.records.size(); i++) {
            array[i] = Integer.toBinaryString(this.records.get(i));
            while(array[i].length() < regSize){
                array[i] = "0" + array[i];
            }
        }
        
        return array;
    }
}
