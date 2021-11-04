package seedu.typists.command;

import seedu.typists.ui.TextUi;

import java.util.ArrayList;

public class CommandFactory {
    private static final String TIME_SIGNIFIER = "-time";
    private static final String WORD_SIGNIFIER = "-word";
    TextUi ui = new TextUi();

    public Command getCommand(ArrayList<String> args) {
        String commandType = args.get(0);
        switch (commandType) {
        case "game":
            return parseGameCommand(args);
        case "content":
            return new ContentCommand();
        case "history":
            return new HistoryCommand();
        case "clear":
            return new ClearCommand();
        case "bye":
            return new ExitCommand();
        default:
            ui.printScreen("invalid command");
            return null;
        }
    }

    public GameCommand parseGameCommand(ArrayList<String> args) {
        if (args.contains(TIME_SIGNIFIER)) {
            return new TimeGameCommand();
        } else if (args.contains(WORD_SIGNIFIER)) {
            return new WordGameCommand();
        }
        ui.printScreen("Please specify game type: -time or -word");
        return null;
    }
}
