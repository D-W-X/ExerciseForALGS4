package per.dwh.chapter1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author DW
 * @date 2018/11/29
 */

public class Test1_9 {
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
