
package seedu.typists.command.commands;


import seedu.typists.command.commands.Command;

import java.util.ArrayList;

import static seedu.typists.Main.content;

public class ContentCommand implements Command {

    @Override
    public void run(ArrayList<String> args) {
        content.setContent();
    }

}
