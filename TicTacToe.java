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
        scan.close();
    }


    /**
     * Function name - printBoard()
     *
     * @param board (char[][])
     *              <p>
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
}
