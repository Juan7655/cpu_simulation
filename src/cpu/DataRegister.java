/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;


public class DataRegister extends Register{
    
    /**
     * This method takes the actual registry it has and divides it into two parts. That is,
     * takes a Byte and returns two nibbles. This simulates the moving of data from the Data Registry
     * to the Directions Registry and the Instructions Registry
     *
     * @return Array of values corresponding to the Directions Register(prefix)
     * and the Instructions Register(suffix)
     */
    public Integer[] getDividedValue(){
        String tempVal = Integer.toBinaryString(super.getLastRegistry());
        
        while(tempVal.length() < 8) {
            tempVal = "0" + tempVal;
        }
        
        Integer[] values = new Integer[2];
        values[0] = Integer.parseInt(tempVal.substring(0, 4), 2);
        values[1] = Integer.parseInt(tempVal.substring(4, tempVal.length()), 2);  
        
        return values;
    }
}
