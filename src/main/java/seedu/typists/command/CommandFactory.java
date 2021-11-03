package seedu.typists.command;

import seedu.typists.ui.TextUi;

public class CommandFactory {
    TextUi ui = new TextUi();

    public Command getCommand(String commandType) {
        switch (commandType) {
        case "game":
            return new GameCommand();
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
}
