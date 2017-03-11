/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;


public enum Operation {
    //To add operations, change the declaration here and the definition in the ALU
    SUM ("+", 0b0000), 
    SUBTRACTION ("-", 0b0001), 
    PRODUCT ("*", 0b0010), 
    POWER ("^", 0b0011),
    NOT ("NOT", 0b0100),
    NOR ("NOR", 0b0101),
    AND ("AND", 0b0110),
    MOD ("MOD", 0b0111),
    MOVE ("M", 0b1000), 
    END ("E", 0b1001);
    
    private final String symbol;
    private final int direction;
    
    Operation(String symbol, int direction){
        this.symbol = symbol;
        this.direction = direction;
    }
    
    public String getSymbol(){
        return symbol;
    }

    public int getDirection() {
        return direction;
    }
    
    /**
     * This method Decodes the nibble taken into the corresponding operation to execute by the ALU
     *
     * @param value The direction of the Operation to execute
     * @return Operation taken from memory table
     */
    public static Operation decode(int value) {
        for (Operation object : Operation.values()) {
           if(object.getDirection() == value) return object; 
        }
        
       throw new IllegalArgumentException("Non-existent operation for ALU");
    }
}
