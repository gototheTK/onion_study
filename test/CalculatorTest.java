import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator cal;

    @Before
    public void setUp() {
        this.cal = new Calculator();
    }

    // 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.

    // 앞의 기본 구분자 외에 커스텀 구분자를 지정할 수 있다.

    // 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리해야한다.

    @Test
    public void testAdd() {
        assertEquals(6, cal.add("1:2,3"));
    }

    @Test
    public void testAdd공백() {
        assertEquals(0, cal.add(""));
    }

    @Test
    public void testAdd커스텀구분자() {
        assertEquals(10, cal.add("//;\n1;2;3;4"));
    }

    @Test(expected = RuntimeException.class)
    public void testAdd음수() {
        assertEquals(0, cal.add("-1:2:3"));
    }

}
