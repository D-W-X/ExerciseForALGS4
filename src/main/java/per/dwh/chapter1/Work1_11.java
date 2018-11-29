package per.dwh.chapter1;

/**
 * @author DW
 * @date 2018/11/30
 */

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

    private static void addNumber(StringBuilder s, int number) {
        if (number < 10) {
            s.append(number).append("   ");
        } else if (number < 100) {
            s.append(number).append("  ");
        } else if (number < 1000) {
            s.append(number).append(" ");
        }
    }
}
