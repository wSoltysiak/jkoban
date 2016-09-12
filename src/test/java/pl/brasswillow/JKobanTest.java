package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JKobanTest {

    private static final String EMPTY_BOARD =
            "" +
                    "####\n" +
                    "#  #\n" +
                    "####";

    private static final String BOARD_WITH_PAYER_0_0 =
            "" +
                    "####\n" +
                    "#@ #\n" +
                    "####";

    private static final String BOARD_WITH_PLAYER_0_0_BOX_1_0 =
            "" +
                    "####\n" +
                    "#@o#\n" +
                    "####";

    private static final String BOARD_WITH_STORAGE_ONLY =
            "" +
                    "###\n" +
                    "#.#\n" +
                    "###";
    private static final String BOARD_WITH_PLAYER_1_0 =
            "" +
                    "####\n" +
                    "# @#\n" +
                    "####";
    private static final String BOARD_WITH_PLAYER_2_0 =
            "" +
                    "#####\n" +
                    "#  @#\n" +
                    "#####";


    private JKoban cut;

    @Test
    public void shouldPrintEmptyBoard() throws Exception {
        // given
        Board board = new Board(2, 1);
        cut = new JKoban(board);

        // when
        String result = cut.getBoardString();

        // then
        assertThat(result).isEqualTo(EMPTY_BOARD);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0() throws Exception {
        // given
        Board board = new Board(2, 1);
        board.putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        String result = cut.getBoardString();

        // then
        assertThat(result).isEqualTo(BOARD_WITH_PAYER_0_0);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0_andBox_1_0() throws Exception {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0)
                .putBox(1, 0);
        cut = new JKoban(board);

        // when
        String result = cut.getBoardString();

        // then
        assertThat(result).isEqualTo(BOARD_WITH_PLAYER_0_0_BOX_1_0);
    }

    @Test
    public void shouldPrintBoardWithSorageOnly() throws Exception {
        // given
        Board board = new Board(1, 1)
                .putStorage(0, 0);
        cut = new JKoban(board);

        // when
        String result = cut.getBoardString();

        // then
        assertThat(result).isEqualTo(BOARD_WITH_STORAGE_ONLY);
    }

    @Test
    public void gameShouldBeFinishedWhenBoxIsInStorage() {
        // given
        Board board = new Board(1, 1)
                .putStorage(0, 0)
                .putBox(0, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver(board);

        // then
        assertThat(gameOver).isTrue();
    }

    @Test
    public void gameShouldNotBeFinishedWhenBoxIsNotInStorage() {
        // given
        Board board = new Board(2, 1)
                .putStorage(1, 0)
                .putBox(0, 0);
        cut = new JKoban(board);

        // when
        boolean gameOver = cut.isGameOver(board);

        // then
        assertThat(gameOver).isFalse();
    }

    @Test
    public void playerShouldMoveLeft() throws Exception {
        // given
        Board board = new Board(2, 1)
                .putPlayer(1, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerLeft();
        String result = cut.getBoardString();

        // then
        assertThat(result).isEqualTo(BOARD_WITH_PAYER_0_0);
    }

    @Test
    public void playerShouldNotMoveLeftWhenWallOnLeft() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerLeft();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveRight() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(1, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveRightWhenWallIsOnRight() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerRight();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveUp() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 1);
        cut = new JKoban(board);

        // when
        cut.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldNotMoveUpWhenWallIsOnUp() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerUp();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveDown() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldNotMoveDownWhenWallIsOnDown() {
        // given
        Board board = new Board(1, 1)
                .putPlayer(0, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 0)).isTrue();
    }

    @Test
    public void playerShouldMoveLeftThenRight() {
        // given
        Board board = new Board(2, 1)
                .putPlayer(1, 0);
        cut = new JKoban(board);

        // when
        cut.movePlayerLeft();
        cut.movePlayerRight();
        String result = cut.getBoardString();

        // then
        assertThat(result).isEqualTo(BOARD_WITH_PLAYER_1_0);
    }

    @Test
    public void playerShouldMoveUpThenDown() {
        // given
        Board board = new Board(1, 2)
                .putPlayer(0,1);
        cut = new JKoban(board);

        // when
        cut.movePlayerUp();
        cut.movePlayerDown();

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }

    @Test
    public void playerShouldGoByPath() {
        // given
        Board board = new Board(3,3)
                .putPlayer(0,0);
        cut = new JKoban(board);

        // when
        cut.movePlayerRight();
        cut.movePlayerRight();
        cut.movePlayerDown();
        cut.movePlayerLeft();
        cut.movePlayerDown();
        cut.movePlayerLeft();
        cut.movePlayerUp();

        System.out.println(cut.getBoardString());

        // then
        assertThat(board.isPlayerPosition(0, 1)).isTrue();
    }
}
