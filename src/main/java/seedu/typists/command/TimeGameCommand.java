package seedu.typists.command;

import seedu.typists.common.exception.IncompleteCommandException;
import seedu.typists.common.exception.InvalidCommandException;
import seedu.typists.game.Game;
import seedu.typists.game.TimeLimitGame;

import java.util.ArrayList;

import static seedu.typists.Main.LINE_LENGTH;
import static seedu.typists.Main.content;
import static seedu.typists.common.Utils.isValidTime;

public class TimeGameCommand extends GameCommand {
    private static final String TIME_SIGNIFIER = "-time";

    @Override
    public Game createGame(ArrayList<String> args, boolean isReady, boolean setContent) {
        if (setContent) {
            content.setContent();
        }
        try {
            int timeInSeconds = getNumber(args, TIME_SIGNIFIER);
            return new TimeLimitGame(content.getContent(), LINE_LENGTH, timeInSeconds, isReady);
        } catch (NumberFormatException | IncompleteCommandException | InvalidCommandException e) {
            return new TimeLimitGame(content.getContent(), LINE_LENGTH, isReady);
        }
    }

    @Override
    public int getNumber(ArrayList<String> args, String gameType)
            throws InvalidCommandException, IncompleteCommandException {
        int n = super.getNumber(args, gameType);
        return isValidTime(n);
    }
}
