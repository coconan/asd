package test.practice;

import org.junit.Test;
import practice.Frame;

import static org.junit.Assert.assertEquals;

public class TestFrame {

    @Test
    public void testScoreNoThrows() {
        Frame f = new Frame();
        assertEquals(0, f.getScore());
    }

    @Test
    public void testAddOneThrow()
    {
        Frame f = new Frame();
        f.add(5);
        assertEquals(5, f.getScore());
    }
}
