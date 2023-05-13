public class Vertical extends Player {
    private int col = 0;

    public Vertical(String name) {
        super(name);
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void move(Horizontal otherPlayer, int row, Board board) {
        addScore(board.getCellValue(row, col));
        int[] currMarker = board.getCurrMarker();
        board.makeCellEmpty(currMarker[0], currMarker[1]);
        board.makeCellMarker(row, col);
        otherPlayer.setRow(row);
    }
}