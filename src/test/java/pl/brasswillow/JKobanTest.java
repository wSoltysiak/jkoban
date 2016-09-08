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

    //given
    Board board = new Board(2, 1).putPlayer(1, 0);

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
    public void game_should_be_finished_when_box_is_in_storage() {
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
    public void game_should_not_be_finished_when_box_is_not_in_storage() {
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
    public void player_should_not_move_right_when_wall_is_on_right() {
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
    public void player_should_move_right_twice(){
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
