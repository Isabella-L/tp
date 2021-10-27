package seedu.typists.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameRecord {

    private String gameMode;
    private double timeElapsed;
    private int errorWordCount;
    private int correctWordCount;
    private int totalWordCount;
    private double errorWordPercentage;
    private double correctWordPercentage;
    private double wpm;
    private ArrayList<String> errorWords;

    public GameRecord(
            String gameMode, double timeElapsed, int errorWordCount, int correctWordCount, int totalWordCount,
            double errorWordPercentage, double correctWordPercentage, double wpm, ArrayList<String> errorWords
    ) {

        this.gameMode = gameMode;
        this.timeElapsed = timeElapsed;
        this.errorWordCount = errorWordCount;
        this.correctWordCount = correctWordCount;
        this.totalWordCount = totalWordCount;
        this.errorWordPercentage = errorWordPercentage;
        this.correctWordPercentage = correctWordPercentage;
        this.wpm = wpm;
        this.errorWords = errorWords;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getStringFormat() {
        String separator = "|";
        String formatted = gameMode
                + separator
                + timeElapsed
                + separator
                + errorWordCount
                + separator
                + correctWordCount
                + separator
                + totalWordCount
                + separator
                + errorWords.toString();
        return formatted;
    }
}
