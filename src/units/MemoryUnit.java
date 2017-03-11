/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import java.util.HashMap;
import java.util.Map;


public class MemoryUnit {
    private final HashMap<Integer, Integer> ram = new HashMap<>();
    private final HashMap<Integer, Integer> rom = new HashMap<>();

    public MemoryUnit() {
        { //Filling ROM instructions. These can't be modified in the future
            int i = 0;
        rom.put(0b0000+(i++), 0b10000000);
        rom.put(0b0000+(i++), 0b10010111);
        rom.put(0b0000+(i++), 0b10100010);
        rom.put(0b0000+(i++), 0b11011000);
        rom.put(0b0000+(i++), 0b10110000);
        rom.put(0b0000+(i++), 0b11000001);
        rom.put(0b0000+(i++), 0b11010000);
        rom.put(0b0000+(i++), 0b11101000);
        rom.put(0b1111, 0b00001001);
        }
        { //Filling RAM instructions. New values can be added later(Operation MOVE)
            int i = 0;
        ram.put(0b1000+(i++), 0b10000010);
        ram.put(0b1000+(i++), 0b00000111);
        ram.put(0b1000+(i++), 0b00011001);
        ram.put(0b1000+(i++), 0b10000101);
        ram.put(0b1000+(i++), 0b01010000);
        }
    }
    
    public void insertRam(int key, int value){
        ram.put(key, value);
    }
    
    public int getContent(int address){
        int content = rom.getOrDefault(address, -1);
       
        return (content == -1? ram.get(address): content);
    }
    
    public String[][] getAllItemsRam(){
        String[][] temp = new String[2][ram.size()];
        int i = 0;
        
        for (Map.Entry<Integer, Integer> entry : ram.entrySet()) {
            temp[0][i] = Integer.toBinaryString(entry.getKey());
            temp[1][i++] = Integer.toBinaryString(entry.getValue());
        }
        
        return temp;
    }
}
