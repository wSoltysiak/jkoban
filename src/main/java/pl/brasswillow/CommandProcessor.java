package pl.brasswillow;

import java.util.HashMap;

public class CommandProcessor {
    public void process(Board board, String message) {
        HashMap<String, String> command = splitMessageToCommand(message);
        switch (command.get("base")) {
            case "move":
                String direction = command.get("parameter");
                movePlayer(board, direction);
                break;
            default:
                break;
        }
    }

    private HashMap<String, String> splitMessageToCommand(String message) {
        String[] splited = message.split(" ");
        HashMap<String, String> command = new HashMap<>();
        command.put("base", splited[0]);
        if (splited.length > 1) {
            command.put("parameter", splited[1]);
        }

        return command;
    }

    private void movePlayer(Board board, String direction) {
        switch (direction) {
            case "left":
                board.movePlayerLeft();
                break;
            case "right":
                board.movePlayerRight();
                break;
            case "up":
                board.movePlayerUp();
                break;
            case "down":
                board.movePlayerDown();
                break;
            default:
                break;
        }
    }
}
