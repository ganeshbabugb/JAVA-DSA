package datastructures.zoho;

public class Main {
    public static void main(String[] args) {
        /*
        * Try to print a patten printing using words.
        * Patten : (x)
        * */
        char[] chars = "PROGRAM".toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) System.out.print(chars[j] + " ");
                else if (i + j == length - 1) System.out.print(chars[length - 1 - i] + " ");
                else System.out.print("  ");
            }
            System.out.println();
    }

        /*
        String Question
            Convert the string into Two dimensional matrix.
            Try To Identify the target in the matrix either in rows or column.
        * */
        String input = "WELCOMETOZOHOCORPORATION";
        String target = "oc".toUpperCase();

        int rows = 5;
        int cols = 5;

        char[][] grid = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < input.length()) {
                    grid[i][j] = input.charAt(index);
                    index++;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < rows; j++) {
                sb.append(grid[j][i]);
            }
            if (sb.toString().contains(target)) {
                System.out.println("Target Found!!, In Vertical Search");
            }
        }


        for (char[] row : grid) {
            String r = new String(row);
            if (r.contains(target)) System.out.println("Target Found!!, In Horizontal Search");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
