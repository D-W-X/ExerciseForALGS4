package per.dwh.chapter1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author DW
 * @date 2018/11/29
 */
class Test1_3 {
    private ByteArrayOutputStream bytes = null;//输出流
    private ByteArrayInputStream inputStream = null;//输入流
    private String numbers = null;//被测试数据
    private final String lineSeparator = System.lineSeparator();

    //重定向输出流
    @BeforeEach
    void setUp() {
        bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    //测试
    @Test
    void test1() {
        numbers = "12" + lineSeparator + "12" + lineSeparator + "12" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.main(null);
        assertEquals("true", bytes.toString().trim());
    }

    @Test
    void test2() {
        numbers = "12" + lineSeparator + "14" + lineSeparator + "12" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.main(null);
        assertEquals("false", bytes.toString().trim());
    }

    @Test
    void test3() {
        numbers = "12" + lineSeparator + "12" + lineSeparator + "14" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.main(null);
        assertEquals("false", bytes.toString().trim());
    }

    @Test
    void test4() {
        numbers = "11" + lineSeparator + "14" + lineSeparator + "14" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.main(null);
        assertEquals("false", bytes.toString().trim());
    }

    @Test
    void test5() {
        numbers = "10" + lineSeparator + "11" + lineSeparator + "14" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.main(null);
        assertEquals("false", bytes.toString().trim());
    }
}
