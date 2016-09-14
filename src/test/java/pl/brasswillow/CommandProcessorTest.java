package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandProcessorTest {
    private CommandProcessor cut;

    @Test
    public void playerShouldMoveLeft() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(1, 0);
        cut = new CommandProcessor();

        // when
        cut.process(board, "move left");

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveRight() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0);
        cut = new CommandProcessor();

        // when
        cut.process(board, "move right");

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveUp() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 1);
        cut = new CommandProcessor();

        // when
        cut.process(board, "move up");

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveDown() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 0);
        cut = new CommandProcessor();

        // when
        cut.process(board, "move down");

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }
}