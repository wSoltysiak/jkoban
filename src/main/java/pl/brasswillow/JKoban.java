package pl.brasswillow;

public class JKoban {
    private Board board;
    private BoardPrinter printer;

    public JKoban(Board board) {
        this.board = board;
        this.printer = new BoardPrinter();
    }

    public static void main(String[] args) {
        Board board = new Board(3, 1)
                .putPlayer(0, 0)
                .putBox(1, 0)
                .putStorage(2, 0);
        JKoban jKoban = new JKoban(board);
        jKoban.printBoard();
    }

    void printBoard() {
        System.out.println(printer.getBoardString(board));
    }

    boolean isGameOver() {
        return board.getBoxes().canEquals(board.getStorages());
    }
}