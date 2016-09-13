package pl.brasswillow;

public class Board {
    private Player player;
    private BoardElement box;
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
        player = new Player(x, y);
        return this;
    }

    public boolean isPlayerPosition(int x, int y) {
        return isEquals(x, y, player);
    }

    private boolean isEquals(int x, int y, BoardElement boardElement) {
        return new BoardElement(x, y).canEquals(boardElement);
    }

    public Board putBox(int x, int y) {
        box = new BoardElement(x, y);
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

    public BoardElement getBox() {
        return box;
    }

    public BoardElement getStorage() {
        return storage;
    }

    public void movePlayerLeft() {
        int xAfterMove = player.x - 1;
        if (xAfterMove != -1) {
            this.player.moveLeft();
        }
    }

    public void movePlayerRight() {
        int xAfterMove = player.x + 1;
        if (xAfterMove != this.width) {
            this.player.moveRight();
        }
    }

    public void movePlayerUp() {
        int yAfterMove = player.y - 1;
        if (yAfterMove != -1) {
            this.player.moveUp();
        }
    }

    public void movePlayerDown() {
        int yAfterMove = player.y + 1;
        if (yAfterMove != this.height) {
            this.player.moveDown();
        }
    }
}
