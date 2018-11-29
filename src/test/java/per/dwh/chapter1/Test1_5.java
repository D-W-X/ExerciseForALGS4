package per.dwh.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DW
 * @date 2018/11/29
 */

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
