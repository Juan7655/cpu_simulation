/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import java.util.HashMap;

/**
 *
 * @author juandavid
 */
public class MemoryUnit {
    private final HashMap<Integer, Integer> ram = new HashMap<>();
    private final HashMap<Integer, Integer> rom = new HashMap<>();

    public MemoryUnit() {
        {
            int i = 0;
        rom.put(0b0000+(i++), 0b10000010);
        rom.put(0b0000+(i++), 0b10010001);
        rom.put(0b0000+(i++), 0b10100000);
        rom.put(0b0000+(i++), 0b10110011);
        rom.put(0b0000+(i++), 0b00000100);
        }
        {
            int i = 0;
        ram.put(0b1000+(i++), 0b00001001);
        ram.put(0b1000+(i++), 0b01000001);
        ram.put(0b1000+(i++), 0b01100100);
        }
    }
    
    public void insertRam(int key, int value){
        ram.put(key, value);
    }
    
    public int getContent(int address){
        int content = rom.getOrDefault(address, -1);
        if(content==-1)content = ram.get(address);
        
        return content;
    }
}
