public class Board {
    private Cell[][] board = new Cell[5][5];
    private int[] currMarker = {0, 0};
    
    public Board() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c]= new Cell();
            }
        } 

        board[0][0].setMarker();
    }

    public int getCellValue(int r, int c) {
        return board[r][c].getValue();
    }

    public boolean isCellEmpty(int r, int c) {
        return board[r][c].isEmpty();
    }

    public void makeCellEmpty(int r, int c) {
        board[r][c].setEmpty();
    }

    public void makeCellMarker(int r, int c) {
        board[r][c].setMarker();
        currMarker[0] = r;
        currMarker[1] = c;
    } 

    public boolean isCellMarker(int r, int c) {
        return board[r][c].isMarker();
    }

    public void printBoard() {
        String displayBoard = " ________________________ \n \n";

        for (Cell[] r : board) {
            for (Cell c : r) {
                int cellValue = c.getValue();
                displayBoard += "| " + (c.isEmpty() ? "  " : (c.isMarker() ? "█ " : (cellValue < 0 ? cellValue : + cellValue + " "))) + " ";
            }
            displayBoard += "| \n ________________________ \n \n";
        }

        System.out.println(displayBoard);
        System.out.println("");
    }

    public int[] getCurrMarker() {
        return currMarker;
    }

    public boolean isRowEmpty(int r) {
        for (Cell cell : board[r]) {
            if (!cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isColEmpty(int c) {
        for (Cell[] row : board) {
            if (!row[c].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
