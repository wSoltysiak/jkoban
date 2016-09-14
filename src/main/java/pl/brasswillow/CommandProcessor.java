package pl.brasswillow;

import java.util.HashMap;

public class CommandProcessor {
    private Board board;
    private HashMap<String, Runnable> methods;

    CommandProcessor(Board board) {
        this.board = board;
        fillMethodsMap();
    }

    private void fillMethodsMap() {
        methods = new HashMap<>();
        methods.put("left", () -> board.movePlayerLeft());
        methods.put("right", () -> board.movePlayerRight());
        methods.put("up", () -> board.movePlayerUp());
        methods.put("down", () -> board.movePlayerDown());
    }

    public void process(String command) {
        methods.get(command).run();
    }
}
