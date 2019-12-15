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
    public void testAddOneThrow()
    {
        Game f = new Game();
        f.add(5);
        assertEquals(5, f.getScore());
    }
}
