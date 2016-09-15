package pl.brasswillow;

import java.util.HashMap;
import java.util.StringJoiner;

public class BoardPrinter {
    private Board board;
    private HashMap<String, String> characters;

    BoardPrinter(Board board) {
        this.board = board;
        characters = new HashMap<>();
        fillCharactersMap();
    }

    private void fillCharactersMap() {
        characters.put("player", "@");
        characters.put("box", "o");
        characters.put("storage", ".");
        characters.put("doneBox", "*");
        characters.put("floor", " ");
        characters.put("wall", "#");
    }

    public String getBoardString() {
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
                hLine += characters.get("player");
                continue;
            }
            if (board.isBoxPosition(x, y) && board.isStoragePosition(x, y)) {
                hLine += characters.get("doneBox");
                continue;
            }
            if (board.isBoxPosition(x, y)) {
                hLine += characters.get("box");
                continue;
            }
            if (board.isStoragePosition(x, y)) {
                hLine += characters.get("storage");
                continue;
            }
            if (board.isWallPosition(x, y)) {
                hLine += characters.get("wall");
                continue;
            }
            hLine += characters.get("floor");
        }
        return characters.get("wall") +  hLine + characters.get("wall");
    }

    private String getHorizontalBorder() {
        int borderLength = 2;
        String hBorder = "";
        int printBoardLength = board.getWidth() + borderLength;
        for (int i = 0; i < printBoardLength; i++) {
            hBorder += characters.get("wall");
        }
        return hBorder;
    }
}
