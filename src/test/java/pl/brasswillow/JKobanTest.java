package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JKobanTest {

    private JKoban cut;

    @Test
    public void gameShouldBeOverWhenBoxIsInStorage() {
        // given
        Board board = new Board(1, 1)
                .putStorage(0, 0)
                .putBox(0, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver();

        // then
        assertThat(gameOver).isTrue();
    }

    @Test
    public void gameShouldNotBeOverWhenBoxIsNotInStorage() {
        // given
        Board board = new Board(2, 1)
                .putStorage(1, 0)
                .putBox(0, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver();

        // then
        assertThat(gameOver).isFalse();
    }

    @Test
    public void gameShouldBeOverWhenTwoBoxesIsInTwoStorages() {
        // given
        Board board = new Board(2, 1)
                .putStorage(0, 0)
                .putStorage(1, 0)
                .putBox(0, 0)
                .putBox(1, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver();

        // then
        assertThat(gameOver).isTrue();
    }

    @Test
    public void gameShouldNotBeOverWhenOneOfBoxesIsOutOfStorages() {
        // given
        Board board = new Board(3, 1)
                .putStorage(0, 0)
                .putStorage(1, 0)
                .putBox(0, 0)
                .putBox(2, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver();

        // then
        assertThat(gameOver).isFalse();
    }

    @Test
    public void gameShouldBeOverWhenBoxIsOnOneOfStorages() {
        // given
        Board board = new Board(3, 1)
                .putStorage(0, 0)
                .putStorage(1, 0)
                .putBox(0, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver();

        // then
        assertThat(gameOver).isTrue();
    }
}
