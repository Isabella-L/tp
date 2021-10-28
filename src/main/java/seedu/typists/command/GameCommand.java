package seedu.typists.command;

import seedu.typists.exception.IncompleteCommandException;
import seedu.typists.exception.InvalidCommandException;
import seedu.typists.game.Game;
import seedu.typists.game.TimeModeGame;
import seedu.typists.game.WordLimitGame;

import java.util.ArrayList;

import static seedu.typists.Main.content;
import static seedu.typists.Main.uiBot;
import static seedu.typists.Main.LINE_LENGTH;

public class GameCommand implements Command {
    private static final String TIME_SIGNIFIER = "-t";
    private static final String WORD_SIGNIFIER = "-w";
    private static final String START_SIGNIFIER = "-sn";
    private static final String CONTENT_SIGNIFIER = "-c";

    @Override
    public void run(ArrayList<String> args) {
        boolean startNow = getBoolean(args, START_SIGNIFIER);
        boolean setContent = getBoolean(args, CONTENT_SIGNIFIER);

        try {
            Game game = createGame(args, startNow, setContent);
            game.runGame();
            game.gameSummary();
        } catch (IncompleteCommandException e) {
            System.out.println("Please specify game type.");
        } catch (NullPointerException e) {
            //exit
        }
    }

    public Game createGame(ArrayList<String> args, boolean startNow, boolean setContent)
            throws IncompleteCommandException {
        if (getBoolean(args, TIME_SIGNIFIER)) {
            return createTimeLimitGame(args,startNow, setContent);
        } else if (getBoolean(args, WORD_SIGNIFIER)) {
            return createWordLimitGame(setContent);
        } else {
            throw new IncompleteCommandException();
        }
    }

    public WordLimitGame createWordLimitGame(boolean setContent) {
        uiBot.printKeyboard();
        if (setContent) {
            content.setContent();
        }
        return new WordLimitGame(content.getContent(), 5);
    }

    public TimeModeGame createTimeLimitGame(ArrayList<String> args, boolean isReady, boolean setContent) {
        try {
            int timeInSeconds = getTime(args, TIME_SIGNIFIER);
            if (setContent) {
                content.setContent();
            }
            return new TimeModeGame(timeInSeconds,content.getContent(), LINE_LENGTH, isReady);
        } catch (InvalidCommandException e) {
            System.out.println(
                    "Please enter time in multiple of 30 seconds.\n"
                            + "e.g. time -t 30 "
            );
        } catch (IncompleteCommandException | IndexOutOfBoundsException e) {
            System.out.println(
                    "Please specify duration of the game using "
                            + TIME_SIGNIFIER + "\n"
                            + "e.g. time -t 60 "
            );
        } catch (NumberFormatException e) {
            System.out.println("Duration should be a number");
        }
        return null;
    }

    /** Determine whether the user command has the signifier. **/
    public boolean getBoolean(ArrayList<String> args, String key) {
        return args.contains(key);
    }

    public int getTime(ArrayList<String> args, String key)
            throws InvalidCommandException, IncompleteCommandException {
        if (!args.contains(key)) {
            throw new IncompleteCommandException();
        }
        int index = args.indexOf("-t");
        int time = Integer.parseInt(args.get(index + 1));
        if (time % 30 != 0 || time == 0) {
            throw new InvalidCommandException();
        }
        return time;
    }
}
