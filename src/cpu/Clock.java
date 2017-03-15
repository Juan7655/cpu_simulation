/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

/**
 * Represents the pulse of the Clock. Internally that means that all the data flow
 * is synchronized with this "pulse"
 * 
 */
public interface Clock {
    void tick();
}
