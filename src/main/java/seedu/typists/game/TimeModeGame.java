package seedu.typists.game;

import seedu.typists.exception.ExceedRangeException;
import seedu.typists.exception.InvalidCommandException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static seedu.typists.common.Messages.MESSAGE_TIME_GAME_END;
import static seedu.typists.common.Utils.getDisplayLines;
import static seedu.typists.common.Utils.splitStringIntoWordList;
import static seedu.typists.common.Utils.getWordLineFromStringArray;
import static seedu.typists.common.Utils.isValidTime;


public class TimeModeGame extends Game {
    protected final ArrayList<String> wordLists;
    protected double gameTime;
    protected int currentRow;

    public TimeModeGame(String targetWordSet, int wordsPerLine, boolean isReady) {
        super(wordsPerLine, isReady);
        assert targetWordSet != null;
        this.wordLists = splitStringIntoWordList(targetWordSet);
        this.currentRow = 1;
        this.limit = getTimeLimit();
    }

    public TimeModeGame(String targetWordSet, int wordsPerLine, int timeInSeconds, boolean isReady) {
        super(wordsPerLine, timeInSeconds, isReady);
        assert targetWordSet != null;
        this.wordLists = splitStringIntoWordList(targetWordSet);
        this.currentRow = 1;
    }

    public int getTimeLimit() {
        Scanner in = new Scanner(System.in);
        ui.printScreen("Enter how long you want the game to run: ");
        try {
            int n = Integer.parseInt(in.nextLine());
            return isValidTime(n);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");
        } catch (InvalidCommandException e) {
            //repeat getTimeLimit
        }
        return getTimeLimit();
    }

    @Override
    public void displayLines(int row) {
        try {
            String[] display = getDisplayLines(wordLists, wordsPerLine, currentRow);
            ui.printLine(display);
            displayedLines.add(display);
        } catch (ExceedRangeException e) {
            currentRow = 1;
            displayLines(currentRow);
        }
    }

    public void runGame() {
        Scanner in = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        //game begins
        long beginTime = getTimeNow();
        boolean timeOver = false;

        while (!timeOver) {
            long currTime = getTimeNow() - beginTime;
            if (currTime >= limit * 1000L) {
                gameTime = (double) currTime / 1000;
                timeOver = true;
            } else {
                displayLines(currentRow);
                inputs.add(in.nextLine());
                currentRow++;
            }
        }

        updateUserLines(inputs);
        endGame();
    }

    public void endGame() {
        ui.printEnd(MESSAGE_TIME_GAME_END);
        double overshoot = gameTime - limit;
        assert overshoot >= 0;
        if (overshoot > 0) {
            ui.printOvershoot(overshoot);
        }
    }

    public void gameSummary() {
        HashMap<String, Object> summary = handleSummary(displayedLines, userLines, gameTime, "Time-limited");
        handleStorage(summary);
    }

    public void updateUserLines(List<String> stringArray) {
        userLines = getWordLineFromStringArray(stringArray);
    }
}

