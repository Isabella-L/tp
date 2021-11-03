package seedu.typists.game;

import seedu.typists.exception.ExceedRangeException;
import seedu.typists.exception.InvalidStringInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static seedu.typists.common.Utils.getDisplayLinesWithoutNull;
import static seedu.typists.common.Utils.getWordLineFromStringArray;
import static seedu.typists.parser.StringParser.splitString;

public class WordLimitGame extends Game {
    private ArrayList<String> eachWord;
    protected ArrayList<String[]> wordLines;
    protected int wordLimit;
    private final int wordsPerLine;
    private final String content1;
    private long beginTime;
    private String[] displayed;


    public WordLimitGame(String targetWordSet, int wordsPerLine) {
        super();
        this.eachWord = new ArrayList<>(100);
        this.wordsPerLine = wordsPerLine;
        this.content1 = targetWordSet;
        this.wordLimit = getWordLimit();
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
        Scanner in = new Scanner(System.in);
        ui.printScreen("Enter how many words you want the game to run: ");

        try {
            return Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a Number!");
            return getWordLimit();
        }
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
        trimContent(wordLimit);
        beginTime = getTimeNow();
        List<String> inputs = new ArrayList<>();
        int row = 0;// for method: getDisplayLines()
        boolean isExit = false;
        while (!isExit) {
            row++;
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
