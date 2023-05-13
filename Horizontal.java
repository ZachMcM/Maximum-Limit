public class Horizontal extends Player {
    private int row = 0;

    public Horizontal(String name) {
        super(name);
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void move(Vertical otherPlayer, int col, Board board) {
        addScore(board.getCellValue(row, col));
        int[] currMarker = board.getCurrMarker();
        board.makeCellEmpty(currMarker[0], currMarker[1]);
        board.makeCellMarker(row, col);
        otherPlayer.setCol(col);
    }
}
