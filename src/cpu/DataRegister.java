/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

/**
 *
 * @author juandavid
 */
public class DataRegister extends Register{
    
    private int currentValue = -1;
    
    public Integer[] getDividedValue(){
        if(this.currentValue == -1) this.currentValue = super.getLastRegistry();
        
        String tempVal = Integer.toBinaryString(this.currentValue);
        while(tempVal.length() < 8) {
            tempVal = "0" + tempVal;
        }
        
        Integer[] values = new Integer[2];
        values[0] = Integer.parseInt(tempVal.substring(0, 4), 2);
        values[1] = Integer.parseInt(tempVal.substring(4, tempVal.length()), 2);  
        
        this.currentValue = -1;
        return values;
    }
}
