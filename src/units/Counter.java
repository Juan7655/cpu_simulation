/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Register;


public class Counter{
    private static int value = -1;
    private static Register counter = new Register();
    
    public static int nextVal(){
        value++;
        counter.putRegistry(value);
       return counter.getLastRegistry();
    }
    
    public static String[] getAllItems(){
        return counter.getAllItems(4);
    }
    public static void reset(){
        value = -1;
        counter = new Register();
    }
}
