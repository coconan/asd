package practice;

public class Game {

    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private int ball;

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
            if (strike()) {
                ball++;
                score += 10 + nextTwoBalls();
            } else {
                score += handleSecondThrow();
            }
        }
        return score;
    }

    private boolean strike() {
        return itsThrows[ball] == 10;
    }

    private int nextTwoBalls() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    private int handleSecondThrow() {
        // spare needs next frames first throw
        if (spare()) {
            ball += 2;
            return 10 + nextBall();
        } else {
            int score = twoBallsInFrame();
            ball += 2;
            return score;
        }
    }

    private int twoBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    private boolean spare() {
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10;
    }

    private int nextBall() {
        return itsThrows[ball];
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
