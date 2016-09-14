package pl.brasswillow;

import java.util.ArrayList;

public class JKoban {
    private Board board;
    private BoardPrinter printer;
    private CommandProcessor commandProcessor;

    public JKoban(Board board) {
        this.board = board;
        this.printer = new BoardPrinter();
        this.commandProcessor = new CommandProcessor(board);
    }

    public static void main(String[] args) {
        Board board = new Board(3, 1)
                .putPlayer(0, 0)
                .putBox(1, 0)
                .putStorage(2, 0);
        JKoban jKoban = new JKoban(board);
        jKoban.printBoard();
    }

    private void printBoard() {
        System.out.println(printer.getBoardString(board));
    }

    boolean isGameOver() {
        ArrayList<MoveElement> boxes = board.getBoxes();
        for (BoardElement box : boxes) {
            if (!board.isStoragePosition(box.x, box.y)) {
                return false;
            }
        }
        return true;
    }
}