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
    private static final String BOARD_WITH_PLAYER_1_0 = "" +
        "####\n" +
        "# @#\n" +
        "####";
    ;
    private static final String BOARD_WITH_PLAYER_2_0 = "" +
        "#####\n" +
        "#  @#\n" +
        "#####";
    ;


    private JKoban cut;

    @Test
    public void shouldPrintEmptyBoard() throws Exception {
        //given
        Board board = new Board(2, 1);
        cut = new JKoban(board);

        //when
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(EMPTY_BOARD);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0() throws Exception {
        //given
        Board board = new Board(2, 1);
        board.putPlayer(0, 0);
        cut = new JKoban(board);

        //when
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(BOARD_WITH_PAYER_0_0);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0_andBox_1_0() throws Exception {
        //given
        Board board = new Board(2, 1)
            .putPlayer(0, 0)
            .putBox(1, 0);
        cut = new JKoban(board);

        //when
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(BOARD_WITH_PLAYER_0_0_BOX_1_0);
    }

    @Test
    public void shouldPrintBoardWithSorageOnly() throws Exception {
        //given
        Board board = new Board(1, 1)
            .putStorage(0, 0);
        cut = new JKoban(board);

        //when
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(BOARD_WITH_STORAGE_ONLY);
    }

    @Test
    public void shouldMovePlayerLeft() throws Exception {
        //given
        Board board = new Board(2, 1).putPlayer(1, 0);
        cut = new JKoban(board);

        //when
        cut.movePlayerLeft();
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(BOARD_WITH_PAYER_0_0);
    }

    @Test
    public void shouldMovePlayerLeftThenRight() {
        //given
        Board board = new Board(2, 1).putPlayer(1, 0);
        cut = new JKoban(board);

        //when
        cut.movePlayerLeft();
        cut.movePlayerRight();
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(BOARD_WITH_PLAYER_1_0);
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
    public void playerShouldNotMoveRightWhenWallIsOnRight() {
        //given
        Board board = new Board (1,1)
            .putPlayer(0,0);
        cut = new JKoban(board);

        //when
        cut.movePlayerRight();

        //then
        assertThat(board.isPlayerPosition(0,0)).isTrue();
    }

    @Test
    public void playerShouldMoveRightTwice(){
        //given
        Board board = new Board(3, 1).putPlayer(0, 0);
        cut = new JKoban(board);

        //when
        cut.movePlayerRight();
        cut.movePlayerRight();
        String result = cut.getBoardString();

        //then
        assertThat(result).isEqualTo(BOARD_WITH_PLAYER_2_0);
    }
}
