package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for MapParser.
 */
@ExtendWith(MockitoExtension.class)
public class MapParserTest {

    @Mock
    private BoardFactory boardFactory;

    @Mock
    private LevelFactory levelFactory;

    @Mock
    private Blinky blinky;

    /**
     * Test for the parseMap method (good map).
     */
    @Test
    public void testParseMapGood() {
        assertNotNull(boardFactory);
        assertNotNull(levelFactory);

        Mockito.when(levelFactory.createGhost()).thenReturn(blinky);

        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        List<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P        G#");
        map.add("############");
        mapParser.parseMap(map);

        Mockito.verify(levelFactory, Mockito.times(1)).createGhost();
        Mockito.verify(boardFactory, Mockito.atLeastOnce()).createBoard(Mockito.any());
    }

    /**
     * Test for the parseMap method (bad map).
     * Should throw a RuntimeException for invalid input.
     */
    @Test
    public void testParseMapWrong1() {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            MapParser mapParser = new MapParser(levelFactory, boardFactory);
            List<String> map = new ArrayList<>();
            map.add("#######");
            map.add("#P   X###");
            map.add("#######");
            mapParser.parseMap(map);
        });

        assertTrue(
            thrown.getMessage().contains("Input")
                || thrown.getMessage().contains("Invalid"),
            "Expected RuntimeException mentioning invalid input or unequal width."
        );
    }
}
