import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nLet's play tic tac toe");
        /*
         * Creating a board
         */
        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '_');
        }
        printBoard(board);
        /*
         * Populating the board
         */
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Turn: " + 'X');
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';
                printBoard(board);
            } else {
                System.out.println("Turn: " + 'O');
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
                printBoard(board);
            }
            /*
            * Calculating the winner/tie
            */
            int count = checkWin(board);

            if(count == 3) {
                System.out.println("X wins!");
                break;
            } else if (count == -3) {
                System.out.println("O wins!");
                break;
            } else if (i == 8) {
                System.out.println("Its a tie. Go again.");
            }
        }
        scan.close();
    }
    /**
     * Function name - printBoard()
     *
     * @param board (char[][])
     *
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     */

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("\n");
        }
    }


    /**
     * Function name – askUser
     *
     * @param board (char[][] board)
     * @return spot (int[])
     *
     * Inside the function
     *   1. Asks the user: - pick a row and column number:
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     */

    public static int[] askUser(char[][] board) {
        System.out.print(" - pick a row and column number: ");
        int row = scan.nextInt();
        int column = scan.nextInt();

        while (board[row][column] != '_') {
            System.out.print("Spot taken, try again: ");
            row = scan.nextInt();
            column = scan.nextInt();
        }

        return new int[]{row, column};
    }

    /**
     * Function name - checkWin
     * @param board (char[][])
     * @return count (int)
     *
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O.
     *   3. Check every column for a straight X or straight O.
     *   4. Check the left diagonal for a straight X or straight O.
     *   5. Check the right diagonal for a straight X or straight O.
     */
    public static int checkWin(char[][] board) {
        int count = 0;
        /*
        * Rows check
        */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                   if(board[i][j] == 'X') {
                       count++;
                   } else if (board[i][j] == 'O') {
                       count--;
                   }
            }
            if(count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        /*
         * Columns check
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i] == 'X') {
                    count++;
                } else if (board[j][i] == 'O') {
                    count--;
                }
            }
            if(count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        /*
        * Diagonal check right
        */
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X'){
                count++;
            } else if (board[i][i] == 'O'){
                count--;
            }
        }
        if(count == 3 || count == -3) {
            return count;
        } else {
            count = 0;
        }
        /*
        * Diagonal check left
        */
        for (int i = 0; i < board.length; i++) {
            if (board[i][2-i] == 'X'){
                count++;
            } else if (board[i][2-i] == 'O'){
                count--;
            }
        }
        return count;
    }
}
