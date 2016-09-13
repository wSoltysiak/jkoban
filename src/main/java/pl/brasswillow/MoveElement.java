package pl.brasswillow;

public class MoveElement extends BoardElement {
    MoveElement(int x, int y) {
        super(x, y);
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }

    public void moveUp() {
        this.y--;
    }

    public void moveDown() {
        this.y++;
    }
}
