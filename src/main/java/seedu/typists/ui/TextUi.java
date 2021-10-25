package seedu.typists.ui;

import java.io.IOException;
import seedu.typists.common.Error;
import seedu.typists.content.Animation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;
import static seedu.typists.common.Messages.CLOCK;
import static seedu.typists.common.Messages.KEYBOARD;
import static seedu.typists.common.Messages.LETTER;
import static seedu.typists.common.Messages.LOGO;
import static seedu.typists.common.Messages.MESSAGE_ACKNOWLEDGE;
import static seedu.typists.common.Messages.MESSAGE_HELP;
import static seedu.typists.common.Messages.MESSAGE_WELCOME;
import static seedu.typists.common.Messages.SUMMARY;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;
import java.util.logging.ConsoleHandler;

/**
 * Text UI of the application.
 */
public class TextUi {
    private final SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String DIVIDER = "===========================================================";
    private static final String LINE_PREFIX = "     | ";
    private static final String LS = lineSeparator();
    private static final Logger LOGGER = Logger.getLogger(TextUi.class.getName());

    //get current timestamp
    //unused because it interferes with the EXPECTED.TXT in runtest
    public String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timeFormatter.format(timestamp);
    }

    //solution below adapted from https://github.com/se-edu/addressbook-level2/
    public void showWelcomeMessage(String version) {
        getTimeStamp();
        printScreen(
                version,
                //getTimeStamp(),
                DIVIDER,
                LOGO,
                MESSAGE_WELCOME,
                MESSAGE_ACKNOWLEDGE,
                MESSAGE_HELP,
                DIVIDER
        );
    }

    public void printScreen(String... message) {
        for (String m : message) {
            out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }

    public void printLine(String... message) {
        out.print(LINE_PREFIX);
        for (String m : message) {
            out.print(m + " ");
        }
        out.print("\n");
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void showLine() {
        System.out.println(DIVIDER);
    }

    /**
     * Print error message.
     *
     * @param meg obtained from DukeException message
     */
    public void showText(String meg) {
        System.out.println(meg);
    }

    public void showNumber(int i) {
        System.out.println(String.valueOf(i));
    }

    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void printGameMode1Progress(int a, int b) throws InterruptedException {
        viewAnimateLeft("Your progress:" + String.valueOf(a) + "/" + String.valueOf(b));
    }

    public void printKeyboard() {
        out.println(KEYBOARD);
    }

    public void printLetter() {
        out.println(LETTER);
    }

    public void printClock() {
        out.println(CLOCK);
    }

    public void printBookSelection() {
        printScreen("Input '0' to go back.\n"
                + "Content list:\n"
                + "1. A Confederacy of Dunces\n"
                + "2. Moby Dick\n"
                + "3. A Farewell to Arms\n"
                + "4. A Tale of Two Cities\n"
                + "5. On the Road\n"
                + "6. Bright on Rock\n"
                + "7. Pick Up\n"
                + "8. Pride and Prejudice\n"
                + "9. White Fang\n"
                + "10. American Psycho\n"
                + "11. Notes from Underground\n"
                + "12. The Haunting of Hill House\n"
                + "13. Metamorphosis\n"
                + "14. Invisible Man\n"
                + "15. The Adventures of Huckleberry Finn");
    }

    public void viewAnimateLeft(String string) throws InterruptedException {
        Animation animation = new Animation();
        animation.resetAnimLeft();
        int k = 0;
        while (k < 6) {
            animation.animateLeft(string);
            Thread.sleep(300);
            k++;
        }
        System.out.println("");
    }

    public void viewAnimateRight(String string) throws InterruptedException {
        Animation animation = new Animation();
        animation.resetAnimRight();
        int k = 0;
        while (k < 6) {
            animation.animateRight(string);
            Thread.sleep(300);
            k++;
        }
        System.out.println("");
    }

    public void showAnimatedWordLimitSummary(int errorWordCount, int totalWordTyped) throws InterruptedException {
        viewAnimateRight("Wrong Words: " + errorWordCount + "/" + totalWordTyped);
    }

    public void showAnimatedSentenceErrorRateSummary(double sentenceErrorRate) throws InterruptedException {
        viewAnimateRight("Sentence Error Rate: " + sentenceErrorRate);
    }

    public void showAnimatedError(ArrayList<String> content,
                                  ArrayList<String> typed,
                                  int totalWord)
            throws InterruptedException {
        TextUi ui = new TextUi();
        out.println(SUMMARY);
        Error error = new Error();

        ui.showAnimatedWordLimitSummary(
                error.wrongWordCount(content, typed),
                totalWord
        );

        double sentenceErrorRate = error.sentenceErrorRate(content, typed);
        BigDecimal bd = new BigDecimal(sentenceErrorRate);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();
        ui.showAnimatedSentenceErrorRateSummary(rounded);
    }


    public void showSummary(int errorWordCount, double errorPercentage, List<String> errorWords, double wpm,
                            int totalWordTyped, double gameTime) {
        assert errorWordCount >= 0;
        assert errorPercentage >= 0;
        assert totalWordTyped >= 0;
        assert gameTime > 0;
        assert wpm >= 0;

        out.print(SUMMARY + '\n');
        out.print("Number of Wrong Words: " + errorWordCount + "/" + totalWordTyped + '\n');
        out.print("Error Percentage of Wrong Words: " + String.format("%.2f", errorPercentage) + "%\n");
        out.print("Wrong Words:\n");
        printErrorWords(errorWords);
        out.print("WPM: " + String.format("%.2f", wpm) + '\n');
        out.print("Total Time taken for the game: " + String.format("%.2f", gameTime) + " seconds\n");
    }

    public void showAnimatedSummary(int errorWordCount, double errorPercentage, double wpm,
                            int totalWordTyped, double gameTime) throws InterruptedException {
        out.print(SUMMARY + '\n');
        viewAnimateRight("Wrong Words: " + errorWordCount + "/" + totalWordTyped);
        viewAnimateRight("Error Percentage: " + String.format("%.2f", errorPercentage));
        viewAnimateRight("WPM: " + String.format("%.2f", wpm));
        viewAnimateRight("Total Time taken for the game: " + String.format("%.2f", gameTime) + " seconds");
    }

    void printErrorWords(List<String> errorWords) {
        setUpLog();
        if (errorWords == null) {
            out.print("No words typed wrongly.\n");
            return;
        }
        for (int i = 0; i < errorWords.size(); i++) {
            assert errorWords != null;
            if (i != 0 && i % 8 == 0) {
                out.print("\n");
            }
            out.print(errorWords.get(i));
            if (i != (errorWords.size() - 1)) {
                out.print("|");
            }
        }
        if ((errorWords.size() - 1) % 8 != 0) {
            out.print("\n");
        }
    }

    void setUpLog() {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        LOGGER.addHandler(ch);

        try {
            FileHandler fh = new FileHandler(TextUi.class.getName() + ".log");
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.FINE);
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "File logger failed to set up\n", e);
        }

        LOGGER.info("Set up log in TextUi");
    }
}
