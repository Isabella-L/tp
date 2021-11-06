package seedu.typists.game;

import seedu.typists.common.exception.ExceedRangeException;
import seedu.typists.common.exception.InvalidCommandException;
import seedu.typists.common.exception.InvalidStringInputException;
import seedu.typists.ui.TextUi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


import static seedu.typists.common.Utils.getDisplayLinesWithoutNull;
import static seedu.typists.common.Utils.getWordLineFromStringArray;
import static seedu.typists.common.StringParser.splitString;

public class WordLimitGame extends Game {
    private ArrayList<String> eachWord;
    protected ArrayList<String[]> wordLines;
    private final String content1;
    private long beginTime;
    private String[] displayed;

    public WordLimitGame(String targetWordSet, int wordsPerLine, boolean isReady) {
        super(wordsPerLine, isReady);
        this.eachWord = new ArrayList<>(100);
        this.content1 = targetWordSet;
        this.limit = getWordLimit();
    }

    public WordLimitGame(String targetWordSet, int wordsPerLine, int wordLimit, boolean isReady) {
        super(wordsPerLine, wordLimit, isReady);
        this.eachWord = new ArrayList<>(100);
        this.content1 = targetWordSet;
    }

    @Override
    public void displayLines(int row) {
        displayed = new String[0];
        try {
            displayed = getDisplayLinesWithoutNull(eachWord,wordsPerLine,row);
        } catch (ExceedRangeException e) {
            e.printStackTrace();
        }
        ui.printLine(displayed);
    }

    public int getTotalSentence() {
        return eachWord.size();
    }

    public int getWordLimit() {
        ui.printScreen("Enter how many words you want the game to run: ");
        try {
            int n = Integer.parseInt(ui.readCommand());
            return isValidWord(n);
        } catch (NumberFormatException e) {
            new TextUi().printScreen("Length should be a number!");
            //repeat getWordLimit
        } catch (InvalidCommandException e) {
            new TextUi().printScreen(e.getMessage());
            //repeat getWordLimit
        }
        return getWordLimit();
    }

    public static int isValidWord(int n) throws InvalidCommandException {
        if (n <= 0) {
            throw new InvalidCommandException("Length should be positive!");
        }
        return n;
    }


    public void trimContent(int wordLimit) {
        try {
            eachWord = splitString(content1, " ");
        } catch (InvalidStringInputException e) {
            e.printStackTrace();
        }
        eachWord = new ArrayList<>(eachWord.subList(0, wordLimit));
    }

    public void runGame() {
        assert limit > 0 : "limit should be greater than 0";
        trimContent(limit);
        beginTime = getTimeNow();
        List<String> inputs = new ArrayList<>();
        int row = 0;// for method: getDisplayLines()
        boolean isExit = false;
        while (!isExit) {
            row++;
            assert row > 0 : "row is always a positive integer.";
            //display a single line
            displayLines(row);
            //read user input
            String fullCommand = ui.readCommand();
            if (fullCommand.equals("Exit")) {
                break;
            }
            //only add the line into displayedLines when the Command is not Exit
            displayedLines.add(displayed);

            //update for summary
            inputs.add(fullCommand);
            updateUserLines(inputs);

            if ((wordsPerLine * (row)) > eachWord.size()) {
                isExit = true;
            }
        }
    }

    public void gameSummary() {
        gameTime = getDuration(beginTime, getTimeNow());
        HashMap<String, Object> summary = handleSummary(displayedLines, userLines, gameTime, "Word-limited");
        handleStorage(summary);
    }

    public void updateUserLines(List<String> stringArray) {
        userLines = getWordLineFromStringArray(stringArray);
    }
}
