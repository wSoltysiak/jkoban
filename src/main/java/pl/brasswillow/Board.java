package pl.brasswillow;

import java.util.ArrayList;

public class Board {
    private MoveElement player;
    private ArrayList<MoveElement> boxes;
    private ArrayList<BoardElement> storages;

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<MoveElement> getBoxes() {
        return boxes;
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        boxes = new ArrayList<>();
        storages = new ArrayList<>();
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

    private boolean canEquals(int x, int y, BoardElement boardElement) {
        return new BoardElement(x, y).canEquals(boardElement);
    }

    public void movePlayerLeft() {
        int xAfterMove = player.x - 1;
        if (isOnBoard("x", xAfterMove)) {
            if (isBoxPosition(xAfterMove, player.y)) {
                MoveElement nearbyBox = getBoxByPosition(xAfterMove, player.y);
                movePlayerLeftWithBox(nearbyBox);
            } else {
                player.moveLeft();
            }
        }
    }

    private void movePlayerLeftWithBox(MoveElement nearbyBox) {
        if (canMoveBoxLeft(nearbyBox)) {
            nearbyBox.moveLeft();
            player.moveLeft();
        }
    }

    private boolean canMoveBoxLeft(MoveElement nearbyBox)
    {
        int xAfterMove = nearbyBox.x - 1;
        return isOnBoard("x", xAfterMove) && !isBoxPosition(xAfterMove, nearbyBox.y);
    }

    public void movePlayerRight() {
        int xAfterMove = player.x + 1;
        if (isOnBoard("x", xAfterMove)) {
            if (isBoxPosition(xAfterMove, player.y)) {
                MoveElement nearbyBox = getBoxByPosition(xAfterMove, player.y);
                movePlayerRightWithBox(nearbyBox);
            } else {
                player.moveRight();
            }
        }
    }

    private void movePlayerRightWithBox(MoveElement nearbyBox) {
        if (canMoveBoxRight(nearbyBox)) {
            nearbyBox.moveRight();
            player.moveRight();
        }
    }

    private boolean canMoveBoxRight(MoveElement nearbyBox) {
        int xAfterMove = nearbyBox.x + 1;
        return isOnBoard("x", xAfterMove) && !isBoxPosition(xAfterMove, nearbyBox.y);
    }

    public void movePlayerUp() {
        int yAfterMove = player.y - 1;
        if (isOnBoard("y", yAfterMove)) {
            if (isBoxPosition(player.x, yAfterMove)) {
                MoveElement nearbyBox = getBoxByPosition(player.x, yAfterMove);
                movePlayerUpWithBox(nearbyBox);
            } else {
                player.moveUp();
            }
        }
    }

    private void movePlayerUpWithBox(MoveElement nearbyBox) {
        if (canMoveBoxUp(nearbyBox)) {
            nearbyBox.moveUp();
            player.moveUp();
        }
    }

    private boolean canMoveBoxUp(MoveElement nearbyBox) {
        int yAfterMove = nearbyBox.y - 1;
        return isOnBoard("y", yAfterMove) && !isBoxPosition(nearbyBox.x, yAfterMove);
    }

    public void movePlayerDown() {
        int yAfterMove = player.y + 1;
        if (yAfterMove != this.height) {
            if (isBoxPosition(player.x, yAfterMove)) {
                MoveElement nearbyBox = getBoxByPosition(player.x, yAfterMove);
                movePlayerDownWithBox(nearbyBox);
            } else {
                player.moveDown();
            }
        }
    }

    private void movePlayerDownWithBox(MoveElement nearbyBox) {
        if (canMoveBoxDown(nearbyBox)) {
            nearbyBox.moveDown();
            player.moveDown();
        }
    }

    private boolean canMoveBoxDown(MoveElement nearbyBox) {
        int yAfterMove = nearbyBox.y + 1;
        return isOnBoard("y", yAfterMove) && !isBoxPosition(nearbyBox.x, yAfterMove);
    }

    private boolean isOnBoard(String axis, int value)
    {
        if (axis.equals("x"))
        {
            return value > -1 && value < width;
        } else if (axis.equals("y")) {
            return value > -1 && value < height;
        }
        return false;
    }
}
