package seedu.typists.game;

import seedu.typists.ui.GameUi;
import seedu.typists.ui.SummaryUi;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Game {
    protected final GameUi ui;
    protected boolean isReady;
    protected int wordsPerLine;
    protected int limit;

    public ArrayList<String[]> displayedLines = new ArrayList<>();
    public ArrayList<String[]> userLines = new ArrayList<>();
    public double gameTime;

    public Game(int wordsPerLine, boolean isReady) {
        this.ui = new GameUi();
        this.isReady = isReady;
        this.wordsPerLine = wordsPerLine;
    }

    public Game(int wordsPerLine, int limit, boolean isReady) {
        this(wordsPerLine, isReady);
        this.limit = limit;
    }

    public void run() {
        if (!isReady) {
            ui.readyToStartTimer();
        }
        runGame();
    }

    public long getTimeNow() {
        return System.currentTimeMillis();
    }

    public double getDuration(long startTime, long endTime) {
        return (double) (endTime - startTime) / 1000;
    }

    public abstract void displayLines(int row);

    public abstract void runGame();

    public abstract void gameSummary();

    public HashMap<String, Object> handleSummary(
            ArrayList<String[]> expectedInput, ArrayList<String[]> actualInput, double timeElapsed, String gameMode
    ) {
        HashMap<String, Object> summary = SummaryManager.generateSummary(
                expectedInput, actualInput, timeElapsed, gameMode
        );
        SummaryUi.displaySummary(summary);
        return summary;
    }

    public void handleStorage(HashMap<String, Object> summary) {
        GameRecordsManager gameRecordsManager = GameRecordsManager.getGameRecordsManager();
        gameRecordsManager.addGameRecord(summary);
    }
}
