/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

/**
 *
 * @author juandavid
 */
public class Counter {
    private static int value = 0;
    
    public static int nextVal(){
        value++;
        
        return value;
    }
}
