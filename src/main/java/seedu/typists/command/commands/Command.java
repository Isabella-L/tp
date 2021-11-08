package seedu.typists.command.commands;

import java.util.ArrayList;

public interface Command {
    void run(ArrayList<String> args);
}
