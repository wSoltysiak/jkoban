package pl.brasswillow;

import java.util.ArrayList;

public class Board {
    private MoveElement player;
    private ArrayList<MoveElement> boxes;
    private ArrayList<BoardElement> storages;
    private ArrayList<BoardElement> walls;

    private int width;
    private int height;

    private Board cleanState;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<MoveElement> getBoxes() {
        return boxes;
    }

    public ArrayList<BoardElement> getStorages() {
        return storages;
    }

    public MoveElement getPlayer() {
        return player;
    }

    public ArrayList<BoardElement> getWalls() {
        return walls;
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        player = new MoveElement(-1, -1);
        boxes = new ArrayList<>();
        storages = new ArrayList<>();
        walls = new ArrayList<>();
    }

    public Board putPlayer(int x, int y) {
        player = new MoveElement(x, y);
        return this;
    }

    public boolean isPlayerPosition(int x, int y) {
        return canEquals(x, y, player);
    }

    public Board putBox(int x, int y) {
        boxes.add(new MoveElement(x, y));
        return this;
    }

    public boolean isBoxPosition(int x, int y) {
        for (MoveElement box : boxes) {
            if (canEquals(x, y, box)) {
                return true;
            }
        }
        return false;
    }

    public MoveElement getBoxByPosition(int x, int y) {
        for (MoveElement box : boxes) {
            if (canEquals(x, y, box)) {
                return box;
            }
        }
        return new MoveElement(0, 0);
    }

    public Board putStorage(int x, int y) {
        storages.add(new BoardElement(x, y));
        return this;
    }

    public boolean isStoragePosition(int x, int y) {
        for (BoardElement storage : storages) {
            if (canEquals(x, y, storage)) {
                return true;
            }
        }
        return false;
    }

    public Board putWall(int x, int y) {
        walls.add(new BoardElement(x, y));
        return this;
    }

    public boolean isWallPosition(int x, int y) {
        for (BoardElement wall : walls) {
            if (canEquals(x, y, wall)) {
                return true;
            }
        }
        return false;
    }

    private boolean canEquals(int x, int y, BoardElement boardElement) {
        return new BoardElement(x, y).canEquals(boardElement);
    }

    public void movePlayerLeft() {
        int xAfterMove = player.x - 1;
        moveBoxLeft(xAfterMove);
        if (canMove(xAfterMove, player.y)) {
            player.moveLeft();
        }
    }

    private void moveBoxLeft(int xAfterMove) {
        MoveElement nearbyBox = getBoxByPosition(xAfterMove, player.y);
        int xAfterMoveBox = nearbyBox.x - 1;
        if (canMove(xAfterMoveBox, nearbyBox.y)) {
            nearbyBox.moveLeft();
        }
    }

    public void movePlayerRight() {
        int xAfterMove = player.x + 1;
        moveBoxRight(xAfterMove);
        if (canMove(xAfterMove, player.y)) {
            player.moveRight();
        }
    }

    private void moveBoxRight(int xAfterMove) {
        MoveElement nearbyBox = getBoxByPosition(xAfterMove, player.y);
        int xAfterMoveBox = nearbyBox.x + 1;
        if (canMove(xAfterMoveBox, nearbyBox.y)) {
            nearbyBox.moveRight();
        }
    }

    public void movePlayerUp() {
        int yAfterMove = player.y - 1;
        moveBoxUp(yAfterMove);
        if (canMove(player.x, yAfterMove)) {
            player.moveUp();
        }
    }

    private void moveBoxUp(int yAfterMove) {
        MoveElement nearbyBox = getBoxByPosition(player.x, yAfterMove);
        int yAfterMoveBox = nearbyBox.y - 1;
        if (canMove(nearbyBox.x, yAfterMoveBox)) {
            nearbyBox.moveUp();
        }
    }

    public void movePlayerDown() {
        int yAfterMove = player.y + 1;
        moveBoxDown(yAfterMove);
        if (canMove(player.x, yAfterMove)) {
            player.moveDown();
        }
    }

    private void moveBoxDown(int yAfterMove) {
        MoveElement nearbyBox = getBoxByPosition(player.x, yAfterMove);
        int yAfterMoveBox = nearbyBox.y + 1;
        if (canMove(nearbyBox.x, yAfterMoveBox)) {
            nearbyBox.moveDown();
        }
    }

    private boolean canMove(int xAfterMove, int yAfterMove) {
        return isOnBoard("x", xAfterMove) && isOnBoard("y", yAfterMove)
                && !isWallPosition(xAfterMove, yAfterMove) && !isBoxPosition(xAfterMove, yAfterMove);
    }

    private boolean isOnBoard(String axis, int value) {
        if (axis.equals("x")) {
            return value > -1 && value < width;
        } else if (axis.equals("y")) {
            return value > -1 && value < height;
        }
        return false;
    }

    public void saveCleanState() {
        try {
            cleanState = (Board) this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Board cloneBoard = new Board(width, height);

        for (MoveElement box : boxes) {
            cloneBoard.putBox(box.x, box.y);
        }

        for (BoardElement storage : storages) {
            cloneBoard.putStorage(storage.x, storage.y);
        }

        cloneBoard.putPlayer(player.x, player.y);

        return cloneBoard;
    }

    public void resetBoard() {
        boxes = cleanState.getBoxes();
        storages = cleanState.getStorages();
        player = cleanState.getPlayer();
    }
}
