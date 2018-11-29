package per.dwh.chapter1;

import java.util.Scanner;

/**
 * @author DW
 * @date 2018/11/29
 */

public class Work1_3 {
    public static void main(String[] args) {
        //read 3 ints
        Scanner s = new Scanner(System.in);
        int number = 3;
        int[] a = new int[number];
        for (int i = 0; i < number; i++) {
            a[i] = s.nextInt();
        }

        //compare
        if ((a[0] ^ a[1]) != 0 || (a[2] ^ a[1]) != 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
