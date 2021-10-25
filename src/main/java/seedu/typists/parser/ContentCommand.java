package seedu.typists.parser;

import static seedu.typists.Main.content;

public class ContentCommand implements Command {

    @Override
    public void run() {
        content.setContent();
    }

}
