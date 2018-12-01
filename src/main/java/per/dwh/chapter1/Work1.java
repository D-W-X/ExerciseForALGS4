package per.dwh.chapter1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author DW
 * @date 2018/11/29
 */

class Work1_3 {
    static void compareThree() {
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

class Work1_5 {
    static boolean testDouble(double a, double b) {
        return (a > 0) && (a < 1) && (b > 0) && (b < 1);
    }
}

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

class Work1_11 {
    private static final String SPACE = "   ";

    static void printMatrix(boolean[][] b) {
        StringBuilder s = new StringBuilder();
        s.append("    ");
        for (int i = 1; i <= b[0].length; i++) {
            addNumber(s, i);
        }
        s.append("\n");

        for (int i = 1; i <= b.length; i++) {
            addNumber(s, i);
            for (int j = 0; j < b[i - 1].length; j++) {
                if (b[i - 1][j]) {
                    s.append("*").append(SPACE);
                } else {
                    s.append(" ").append(SPACE);
                }
            }
            s.append("\n");
        }
        System.out.println(s);
    }

    static void addNumber(StringBuilder s, int number) {
        if (number < 10) {
            s.append(number).append("   ");
        } else if (number < 100) {
            s.append(number).append("  ");
        } else if (number < 1000) {
            s.append(number).append(" ");
        }
    }
}

class Work1_13 {
    static int[][] reverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}

class Work1_14 {
    static int lg(int n) {
        int i = 0;
        if (n <= 0) {
            return -1;
        }
        int total = 1;
        //Out of bounds.
        while (total < n && total > 0) {
            i++;
            total *= 2;
        }
        return i;
    }
}

class Work1_15 {
    static int[] historgram(int[] a, int m) {
        if (a == null || a.length == 0) {
            return null;
        }
        int[] b = new int[m + 1];

        for (int i : a) {
            b[i] += 1;
        }

        return b;
    }
}

class Work1_19 {
    static int[] f(int n) {
        //It will out of bounds if n is bigger than 45.
        if (n > 45) {
            n = 45;
        }
        int[] out = new int[n + 1];
        out[0] = 1;
        out[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            out[i] = out[i - 1] + out[i - 2];
        }
        return out;
    }
}

class Work1_20 {
    /**
     * 这里不要先计算阶乘，不然会由于阶乘增长速度过快而缩小计算范围。
     */
    static double cau(int n) {
        if (n <= 0) {
            return Double.NaN;
        }
        if (n == 1) {
            return 0;
        }
        return Math.log(n) + cau(n - 1);
    }
}

class Work1_21 {
    @Getter
    @Setter
    static class Data {
        private String name;
        private int num1;
        private int num2;

        private String dev() {
            return String.format("%.2f", num1 * 1.0 / num2);
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(name);
            for (int i = 0; i < 10 - name.length(); i++) {
                s.append(" ");
            }
            Work1_11.addNumber(s, num1);
            Work1_11.addNumber(s, num2);
            s.append(this.dev()).append('\n');
            return s.toString();
        }
    }

    private static Data getData(String s) {
        Data d = new Data();
        String[] line = s.split(" ");
        d.setName(line[0]);
        d.setNum1(Integer.parseInt(line[1]));
        d.setNum2(Integer.parseInt(line[2]));
        return d;
    }

    private static void printTable() {
        Scanner s = new Scanner(System.in);
        ArrayList<Data> datas = new ArrayList<>();
        String line;
        while (s.hasNextLine() && !"".equals(line = s.nextLine().trim())) {
            datas.add(getData(line));
        }
        StringBuilder table = new StringBuilder();
        table.append("ord name      num num dev");
        table.append('\n');
        for (int i = 0; i < datas.size(); i++) {
            Work1_11.addNumber(table, i);
            table.append(datas.get(i));
        }
        System.out.println(table);
    }

    /**
     * I don't want to test!
     */
    public static void main(String[] args) {
        printTable();
    }
}
