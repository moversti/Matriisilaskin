
package matriisilaskin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mikko Översti
 */
public class MurtolukuTest {
    
    public MurtolukuTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void addTest() {
         Murtoluku m = new Murtoluku(3);
         Murtoluku n = new Murtoluku(15);
         assertEquals(new Murtoluku(18), m.add(n));
         assertEquals(new Murtoluku(6), m.add(m));
         m = new Murtoluku(3,5);
         n = new Murtoluku(7,18);
         assertEquals(new Murtoluku(3*18+5*7,5*18), m.add(n));
         n = new Murtoluku(-1,7);
         assertEquals(new Murtoluku(3*7-5,5*7), m.add(n));
     }
     @Test
     public void subTest() {
         Murtoluku m = new Murtoluku(3);
         Murtoluku n = new Murtoluku(15);
         assertEquals(new Murtoluku(-12), m.sub(n));
         assertEquals(new Murtoluku(0), m.sub(m));
         m = new Murtoluku(3,5);
         n = new Murtoluku(7,18);
         assertEquals(new Murtoluku(3*18-5*7,5*18), m.sub(n));
         n = new Murtoluku(-1,7);
         assertEquals(new Murtoluku(3*7+5,5*7), m.sub(n));
     }
     
     @Test
     public void mulTest() {
         Murtoluku m = new Murtoluku(3);
         Murtoluku n = new Murtoluku(15);
         assertEquals(new Murtoluku(45), m.mul(n));
         assertEquals(new Murtoluku(9), m.mul(m));
         m = new Murtoluku(3,5);
         n = new Murtoluku(7,18);
         assertEquals(new Murtoluku(3*7,5*18), m.mul(n));
         n = new Murtoluku(-1,7);
         assertEquals(new Murtoluku(-3,5*7), m.mul(n));
     }
     
     @Test
     public void divTest() {
         Murtoluku m = new Murtoluku(15);
         Murtoluku n = new Murtoluku(3);
         assertEquals(new Murtoluku(5), m.div(n));
         assertEquals(new Murtoluku(1), m.div(m));
         m = new Murtoluku(3,5);
         n = new Murtoluku(7,18);
         assertEquals(new Murtoluku(3*18,5*7), m.div(n));
         n = new Murtoluku(-1,7);
         assertEquals(new Murtoluku(3*7,-5), m.div(n));
     }
     
     @Test
     public void vastaTest() {
         Murtoluku m = new Murtoluku(15);
         assertEquals(new Murtoluku(-15), m.vasta());
         m = new Murtoluku(0);
         assertEquals(new Murtoluku(0), m.vasta());
         m = new Murtoluku(-3,5);
         assertEquals(new Murtoluku(3,5), m.vasta());
         
     }
     
     @Test
     public void kaanteisTest() {
         Murtoluku m = new Murtoluku(15);
         assertEquals(new Murtoluku(1,15), m.kaanteis());
         m = new Murtoluku(0);
         assertEquals(new Murtoluku(0), m.kaanteis());
         m = new Murtoluku(-3,5);
         assertEquals(new Murtoluku(-5,3), m.kaanteis());
         
     }
     
     
     
}