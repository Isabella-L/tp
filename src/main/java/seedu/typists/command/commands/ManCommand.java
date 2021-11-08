package seedu.typists.command.commands;

import java.util.ArrayList;

import static seedu.typists.Main.uiBot;
import static seedu.typists.common.Messages.MESSAGE_HELP;
import static seedu.typists.common.Messages.MESSAGE_HELP_CLEAR;
import static seedu.typists.common.Messages.MESSAGE_HELP_CONTENT;
import static seedu.typists.common.Messages.MESSAGE_HELP_GAME;
import static seedu.typists.common.Messages.MESSAGE_HELP_HISTORY;

public class ManCommand implements Command {

    @Override
    public void run(ArrayList<String> args) {
        if (args.size() == 1) {
            assert args.get(0).equals("man");
            uiBot.printScreen(MESSAGE_HELP);
            return;
        }

        String manType = args.get(1);
        switch (manType) {
        case "game":
            uiBot.printScreen(MESSAGE_HELP_GAME);
            break;
        case "history":
            uiBot.printScreen(MESSAGE_HELP_HISTORY);
            break;
        case "content":
            uiBot.printScreen(MESSAGE_HELP_CONTENT);
            break;
        case "clear":
            uiBot.printScreen(MESSAGE_HELP_CLEAR);
            break;
        default:
            uiBot.printScreen("no such command");
            break;
        }
    }
}
