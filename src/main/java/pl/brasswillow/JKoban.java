package pl.brasswillow;

import java.io.PrintStream;
import java.util.StringJoiner;

public class JKoban {
    private Board board;

    public JKoban(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {
        Board theBoard = new Board(3,1)
            .putPlayer(0,0)
            .putBox(1,0)
            .putStorage(2,0);
        JKoban jKoban = new JKoban(theBoard);
        jKoban.drawBoard();
    }

    private void drawBoard() {
        PrintStream printStream = System.out;
        printStream.println(getBoardString());
    }

    String getBoardString() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(getHorizontalBorder());
        for (int y = 0; y < board.getHeight(); y++) {
            sj.add(getBoardLine(y));
        }
        sj.add(getHorizontalBorder());
        return sj.toString();
    }

    private String getBoardLine(int y) {
        String hLine = "";
        for (int x = 0; x < board.getWidth(); x++) {
            if (board.isPlayerPosition(x, y)) {
                hLine += "@";
                continue;
            }
            if (board.isBoxPosition(x, y)) {
                hLine += "o";
                continue;
            }if (board.isStoragePostion(x, y)) {
                hLine += ".";
                continue;
            }
            hLine += " ";
        }
        return "#" + hLine + "#";
    }

    private String getHorizontalBorder() {
        String hBorder = "##";
        for (int i = 0; i < board.getWidth(); i++) {
            hBorder += "#";
        }
        return hBorder;
    }

}