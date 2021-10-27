package seedu.typists.game;

import seedu.typists.storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;

public class GameRecordsManager {

    private static GameRecordsManager instance = null;
    private ArrayList<GameRecord> timeLimitedGameRecords;
    private ArrayList<GameRecord> wordLimitedGameRecords;

    private GameRecordsManager() {
        // get gameRecords using some file reader.
        timeLimitedGameRecords = Storage.readGameRecords("Time-limited");
        wordLimitedGameRecords = Storage.readGameRecords("Word-limited");
    }

    public void updateGameRecords() {
        Storage.writeGameRecords(timeLimitedGameRecords, "Time-limited");
        Storage.writeGameRecords(wordLimitedGameRecords, "Word-limited");
    }

    public static GameRecordsManager getGameRecordsManager() {
        if (instance == null) {
            instance = new GameRecordsManager();
        }
        return instance;
    }

    public void addGameRecord(HashMap<String, Object> gameSummary) {
        GameRecord newGameRecord = createGameRecord(gameSummary);
        addRecordToArray(newGameRecord);
        writeRecordToFile(newGameRecord);
    }

    private GameRecord createGameRecord(HashMap<String, Object> gameSummary) {
        String gameMode = (String) gameSummary.get("gameMode");
        double timeElapsed = (Double) gameSummary.get("timeElapsed");
        double wpm = (Double) gameSummary.get("wordsPerMinute");
        int errorWordCount = (Integer) gameSummary.get("errorWordCount");
        int correctWordCount = (Integer) gameSummary.get("correctWordCount");
        int totalWordCount = (Integer) gameSummary.get("totalWordCount");
        double errorWordPercentage = (Double) gameSummary.get("errorWordPercentage");
        double correctWordPercentage = (Double) gameSummary.get("correctWordPercentage");
        ArrayList<String> errorWords = (ArrayList<String>) gameSummary.get("errorWords");

        GameRecord newGameRecord = new GameRecord(
                gameMode, timeElapsed, errorWordCount, correctWordCount, totalWordCount,
                errorWordPercentage, correctWordPercentage, wpm, errorWords
        );
        return newGameRecord;
    }

    private void addRecordToArray(GameRecord gameRecord) {
        String gameMode = gameRecord.getGameMode();
        if (gameMode == "Word Limited") {
            wordLimitedGameRecords.add(gameRecord);
        } else {
            timeLimitedGameRecords.add(gameRecord);
        }
    }

    private void writeRecordToFile(GameRecord gameRecord) {
        String gameMode = gameRecord.getGameMode();
        if (gameMode == "Word Limited") {
            Storage.writeGameRecords(wordLimitedGameRecords, "Word-limited");
        } else {
            Storage.writeGameRecords(timeLimitedGameRecords, "Time-limited");

        }

    }

}
