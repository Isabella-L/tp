package seedu.typists;

import seedu.typists.content.Content;
import seedu.typists.game.ErrorGame;
import seedu.typists.game.DataProcessor;
import seedu.typists.game.TimeModeGame;
import seedu.typists.parser.Parser;
import seedu.typists.ui.TextUi;

import seedu.typists.game.WordLimitGame;
import seedu.typists.exception.FaultyInputException;
import seedu.typists.exception.InvalidStringInputException;
import seedu.typists.storage.StorageFile;

import java.util.NoSuchElementException;


//solution below adapted from https://github.com/se-edu/addressbook-level2/
public class Main {
    /**
     * Version info of the program.
     */
    public static final String VERSION = "Typist - Version 1.0";
    public static final int LINE_LENGTH = 10;
    TextUi uiBot;
    //Parser parseBot;
    WordLimitGame wordLimitGame;
    StorageFile storage;
    Content content;

    public Main() {
        this.uiBot = new TextUi();
        this.storage = new StorageFile();
        this.content = new Content();
    }

    public void start() {
        uiBot.showWelcomeMessage(VERSION);
    }

    public void startWordLimitGame() throws InvalidStringInputException {
        uiBot.printKeyboard();
        this.wordLimitGame = new WordLimitGame(content.getContent(), 5);
        wordLimitGame.beginNewGame();
    }

    public void startErrorGame() {
        ErrorGame a = new ErrorGame(content.getContent(), LINE_LENGTH);
    }

    public void executeCommand(Parser c, StorageFile storage) throws InvalidStringInputException {
        switch (c.getCommand()) {
        case "content":
            content.setContent();
            break;
        case "new":
            startWordLimitGame();
            break;
        case "time":
            startTimeLimitGame();
            break;
        case "error":
            startErrorGame();
            break;
        default:
            break;
        }
        //storage.writeToFile(tasks);
    }

    public void runCommandLoopUntilExitCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = uiBot.readCommand();
                Parser c = new Parser(fullCommand);
                c.parse();
                executeCommand(c, storage);
                isExit = c.getIsExit();
            } catch (StringIndexOutOfBoundsException e) {
                uiBot.showText("OOPS!!! The description after this command word cannot be empty.");
            } catch (IndexOutOfBoundsException e) {
                uiBot.showText("OOPS!!! It's out of range.");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                uiBot.showText("OOPS!!! Number not found. ");
            } catch (NoSuchElementException | InvalidStringInputException e) {
                e.printStackTrace();
            } finally {
                uiBot.showLine();
            }
        }
    }

    public void exit() {
        uiBot.showBye();
    }

    /**
     * Runs the program until termination.
     */
    public void run() {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Main().run();
    }
}
