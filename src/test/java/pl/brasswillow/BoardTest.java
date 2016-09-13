package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    @Test
    public void playerShouldMoveLeft() throws Exception {
        // given
        Board board = new Board(2, 1)
                .putPlayer(1, 0);

        // when
        board.movePlayerLeft();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveLeftWhenWallOnLeft() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        board.movePlayerLeft();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveRight() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0);

        // when
        board.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveRightWhenWallIsOnRight() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        board.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveUp() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 1);

        // when
        board.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveUpWhenWallIsOnUp() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        board.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveDown() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 0);

        // when
        board.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldNotMoveDownWhenWallIsOnDown() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        board.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveLeftThenRight() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(1, 0);

        // when
        board.movePlayerLeft();
        board.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveUpThenDown() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0,1);

        // when
        board.movePlayerUp();
        board.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldGoByPath() {
        // given
        Board board = new Board(3,3)
                .putPlayer(0,0);

        // when
        board.movePlayerRight();
        board.movePlayerRight();
        board.movePlayerDown();
        board.movePlayerLeft();
        board.movePlayerDown();
        board.movePlayerLeft();
        board.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }
}