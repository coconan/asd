package practice;

public class Game {

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();

    public int getScore() {
        return getScoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        itsScorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame) {
            if (pins == 10) {  // strike
                advanceFrame();
            } else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            advanceFrame();
        }
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(11, itsCurrentFrame + 1);
    }

    public int getScoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }


    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
