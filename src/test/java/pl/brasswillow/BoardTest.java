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

    @Test
    public void playerShouldMoveBoxInLeft() {
        // given
        Board board = new Board(3, 1)
                .putPlayer(2, 0)
                .putBox(1, 0);

        // when
        board.movePlayerLeft();

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
        assertThat(board.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInLeftWhenIsWallAfterBox() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(1, 0)
                .putBox(0, 0);

        // when
        board.movePlayerLeft();

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
        assertThat(board.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInRight() {
        // given
        Board board = new Board(3, 1)
                .putPlayer(0, 0)
                .putBox(1, 0);

        // when
        board.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
        assertThat(board.isBoxPosition(2, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInRightWhenIsWallAfterBox() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0)
                .putBox(1, 0);

        // when
        board.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
        assertThat(board.isBoxPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInUp() {
        // given
        Board board = new Board(1, 3)
                .putPlayer(0, 2)
                .putBox(0, 1);

        // when
        board.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
        assertThat(board.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInUpWhenIsWallAfterBox() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 1)
                .putBox(0, 0);

        // when
        board.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
        assertThat(board.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInDown() {
        // given
        Board board = new Board(1, 3)
                .putPlayer(0, 0)
                .putBox(0, 1);

        // when
        board.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
        assertThat(board.isBoxPosition(0, 2)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInDownWhenIsWallAfterBox() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 0)
                .putBox(0, 1);

        // when
        board.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
        assertThat(board.isBoxPosition(0, 1)).isTrue();
    }
}