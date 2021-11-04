package seedu.typists.common;

import seedu.typists.exception.ExceedRangeException;
import seedu.typists.exception.FaultyInputException;
import seedu.typists.exception.InvalidCommandException;
import seedu.typists.ui.TextUi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility methods.
 */
public class Utils {

    /** convert the line of text into an arraylist of word. */
    public static ArrayList<String> splitStringIntoWordList(String line) {
        return new ArrayList<>(Arrays.asList(line.split(" ")));
    }

    /** group the word list into groups of x, where x is the number of words per line. */
    public static ArrayList<String[]> getWordLines(String text, int lineLength) {
        ArrayList<String> wordList = splitStringIntoWordList(text);
        ArrayList<String[]> wordLines = new ArrayList<>();
        int j = 0;
        String[] line = new String[lineLength];
        for (String w : wordList) {
            if (j == lineLength - 1) {
                line[j] = w;
                wordLines.add(line.clone());
                j = 0;
            } else {
                line[j] = w;
                j++;
            }
        }
        return wordLines;
    }

    /**
     * get one line that is supposed to be displayed at one time of game.
     *
     * @param wordLists content in the form of arraylist of words
     * @param wordsPerLine number of words to be displayed
     * @param row current row in the content
     **/
    public static String[] getDisplayLines(ArrayList<String> wordLists, int wordsPerLine, int row)
            throws ExceedRangeException {
        int startIndex = (row - 1) * wordsPerLine;
        assert startIndex >= 0 : "word index should be non-negative";
        String[] line = new String[wordsPerLine];

        try {
            for (int i = 0; i < wordsPerLine; i++) {
                line[i] = wordLists.get(startIndex + i);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ExceedRangeException();
        }
        return line;
    }

    /** same as getDisplayLines but added remove null feature. **/
    public static String[] getDisplayLinesWithoutNull(ArrayList<String> wordLists, int wordsPerLine, int row)
            throws ExceedRangeException {
        int startIndex = (row - 1) * wordsPerLine;
        assert startIndex >= 0 : "word index should be non-negative";
        String[] line = new String[wordsPerLine];

        try {
            for (int i = 0; i < wordsPerLine; i++) {
                if (startIndex + i > wordLists.size() - 1) {
                    break;
                }
                line[i] = wordLists.get(startIndex + i);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ExceedRangeException();
        }

        //remove null elements
        line = Arrays.stream(line)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        return line;
    }

    /** same function as getWordLines, but the param is ArrayList not string. */
    public static ArrayList<String[]> getWordLineFromStringArray(List<String> stringList) {
        ArrayList<String[]> wordLines = new ArrayList<>();
        for (String s : stringList) {
            String[] wordLine = s.split(" ");
            wordLines.add(wordLine);
        }
        return wordLines;
    }

    /**
     * Return a valid duration of time mode game.
     * @param n integer that specify the duration
     * @return n only if n is valid
     * @throws InvalidCommandException thrown when the n is not a valid game duration
     */
    public static int isValidTime(int n) throws InvalidCommandException {
        if (n < 0) {
            new TextUi().printScreen("Duration should not be negative");
            throw new InvalidCommandException();
        } else if (n % 30 != 0 || n == 0) {
            new TextUi().printScreen("Duration should be in multiple of 30 seconds.");
            throw new InvalidCommandException();
        }
        return n;
    }
}
