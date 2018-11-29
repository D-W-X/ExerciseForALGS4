package per.dwh.chapter1;

/**
 * @author DW
 * @date 2018/11/29
 */

class Work1_9 {
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

    static String answer(int number) {
        StringBuilder s = new StringBuilder();
        for (int n = number; n > 0; n /= 2) {
            s.insert(0, (n % 2));
        }
        return s.toString();
    }
}
