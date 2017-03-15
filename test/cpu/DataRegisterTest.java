/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

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
public class DataRegisterTest {
    
    public DataRegisterTest() {
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
     * Test of getPrefix method, of class DataRegister.
     */
    @Test
    public void testGetPrefix1() {
        System.out.println("getPrefix1");
        int value = 65;
        DataRegister instance = new DataRegister();
        Integer[] result = instance.getDividedValue();
        Integer[] expResult = new Integer[]{0b0100,0b0001};
    
        assertEquals(expResult, result);
    }
}
