import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * StringCalculatorTest
 */
public class TextCalculatorTest {

    private TextCalculator strCal;

    @Before
    public void setup() {
        strCal = new TextCalculator();
        System.out.println("before");
    }

    @Test
    public void add0(){
        assertEquals(0, strCal.add(""));
    }

    @Test
    public void add1(){
        assertEquals(3, strCal.add("1,2"));
    }

    @Test
    public void add2(){
        assertEquals(6, strCal.add("1,2,3"));
    }

    @Test
    public void add3(){
        assertEquals(6, strCal.add("1,2:3"));
    }

    @Test
    public void add4(){
        assertEquals(6, strCal.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add5(){
        strCal.add("//;\n-1;2;3");
    }

}