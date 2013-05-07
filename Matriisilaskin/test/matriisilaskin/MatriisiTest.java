/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arvy
 */
public class MatriisiTest {
    
    public MatriisiTest() {
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
     * Test of yksikkoMatriisi method, of class Matriisi.
     */
    @Test
    public void testYksikkoMatriisi() {
        System.out.println("yksikkoMatriisi");
        int koko = 0;
        Matriisi expResult = null;
        Matriisi result = Matriisi.yksikkoMatriisi(koko);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaulukkoKopio method, of class Matriisi.
     */
    @Test
    public void testGetTaulukkoKopio() {
        System.out.println("getTaulukkoKopio");
        Matriisi instance = null;
        Murtoluku[][] expResult = null;
        Murtoluku[][] result = instance.getTaulukkoKopio();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Matriisi.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Matriisi m = null;
        Matriisi instance = null;
        Matriisi expResult = null;
        Matriisi result = instance.add(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Matriisi.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Matriisi m = null;
        Matriisi instance = null;
        Matriisi expResult = null;
        Matriisi result = instance.sub(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getI method, of class Matriisi.
     */
    @Test
    public void testGetI() {
        System.out.println("getI");
        Matriisi instance = null;
        int expResult = 0;
        int result = instance.getI();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJ method, of class Matriisi.
     */
    @Test
    public void testGetJ() {
        System.out.println("getJ");
        Matriisi instance = null;
        int expResult = 0;
        int result = instance.getJ();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Matriisi.
     */
    @Test
    public void testMul_Matriisi() {
        System.out.println("mul");
        Matriisi m = null;
        Matriisi instance = null;
        Matriisi expResult = null;
        Matriisi result = instance.mul(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Matriisi.
     */
    @Test
    public void testMul_Murtoluku() {
        System.out.println("mul");
        Murtoluku m = null;
        Matriisi instance = null;
        Matriisi expResult = null;
        Matriisi result = instance.mul(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Matriisi.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Matriisi instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCell method, of class Matriisi.
     */
    @Test
    public void testGetCell() {
        System.out.println("getCell");
        int i = 0;
        int j = 0;
        Matriisi instance = null;
        Murtoluku expResult = null;
        Murtoluku result = instance.getCell(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinantti method, of class Matriisi.
     */
    @Test
    public void testDeterminantti() {
        System.out.println("determinantti");
        Matriisi instance = null;
        Murtoluku expResult = null;
        Murtoluku result = instance.determinantti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kaanna method, of class Matriisi.
     */
    @Test
    public void testKaanna() {
        System.out.println("kaanna");
        Matriisi instance = null;
        Matriisi expResult = null;
        Matriisi result = instance.kaanna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transpoosi method, of class Matriisi.
     */
    @Test
    public void testTranspoosi() {
        System.out.println("transpoosi");
        Matriisi instance = null;
        Matriisi expResult = null;
        Matriisi result = instance.transpoosi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}