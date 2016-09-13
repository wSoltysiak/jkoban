package pl.brasswillow;

class BoardElement {
    int x;
    int y;

    BoardElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canEquals(BoardElement element) {
        return this == element || element != null && x == element.x && y == element.y;
    }
}
