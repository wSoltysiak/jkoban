package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board cut;

    @Test
    public void playerShouldMoveLeft() throws Exception {
        // given
        cut = new Board(2, 1)
                .putPlayer(1, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveLeftWhenWallBoardOnLeft() {
        // given
        cut = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveRight() {
        // given
        cut = new Board(2, 1)
                .putPlayer(0, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveRightWhenWallBoardIsOnRight() {
        // given
        cut = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveUp() {
        // given
        cut = new Board(1, 2)
                .putPlayer(0, 1);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveUpWhenWallBoardIsOnUp() {
        // given
        cut = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveDown() {
        // given
        cut = new Board(1, 2)
                .putPlayer(0, 0);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldNotMoveDownWhenWallBoardIsOnDown() {
        // given
        cut = new Board(1, 1)
                .putPlayer(0, 0);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveLeftThenRight() {
        // given
        cut = new Board(2, 1)
                .putPlayer(1, 0);

        // when
        cut.movePlayerLeft();
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveUpThenDown() {
        // given
        cut = new Board(1, 2)
                .putPlayer(0, 1);

        // when
        cut.movePlayerUp();
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldGoByPath() {
        // given
        cut = new Board(3, 3)
                .putPlayer(0, 0);

        // when
        cut.movePlayerRight();
        cut.movePlayerRight();
        cut.movePlayerDown();
        cut.movePlayerLeft();
        cut.movePlayerDown();
        cut.movePlayerLeft();
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInLeft() {
        // given
        cut = new Board(3, 1)
                .putPlayer(2, 0)
                .putBox(1, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(1, 0)).isTrue();
        assertThat(cut.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInLeftWhenIsWallBoardAfterBox() {
        // given
        cut = new Board(2, 1)
                .putPlayer(1, 0)
                .putBox(0, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(1, 0)).isTrue();
        assertThat(cut.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInRight() {
        // given
        cut = new Board(3, 1)
                .putPlayer(0, 0)
                .putBox(1, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(1, 0)).isTrue();
        assertThat(cut.isBoxPosition(2, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInRightWhenIsWallBoardAfterBox() {
        // given
        cut = new Board(2, 1)
                .putPlayer(0, 0)
                .putBox(1, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInUp() {
        // given
        cut = new Board(1, 3)
                .putPlayer(0, 2)
                .putBox(0, 1);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
        assertThat(cut.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInUpWhenIsWallBoardAfterBox() {
        // given
        cut = new Board(1, 2)
                .putPlayer(0, 1)
                .putBox(0, 0);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
        assertThat(cut.isBoxPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveBoxInDown() {
        // given
        cut = new Board(1, 3)
                .putPlayer(0, 0)
                .putBox(0, 1);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
        assertThat(cut.isBoxPosition(0, 2)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInDownWhenIsWallBoardAfterBox() {
        // given
        cut = new Board(1, 2)
                .putPlayer(0, 0)
                .putBox(0, 1);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInLeftWhenIsBoxAfterBox() {
        // given
        cut = new Board(4, 0)
                .putPlayer(3, 0)
                .putBox(2, 0)
                .putBox(1, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(3, 0)).isTrue();
        assertThat(cut.isBoxPosition(2, 0)).isTrue();
        assertThat(cut.isBoxPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInRightWhenIsBoxAfterBox() {
        // given
        cut = new Board(4, 0)
                .putPlayer(0, 0)
                .putBox(1, 0)
                .putBox(2, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(1, 0)).isTrue();
        assertThat(cut.isBoxPosition(2, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInUpWhenIsBoxAfterBox() {
        // given
        cut = new Board(0, 4)
                .putPlayer(0, 3)
                .putBox(0, 2)
                .putBox(0, 1);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 3)).isTrue();
        assertThat(cut.isBoxPosition(0, 2)).isTrue();
        assertThat(cut.isBoxPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldNotMoveBoxInDownWhenIsBoxAfterBox() {
        // given
        cut = new Board(0, 4)
                .putPlayer(0, 0)
                .putBox(0, 1)
                .putBox(0, 2);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(0, 1)).isTrue();
        assertThat(cut.isBoxPosition(0, 2)).isTrue();
    }

    @Test
    public void boardShouldReset() {
        // given
        cut = new Board(0, 3)
                .putPlayer(0, 0)
                .putBox(0, 1)
                .putStorage(0, 2);
        cut.saveCleanState();

        // when
        cut.movePlayerDown();
        cut.resetBoard();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(0, 1)).isTrue();
        assertThat(cut.isStoragePosition(0, 2)).isTrue();
    }

    @Test
    public void playerShouldNotMoveLeftWhenWallOnLeft() {
        // given
        cut = new Board(2, 0)
                .putPlayer(1, 0)
                .putWall(0, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(1, 0)).isTrue();
        assertThat(cut.isWallPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveLeftWithBoxWhenWallAfterBox() {
        // given
        cut = new Board(3, 0)
                .putPlayer(2, 0)
                .putBox(1, 0)
                .putWall(0, 0);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(cut.isPlayerPosition(2, 0)).isTrue();
        assertThat(cut.isBoxPosition(1, 0)).isTrue();
        assertThat(cut.isWallPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveRightWhenWallOnRight() {
        // given
        cut = new Board(2, 0)
                .putPlayer(0, 0)
                .putWall(1, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isWallPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveRightWithBoxWhenWallAfterBox() {
        // given
        cut = new Board(3, 0)
                .putPlayer(0, 0)
                .putBox(1, 0)
                .putWall(2, 0);

        // when
        cut.movePlayerRight();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(1, 0)).isTrue();
        assertThat(cut.isWallPosition(2, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveUpWhenWallUp() {
        // given
        cut = new Board(0, 2)
                .putPlayer(0, 1)
                .putWall(0, 0);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 1)).isTrue();
        assertThat(cut.isWallPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveUpWithBoxWhenWallAfterBox() {
        // given
        cut = new Board(0, 3)
                .putPlayer(0, 2)
                .putBox(0, 1)
                .putWall(0, 0);

        // when
        cut.movePlayerUp();

        // then
        assertThat(cut.isPlayerPosition(0, 2)).isTrue();
        assertThat(cut.isBoxPosition(0, 1)).isTrue();
        assertThat(cut.isWallPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveDownWhenWallDown() {
        // given
        cut = new Board(0, 2)
                .putPlayer(0, 0)
                .putWall(0, 1);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isWallPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldNotMoveDownWithBoxWhenWallAfterBox() {
        // given
        cut = new Board(0, 3)
                .putPlayer(0, 0)
                .putBox(0, 1)
                .putWall(0, 2);

        // when
        cut.movePlayerDown();

        // then
        assertThat(cut.isPlayerPosition(0, 0)).isTrue();
        assertThat(cut.isBoxPosition(0, 1)).isTrue();
        assertThat(cut.isWallPosition(0, 2)).isTrue();
    }
}