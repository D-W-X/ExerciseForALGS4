package per.dwh.chapter1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author DW
 * @date 2018/11/30
 */

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
