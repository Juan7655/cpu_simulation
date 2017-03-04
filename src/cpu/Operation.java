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
public enum Operation {
    SUM ("+"), 
    SUBTRACTION ("-"), 
    SQUARE ("^2"), 
    MOVE ("M"), 
    END ("E");
    
    private final String symbol;
    
    Operation(String symbol){
        this.symbol = symbol;
    }
    
    public String getSymbol(){
        return symbol;
    }
}
