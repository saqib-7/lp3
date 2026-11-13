import java.util.Scanner;

public class NQueens {
    static int n;
    static int[][] board;

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    static boolean solve(int row) {
        if (row == n) return true;
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                if (solve(row + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = sc.nextInt();
        System.out.print("Enter column (0 to " + (n - 1) + ") for the first queen in row 0: ");
        int firstCol = sc.nextInt();
        if (firstCol < 0 || firstCol >= n) {
            System.out.println("Invalid column");
            return;
        }

        board = new int[n][n];
        board[0][firstCol] = 1;

        if (solve(1)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] == 1 ? "Q " : ". ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution with the first queen at this position.");
        }
        sc.close();
    }
}
