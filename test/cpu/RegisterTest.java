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
public class RegisterTest {
    
    public RegisterTest() {
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

    @Test
    public void testSomeMethod() {
        Register instance = new Register();
        int expVal = 0b00101001;
        
        instance.putRegistry(0b10101001);
        instance.putRegistry(0b00101000);
        instance.putRegistry(0b00111001);
        instance.putRegistry(0b00100001);
        instance.putRegistry(0b00001001);
        instance.putRegistry(0b00101001);
        
        int actualVal = instance.getLastRegistry();
        
        assertEquals(expVal, actualVal);
    }
    
}
