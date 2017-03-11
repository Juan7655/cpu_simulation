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
        rom.put(0b0000+(i++), 0b10010001);
        rom.put(0b0000+(i++), 0b11001000);
        rom.put(0b0000+(i++), 0b10100000);
        rom.put(0b0000+(i++), 0b10110011);
        rom.put(0b0000+(i++), 0b11000000);
        rom.put(0b0000+(i++), 0b11101000);
        rom.put(0b0000+(i++), 0b00001001);
        }
        { //Filling RAM instructions. New values can be added later(Operation MOVE)
            int i = 0;
        ram.put(0b1000+(i++), 0b11000101);
        ram.put(0b1000+(i++), 0b10111010);
        ram.put(0b1000+(i++), 0b00001110);
        ram.put(0b1000+(i++), 0b00000010);
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
