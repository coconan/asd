package practice;

public class Game {

    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private int ball;
    private int firstThrow;
    private int secondThrow;

    public int getScore() {
        return getScoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame) {
            if (pins == 10) {  // strike
                itsCurrentFrame++;
            } else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int getScoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            firstThrow = itsThrows[ball++];
            if (firstThrow == 10) {
                score += 10 + itsThrows[ball] + itsThrows[ball + 1];
            } else {
                score += handleSecondThrow();
            }
        }
        return score;
    }

    private int handleSecondThrow() {
        secondThrow = itsThrows[ball++];

        int frameScore = firstThrow + secondThrow;
        // spare needs next frames first throw
        if (frameScore == 10) {
            return frameScore + itsThrows[ball];
        } else {
            return frameScore;
        }
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
