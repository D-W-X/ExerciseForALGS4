package per.dwh.chapter1;

/**
 * @author DW
 * @date 2018/11/29
 */

public class Work1_9 {
    static String getBinary(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number == 0) {
            return "0";
        }
        while (number != 0) {
            if (number % 2 == 0) {
                stringBuilder.append("0");
                number = number / 2;
            } else {
                stringBuilder.append("1");
                number = number / 2;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
