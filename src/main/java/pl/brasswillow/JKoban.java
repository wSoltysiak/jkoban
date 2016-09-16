package pl.brasswillow;

import org.glassfish.tyrus.server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class JKoban {
    private Board board;
    private BoardPrinter printer;
    private CommandProcessor commandProcessor;

    public JKoban(Board board) {
        this.board = board;
        this.printer = new BoardPrinter(board);
        this.commandProcessor = new CommandProcessor(board);
    }

    public static void main(String[] args) {
        Board board = new Board(7, 7)
                .putWall(0, 0)
                .putWall(0, 1)
                .putWall(0, 2)
                .putWall(0, 3)
                .putWall(1, 2)
                .putWall(1, 3)
                .putWall(3, 3)
                .putWall(3, 4)
                .putWall(3, 5)
                .putWall(3, 6)
                .putWall(4, 0)
                .putWall(4, 1)
                .putWall(4, 3)
                .putWall(5, 0)
                .putWall(5, 3)
                .putWall(5, 4)
                .putWall(5, 5)
                .putWall(6, 0)
                .putWall(6, 5)
                .putStorage(6, 2)
                .putStorage(6, 3)
                .putStorage(6, 4)
                .putBox(1, 4)
                .putBox(1, 5)
                .putBox(2, 5)
                .putPlayer(0, 6);
        board.saveCleanState();
        JKoban jKoban = new JKoban(board);
        jKoban.runServer();
    }

    private void runServer() {
        Server server = new Server("localhost", 8025, "/jkoban", JKobanServer.class);
        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Press key to stop the server.");
            reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }

    private void gameLoop() {
        Scanner scanInput = new Scanner(System.in);
        while (!isGameOver()) {
            printBoard();
            System.out.println("Command: ");
            commandProcessor.process(scanInput.nextLine());
            System.out.println();
        }
        System.out.println("You win!");
    }

    private void printBoard() {
        System.out.println(printer.getBoardString());
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