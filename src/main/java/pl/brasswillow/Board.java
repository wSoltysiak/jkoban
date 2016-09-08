package pl.brasswillow;

public class Board {

    private Artifact player;
    private Artifact box;
    private Artifact storage;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width;

    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Board putPlayer(int x, int y) {
        player = new Artifact(x,y);
        return this;
    }

    public boolean isPlayerPosition(int x, int y) {
        return isEquals(x, y, player);
    }

    private boolean isEquals(int x, int y, Artifact artifact) {
        return new Artifact(x, y).equals(artifact);
    }

    public Board putBox(int x, int y){
        box = new Artifact(x,y);
        return this;
    }

    public boolean isBoxPosition(int x, int y){
        return isEquals(x, y, box);
    }

    public Board putStorage(int x, int y) {
        storage = new Artifact(x,y);
        return this;
    }

    public boolean isStoragePosition(int x, int y){
        return isEquals(x, y, storage);
    }

    public Artifact getBox() {
        return box;
    }

    public Artifact getStorage() {
        return storage;
    }

    public Artifact getPlayer() {
        return player;
    }

    class Artifact {
        int x;
        int y;

        private Artifact(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Artifact artifact = (Artifact) o;

            if (x != artifact.x) return false;
            return y == artifact.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
