package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
/**
 * Test class to verify that a valid Board can be created.
 */
public class BoardTest {

    /**
     * Tests that a 1x1 board with a BasicSquare is valid
     * and allows retrieving the square.
     */
    @Test
    void testValidBoard() {
        Square[][] grid = {
            { new BasicSquare() }
        };

        Board board = new Board(grid);

        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isInstanceOf(BasicSquare.class);
    }

    /**
     * Tests that a board with a null square fails when accessing that square.
     */
    // @Test
    // void testBoardWithNullSquare() {
    //     Square[][] grid = {
    //         { null }
    //     };

    //     Board board = new Board(grid);

    //     assertThatThrownBy(() -> board.squareAt(0, 0))
    //         .isInstanceOf(AssertionError.class);
    // }

}
