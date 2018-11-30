package per.dwh.chapter1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DW
 * @date 2018/11/30
 */

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
