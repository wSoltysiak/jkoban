package pl.brasswillow;

public class Board {
    private MoveElement player;
    private MoveElement box;
    private BoardElement storage;

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Board putPlayer(int x, int y) {
        player = new MoveElement(x, y);
        return this;
    }

    public boolean isPlayerPosition(int x, int y) {
        return isEquals(x, y, player);
    }

    public Board putBox(int x, int y) {
        box = new MoveElement(x, y);
        return this;
    }

    public boolean isBoxPosition(int x, int y) {
        return isEquals(x, y, box);
    }

    public Board putStorage(int x, int y) {
        storage = new BoardElement(x, y);
        return this;
    }

    public boolean isStoragePosition(int x, int y) {
        return isEquals(x, y, storage);
    }

    private boolean isEquals(int x, int y, BoardElement boardElement) {
        return new BoardElement(x, y).canEquals(boardElement);
    }

    public BoardElement getBox() {
        return box;
    }

    public BoardElement getStorage() {
        return storage;
    }

    public void movePlayerLeft() {
        int xAfterMove = player.x - 1;
        if (isOnBoard("x", xAfterMove)) {
            if (isBoxPosition(xAfterMove, player.y)) {
                movePlayerLeftWithBox();
            } else {
                player.moveLeft();
            }
        }
    }

    private void movePlayerLeftWithBox() {
        if (canMoveBoxLeft()) {
            box.moveLeft();
            player.moveLeft();
        }
    }

    private boolean canMoveBoxLeft()
    {
        int xAfterMove = box.x - 1;
        return isOnBoard("x", xAfterMove);
    }

    public void movePlayerRight() {
        int xAfterMove = player.x + 1;
        if (isOnBoard("x", xAfterMove)) {
            if (isBoxPosition(xAfterMove, player.y)) {
                movePlayerRightWithBox();
            } else {
                player.moveRight();
            }
        }
    }

    private void movePlayerRightWithBox() {
        if (canMoveBoxRight()) {
            box.moveRight();
            player.moveRight();
        }
    }

    private boolean canMoveBoxRight() {
        int xAfterMove = box.x + 1;
        return isOnBoard("x", xAfterMove);
    }

    public void movePlayerUp() {
        int yAfterMove = player.y - 1;
        if (isOnBoard("y", yAfterMove)) {
            if (isBoxPosition(player.x, yAfterMove)) {
                movePlayerUpWithBox();
            } else {
                player.moveUp();
            }
        }
    }

    private void movePlayerUpWithBox() {
        if (canMoveBoxUp()) {
            box.moveUp();
            player.moveUp();
        }
    }

    private boolean canMoveBoxUp() {
        int yAfterMove = box.y - 1;
        return isOnBoard("y", yAfterMove);
    }

    public void movePlayerDown() {
        int yAfterMove = player.y + 1;
        if (yAfterMove != this.height) {
            if (isBoxPosition(player.x, yAfterMove)) {
                movePlayerDownWithBox();
            } else {
                player.moveDown();
            }
        }
    }

    private void movePlayerDownWithBox() {
        if (canMoveBoxDown()) {
            box.moveDown();
            player.moveDown();
        }
    }

    private boolean canMoveBoxDown() {
        int yAfterMove = box.y + 1;
        return isOnBoard("y", yAfterMove);
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
