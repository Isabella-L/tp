package seedu.typists.parser;

import seedu.typists.ui.TextUi;

public class CommandFactory {
    TextUi ui = new TextUi();

    public Command getCommand(String commandType) {
        switch (commandType) {
        case "time":
            return new TimeGameCommand();
        case "word":
            return new WordGameCommand();
        case "content":
            return new ContentCommand();
        case "error":
            return new ErrorCommand();
        case "bye":
            return new ExitCommand();
        default:
            ui.printScreen("invalid command");
            return null;
        }
    }
}
