package pl.brasswillow;

import java.io.PrintStream;
import java.util.StringJoiner;

public class BoardPrinter {
    private Board board;

    public String getBoardString(Board board) {
        this.board = board;

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
            }
            if (board.isStoragePosition(x, y)) {
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
