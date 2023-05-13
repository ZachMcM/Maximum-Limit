import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Board board = new Board();

        BetterPrint.print("Welcome to maximum limit!");

        BetterPrint.print("Player one enter your name");
        Horizontal p1 = new Horizontal(input.nextLine());
        System.out.println("");
        BetterPrint.print("Hello " + p1.getName());

        BetterPrint.print("Player two enter your name");
        Vertical p2 = new Vertical(input.nextLine());
        System.out.println("");
        BetterPrint.print("Hello " + p2.getName());

        BetterPrint.print("Here is the starting board");

        board.printBoard();

        while (!board.isRowEmpty(p1.getRow()) && !board.isColEmpty(p2.getCol())) {
            // player one's turn
            BetterPrint.print(p1.getName() + "'s turn");
            int currRow = p1.getRow();
            BetterPrint.print("You must pick a a column in row " + (currRow + 1));
            int chosenCol = input.nextInt();
            while (chosenCol <= 0 || chosenCol > 5 || board.isCellMarker(currRow, chosenCol - 1)
                    || board.isCellEmpty(currRow, chosenCol - 1)) {
                BetterPrint.print("Please enter a valid column");
                chosenCol = input.nextInt();
            }
            p1.move(p2, chosenCol - 1, board);

            BetterPrint.print(p1.getName() + "'s score is " + p1.getScore());
            board.printBoard();

            if (board.isColEmpty(currRow) || board.isRowEmpty(chosenCol - 1)) {
                break;
            }

            // player two's turn
            BetterPrint.print(p2.getName() + "'s turn");
            int currCol = p2.getCol();
            BetterPrint.print("You must pick a row for column " + (currCol + 1));
            int chosenRow = input.nextInt();
            while (chosenRow <= 0 || chosenRow > 5 || board.isCellMarker(chosenRow - 1, currCol)
                    || board.isCellEmpty(chosenRow - 1, currCol)) {
                BetterPrint.print("Please enter a valid row");
                chosenRow = input.nextInt();
            }
            p2.move(p1, chosenRow - 1, board);

            BetterPrint.print(p2.getName() + "'s score is " + p2.getScore());
            board.printBoard();

            if (board.isRowEmpty(chosenRow - 1) || board.isColEmpty(currCol)) {
                break;
            }
        }

        int p1Score = p1.getScore();
        int p2Score = p2.getScore();
        BetterPrint.print(p1.getName() + "s score: " + p1Score);
        BetterPrint.print(p2.getName() + "s score: " + p2Score);

        if (p1Score > p2Score) {
            BetterPrint.print(p1.getName() + " wins!");
        } else {
            BetterPrint.print(p2.getName() + " wins!");
        }

        BetterPrint.print("Game over");
        input.close();
    }
}