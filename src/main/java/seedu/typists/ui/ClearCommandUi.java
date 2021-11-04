package seedu.typists.ui;

import static seedu.typists.common.Messages.CLEAR_RECORDS;

public class ClearCommandUi {

    public static void displayHelp() {
        System.out.print("clear deletes all records for both games,"
                + " or either of the game types, depending on your choice.\n");
        System.out.print("The format of the command is 'clear [-g GAME_MODE]'\n");
        System.out.print("The arguments in the square brackets are optional.\n"
                + "GAME_MODE specifies which game mode's record(s) to clear.\n"
                + "If not inputted, the default is 'all' which means "
                + "records from both the time- and word-limited will be cleared.\n");
        System.out.print("The possible values for GAME_MODE is 'all', 'time', and, 'word'.\n");
        System.out.print("'word' clears all game records for the word-limited mode.\n"
                + "'time' clears all game records for the time-limited mode.\n");
    }

    public static void displaySuccess(String gameMode) {
        System.out.print(CLEAR_RECORDS + "\n");
        System.out.println("Successfully cleared " + gameMode + " game records.\n");
    }
}
