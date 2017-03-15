/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juandavid
 */
public class MemoryUnitTest {
    
    public MemoryUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContent method, of class MemoryUnit.
     */
    @Test
    public void testGetContentROM() {
        System.out.println("getContent");
        int address = 0b0010;
        MemoryUnit instance = new MemoryUnit(1);
        int expResult = 0b10100000;
        int result = instance.getContent(address);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetContentRAM() {
        System.out.println("getContent");
        int address = 0b1010;
        MemoryUnit instance = new MemoryUnit(1);
        int expResult = 0b01100100;
        int result = instance.getContent(address);
        assertEquals(expResult, result);
    }
}
