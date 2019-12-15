package test.practice;

import org.junit.Before;
import org.junit.Test;
import practice.Game;

import static org.junit.Assert.assertEquals;

public class TestGame {
    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }

    @Test
    public void testScoreNoThrows() {
        assertEquals(0, g.getScore());
    }

    @Test
    public void testAddOneThrow() {
        g.add(5);
        assertEquals(5, g.getScore());
        assertEquals(1, g.getCurrentFrame());
    }

    @Test
    public void testTwoThrowsNoMark() {
        g.add(5);
        g.add(4);
        assertEquals(9, g.getScore());
        assertEquals(2, g.getCurrentFrame());
    }

    @Test
    public void testFourThrowsNoMark() {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.getScore());
        assertEquals(9, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
        assertEquals(3, g.getCurrentFrame());
    }

    @Test
    public void testSimpleSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.getScoreForFrame(1));
    }

    @Test
    public void testSimpleFrameAfterSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
    }
}
