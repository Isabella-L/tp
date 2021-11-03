package seedu.typists.storage;

import seedu.typists.game.GameRecord;

import java.util.ArrayList;
import java.util.Arrays;

public class FileParser {

    public static GameRecord convertStringToGameRecord(String gameRecordString) {
        try {
            String[] gameRecordStats = gameRecordString.split("\\|");
            assert gameRecordStats.length >= 8;
            String gameMode = getGameMode(gameRecordStats);
            double timeElapsed = getTimeElapsed(gameRecordStats);
            int errorWordCount = getErrorWordCount(gameRecordStats);
            int correctWordCount = getCorrectWordCount(gameRecordStats);
            int totalWordCount = getTotalWordCount(gameRecordStats);
            double errorWordPercentage = getErrorWordPercentage(gameRecordStats);
            double correctWordPercentage = getCorrectWordPercentage(gameRecordStats);
            double wpm = getWpm(gameRecordStats);
            ArrayList<String> errorWords = getErrorWords(gameRecordStats);

            GameRecord gameRecord = new GameRecord(
                    gameMode,
                    timeElapsed,
                    errorWordCount,
                    correctWordCount,
                    totalWordCount,
                    errorWordPercentage,
                    correctWordPercentage,
                    wpm,
                    errorWords
            );
            return gameRecord;
        } catch (Exception e) {
            System.out.println("OOPS! Looks like you messed around with a record file.\n"
                    + "A brand new record file will be created!\n");
            return null;
        }
    }

    private static String getGameMode(String[] gameRecordStats) throws Exception {
        try {
            return gameRecordStats[0];
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static double getTimeElapsed(String[] gameRecordStats) throws Exception {
        try {
            return Double.parseDouble(gameRecordStats[1]);
        } catch (Exception e) {
            throw new Exception();
        }

    }

    private static int getErrorWordCount(String[] errorWordCountString) throws Exception {
        try {
            return Integer.parseInt(errorWordCountString[2]);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static int getCorrectWordCount(String[] gameRecordStats) throws Exception {
        try {
            return Integer.parseInt(gameRecordStats[3]);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static int getTotalWordCount(String[] gameRecordStats) throws Exception {
        try {
            return Integer.parseInt(gameRecordStats[4]);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static double getErrorWordPercentage(String[] gameRecordStats) throws Exception {
        try {
            return Double.parseDouble(gameRecordStats[5]);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static double getCorrectWordPercentage(String[] gameRecordStats) throws Exception {
        try {
            return Double.parseDouble(gameRecordStats[6]);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static double getWpm(String[] wpmString) throws Exception {
        try {
            return Double.parseDouble(wpmString[7]);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private static ArrayList<String> getErrorWords(String[] gameRecordStats) throws Exception {
        try {
            if (gameRecordStats[8].trim().equals("[]")) {
                return new ArrayList<>();
            }
            String[] errorWords = gameRecordStats[8].substring(1, gameRecordStats[8].length() - 1).split(",");
            return new ArrayList<>(Arrays.asList(errorWords));
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
