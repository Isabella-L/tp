package seedu.typists.parser;


import seedu.typists.exception.FaultyInputException;

/**
 * Parses user input.
 */
public class Parser {
    protected String input;
    protected String command;
    protected String description;
    protected Boolean isExit;

    /**
     * Parser with input and a boolean.
     * command by default = "default"
     * @param input takes user input
     */
    public Parser(String input) {
        this.input = input;
        this.isExit = false;
        this.command = "default";
    }

    /**
     *Get exit.
     * @return obtain the Exit status
     */
    public Boolean getIsExit() {
        return isExit;
    }

    public void parse() throws FaultyInputException {
        switch (input) {
        case "bye":
            isExit = true;
            command = "bye";
            break;
        case "new":
            command = "new";
            break;
        case "time":
            command = "time";
            break;
        case "content":
            command = "content";
            break;
        default:
            System.out.println("invalid command.");
            break;
        }
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() throws FaultyInputException {
        if (description.isEmpty()) {
            throw new FaultyInputException("OOPS!!! The description cannot be empty.");
        }
        return description;
    }
}
