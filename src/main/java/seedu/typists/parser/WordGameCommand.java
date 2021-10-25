package seedu.typists.parser;

import seedu.typists.game.Game;
import seedu.typists.game.WordLimitGame;

import static seedu.typists.Main.content;
import static seedu.typists.Main.uiBot;

public class WordGameCommand implements Command {
    @Override
    public void run() {
        startWordLimitGame();
    }

    public void startWordLimitGame() {
        uiBot.printKeyboard();
        new WordLimitGame(content.getContent(), 5).runGame();
    }
}
