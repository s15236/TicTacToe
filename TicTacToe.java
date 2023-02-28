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
        }

        scan.close();
    }


    /**
     * Function name - printBoard()
     *
     * @param board (char[][])
     *              Inside the function:
     *              1. print a new line.
     *              2. print the board.
     *              • separate each row by two lines.
     *              • each row precedes a tab of space
     *              • each character in the grid has one space from the other character
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
     *      Inside the function
     *      1. Asks the user: - pick a row and column number:
     *      2.(ignore till task5) Check if the spot is taken. If so, let the user choose again.
     *      3. Return the row and column in an int[] array.
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
}
