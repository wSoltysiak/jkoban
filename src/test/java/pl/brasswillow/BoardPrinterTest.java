package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardPrinterTest {
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

    private BoardPrinter cut;

    @Test
    public void shouldPrintEmptyBoard() {
        // given
        Board board = new Board(2,1);
        cut = new BoardPrinter();

        // when
        String boardResult = cut.getBoardString(board);

        // then
        assertThat(boardResult).isEqualTo(EMPTY_BOARD);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0() throws Exception {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0);
        cut = new BoardPrinter();

        // when
        String boardResult = cut.getBoardString(board);

        // then
        assertThat(boardResult).isEqualTo(BOARD_WITH_PAYER_0_0);
    }

    @Test
    public void shouldPrintBoardWithPlayerOn_0_0_andBox_1_0() throws Exception {
        // given
        Board board = new Board(2, 1)
                .putPlayer(0, 0)
                .putBox(1, 0);
        cut = new BoardPrinter();

        // when
        String boardResult = cut.getBoardString(board);

        // then
        assertThat(boardResult).isEqualTo(BOARD_WITH_PLAYER_0_0_BOX_1_0);
    }

    @Test
    public void shouldPrintBoardWithStorageOnly() throws Exception {
        // given
        Board board = new Board(1, 1)
                .putStorage(0, 0);
        cut = new BoardPrinter();

        // when
        String boardResult = cut.getBoardString(board);

        // then
        assertThat(boardResult).isEqualTo(BOARD_WITH_STORAGE_ONLY);
    }
}