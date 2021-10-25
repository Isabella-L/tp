package seedu.typists.parser;

import seedu.typists.game.ErrorGame;

import static seedu.typists.Main.LINE_LENGTH;
import static seedu.typists.Main.content;

public class ErrorCommand implements Command {
    @Override
    public void run() {
        startErrorGame();
    }

    public void startErrorGame() {
        new ErrorGame(content.getContent(), LINE_LENGTH);
    }
}
