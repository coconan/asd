package test.practice;

import org.junit.Test;
import practice.Game;

import static org.junit.Assert.assertEquals;

public class TestGame {

    @Test
    public void testScoreNoThrows() {
        Game f = new Game();
        assertEquals(0, f.getScore());
    }

    @Test
    public void testAddOneThrow() {
        Game f = new Game();
        f.add(5);
        assertEquals(5, f.getScore());
    }

    @Test
    public void testTwoThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        assertEquals(9, g.getScore());
    }

    @Test
    public void testFourThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.getScore());
        assertEquals(9, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
    }
}
