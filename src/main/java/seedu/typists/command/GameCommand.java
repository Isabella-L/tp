package seedu.typists.command;

import seedu.typists.common.exception.IncompleteCommandException;
import seedu.typists.common.exception.InvalidCommandException;
import seedu.typists.game.Game;
import seedu.typists.ui.GameUi;

import java.util.ArrayList;

import static seedu.typists.Main.LINE_LENGTH;

public abstract class GameCommand implements Command {
    private static final String START_SIGNIFIER = "-sn";
    private static final String CONTENT_SIGNIFIER = "-c";

    @Override
    public void run(ArrayList<String> args) {
        boolean isReady = getBoolean(args, START_SIGNIFIER);
        boolean setContent = getBoolean(args, CONTENT_SIGNIFIER);

        try {
            Game game = createGame(args, isReady, setContent);
            game.run();
            game.gameSummary();
        } catch (NullPointerException e) {
            //exit
        } catch (StackOverflowError e) {
            new GameUi().printResetContent(LINE_LENGTH);
        }
    }

    public abstract Game createGame(ArrayList<String> args, boolean isReady, boolean setContent);

    /** Determine whether the user command has the signifier. **/
    public boolean getBoolean(ArrayList<String> args, String key) {
        return args.contains(key);
    }

    /** Get the number after the game type indicator. The number will specify
     * for time game: time limit (in seconds)
     * for word game: word limit
     **/
    public int getNumber(ArrayList<String> args, String gameType)
            throws InvalidCommandException, IncompleteCommandException {
        //if number is negative or out of range, throw exception
        int index = args.indexOf(gameType);
        try {
            return Integer.parseInt(args.get(index + 1));
        } catch (IndexOutOfBoundsException e) {
            //no suffix after -<mode>
            throw new IncompleteCommandException();
        }
    }
}
