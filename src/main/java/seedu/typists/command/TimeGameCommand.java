package seedu.typists.command;

import seedu.typists.exception.IncompleteCommandException;
import seedu.typists.exception.InvalidCommandException;
import seedu.typists.game.Game;
import seedu.typists.game.TimeModeGame;

import java.util.ArrayList;

import static seedu.typists.Main.LINE_LENGTH;
import static seedu.typists.Main.content;
import static seedu.typists.common.Utils.isValidTime;

public class TimeGameCommand extends GameCommand {
    private static final String TIME_SIGNIFIER = "-time";

    @Override
    public Game createGame(ArrayList<String> args, boolean isReady, boolean setContent) {

        try {
            int timeInSeconds = getNumber(args, TIME_SIGNIFIER);
            if (setContent) {
                content.setContent();
            }
            return new TimeModeGame(content.getContent(), LINE_LENGTH, timeInSeconds, isReady);
        } catch (NumberFormatException | IncompleteCommandException | InvalidCommandException e) {
            return new TimeModeGame(content.getContent(), LINE_LENGTH, isReady);
        }
    }

    @Override
    public int getNumber(ArrayList<String> args, String gameType)
            throws InvalidCommandException, IncompleteCommandException {
        int n = super.getNumber(args, gameType);
        return isValidTime(n);
    }
}
