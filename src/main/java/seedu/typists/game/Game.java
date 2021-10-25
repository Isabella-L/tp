package seedu.typists.game;

import seedu.typists.ui.TextUi;

public abstract class Game {
    protected final TextUi ui;

    public Game() {
        this.ui = new TextUi();
    }

    public long getTimeNow() {
        return System.currentTimeMillis();
    }

    public double duration(long startTime, long endTime) {
        return (double) (endTime - startTime) / 1000;
    }

    public abstract void runGame();
}
