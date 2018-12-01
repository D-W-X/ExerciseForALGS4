package per.dwh.chapter1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

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
        Work1_3.compareThree();
        assertEquals("true", bytes.toString().trim());
    }

    @Test
    void test2() {
        numbers = "12" + lineSeparator + "14" + lineSeparator + "12" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.compareThree();
        assertEquals("false", bytes.toString().trim());
    }

    @Test
    void test3() {
        numbers = "12" + lineSeparator + "12" + lineSeparator + "14" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.compareThree();
        assertEquals("false", bytes.toString().trim());
    }

    @Test
    void test4() {
        numbers = "11" + lineSeparator + "14" + lineSeparator + "14" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.compareThree();
        assertEquals("false", bytes.toString().trim());
    }

    @Test
    void test5() {
        numbers = "10" + lineSeparator + "11" + lineSeparator + "14" + lineSeparator;
        inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);
        Work1_3.compareThree();
        assertEquals("false", bytes.toString().trim());
    }
}

class Test1_5 {
    @Test
    void test1() {
        assertTrue(Work1_5.testDouble(0.1, 0.1));
    }

    @Test
    void test2() {
        assertFalse(Work1_5.testDouble(0, 0.1));
    }

    @Test
    void test3() {
        assertFalse(Work1_5.testDouble(0.1, 0));
    }

    @Test
    void test4() {
        assertFalse(Work1_5.testDouble(-0.1, -0.1));
    }

    @Test
    void test5() {
        assertFalse(Work1_5.testDouble(1, 0.1));
    }

    @Test
    void test6() {
        assertFalse(Work1_5.testDouble(0.34, 1));
    }
}

class Test1_9 {
    @Test
    void test1() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            int a = random.nextInt();
            a = Math.abs(a);
            assertEquals(Integer.toBinaryString(a), Work1_9.getBinary(a), Integer.toString(a));
        }
    }
}

class Test1_11 {
    private Random random = new Random(System.currentTimeMillis());

    @Test
    void test1() {
        boolean[][] matrix = new boolean[4][];
        matrix[0] = new boolean[]{false, true, true, false};
        matrix[1] = new boolean[]{false, false, false, true};
        matrix[2] = new boolean[]{false, false, true, false};
        matrix[3] = new boolean[]{true, true, true, false};
        String sTrue = "*   ";
        String sFalse = "    ";
        String s = "    1   2   3   4   \n" +
                "1   " + sFalse + sTrue + sTrue + sFalse + "\n" +
                "2   " + sFalse + sFalse + sFalse + sTrue + "\n" +
                "3   " + sFalse + sFalse + sTrue + sFalse + "\n" +
                "4   " + sTrue + sTrue + sTrue + sFalse + "\n";
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        Work1_11.printMatrix(matrix);
        assertEquals(s.trim(), bytes.toString().trim());
    }

    //I don't want to write more test methods because it maybe too long and it's boring.
    @Test
    void test2() {
        int a = 0, b = 0;
        while (a == 0) {
            a = random.nextInt(100);
        }
        while (b == 0) {
            b = random.nextInt(100);
        }
        boolean[][] matrix = new boolean[a][b];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextBoolean();
            }
        }
        System.err.println(matrix.length + "  " + matrix[0].length);

        Work1_11.printMatrix(matrix);
    }
}

class Test1_13 {
    private int[][] matrix;
    private int[][] outMatrix;

    @Test
    void test1() {
        matrix = new int[4][];
        matrix[0] = new int[]{1, 3, 5, 7, 3};
        matrix[1] = new int[]{3, 4, 6, 8, 1};
        matrix[2] = new int[]{12, 45, 2, 6, 9};
        matrix[3] = new int[]{6, 3, 7, 2, 9};
        outMatrix = new int[5][];
        outMatrix[0] = new int[]{1, 3, 12, 6};
        outMatrix[1] = new int[]{3, 4, 45, 3};
        outMatrix[2] = new int[]{5, 6, 2, 7};
        outMatrix[3] = new int[]{7, 8, 6, 2};
        outMatrix[4] = new int[]{3, 1, 9, 9};
        assertArrayEquals(outMatrix, Work1_13.reverse(matrix));
    }

    @Test
    void test2() {
        matrix = new int[2][];
        matrix[0] = new int[]{1, 3, 5, 7, 3};
        matrix[1] = new int[]{3, 4, 6, 8, 1};
        outMatrix = new int[5][];
        outMatrix[0] = new int[]{1, 3};
        outMatrix[1] = new int[]{3, 4};
        outMatrix[2] = new int[]{5, 6};
        outMatrix[3] = new int[]{7, 8};
        outMatrix[4] = new int[]{3, 1};
        assertArrayEquals(outMatrix, Work1_13.reverse(matrix));
    }

    @Test
    void test3() {
        matrix = new int[5][];
        matrix[0] = new int[]{1, 3, 5, 7, 3};
        matrix[1] = new int[]{3, 4, 6, 8, 1};
        matrix[2] = new int[]{12, 45, 2, 6, 9};
        matrix[3] = new int[]{6, 3, 7, 2, 9};
        matrix[4] = new int[]{234, 123, 1, 12, 34};
        outMatrix = new int[5][];
        outMatrix[0] = new int[]{1, 3, 12, 6, 234};
        outMatrix[1] = new int[]{3, 4, 45, 3, 123};
        outMatrix[2] = new int[]{5, 6, 2, 7, 1};
        outMatrix[3] = new int[]{7, 8, 6, 2, 12};
        outMatrix[4] = new int[]{3, 1, 9, 9, 34};
        assertArrayEquals(outMatrix, Work1_13.reverse(matrix));
    }

}

class Test1_14 {
    @RepeatedTest(1000)
    void test1() {
        Random random = new Random(System.currentTimeMillis());
        int a = random.nextInt();
        a = Math.abs(a);
        assertEquals((int) (Math.log(a) / Math.log(a)), Work1_14.lg(a), a);
    }
}

class Test1_15 {
    @Test
    void test1() {
        int[] a = new int[]{1, 2, 1, 2, 3, 1, 2, 3, 1, 3, 4, 2, 2, 3, 4, 2, 1, 3, 4, 2, 3, 3, 5, 3, 2, 3, 5};
        int b = 5;
        int[] c = new int[]{0, 5, 8, 9, 3, 2};
        assertArrayEquals(c, Work1_15.historgram(a, b));
    }
}

class Test1_19 {
    @Test
    void test1() {
        double sFive = Math.sqrt(5);
        for (int n = 3; n < 45; n++) {
            int outs = (int) ((1 / sFive) * (Math.pow((1 + sFive) / 2, n) - Math.pow((1 - sFive) / 2, n)));
            assertEquals(outs, Work1_19.f(n - 1)[n - 1]);
        }
    }
}

class Test1_20 {
    @RepeatedTest(1)
    void test() {
        System.out.println(Work1_20.cau(10));
    }
}