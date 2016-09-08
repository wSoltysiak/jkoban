package pl.brasswillow;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.containsString;

public class BoardExceptionsTest {

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenBoxAutOfBoard() throws Exception{
        Board aBoard = new Board(1,1);
        aBoard.putBox(2,1);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenPlayerAutOfBoard() throws Exception{
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(containsString("player"));
        Board aBoard = new Board(1,1);
        aBoard.putPlayer(1,1);
    }

    @Test
    public void shouldThrowExceptionWhenAStorageAutOfBoard() throws Exception{
        Board aBoard = new Board(1,1);
        assertThatThrownBy(() -> aBoard.putStorage(1,1))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("storage");
    }

    @Test
    public void shouldThrowExceptionWhenAStorageAutOfBoardBDD() throws Exception{
        Board aBoard = new Board(1,1);
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> aBoard.putStorage(1, 1))
            .withMessageContaining("storage");
    }

}
