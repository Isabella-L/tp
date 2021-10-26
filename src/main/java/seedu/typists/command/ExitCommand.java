package seedu.typists.command;

import java.util.ArrayList;

import static seedu.typists.Main.uiBot;

public class ExitCommand implements Command {
    @Override
    public void run(ArrayList<String> args) {
        uiBot.showBye();
    }
}
