package seedu.typists.ui;

import seedu.typists.game.GameRecord;

import java.util.ArrayList;

import static seedu.typists.common.Messages.HISTORY;

public class HistoryCommandUi {
    private static final String SUMMARY_SEPARATOR =
            "==================================================================";

    public static void displayGameRecords(ArrayList<GameRecord> gameRecords, int numberOfGameRecords) {
        if (gameRecords == null) {
            System.out.print("The number of game records you requested to view is more than what you have.\n"
                    + "Number of game records you have is " + numberOfGameRecords + ".\n");
            return;
        }
        System.out.print(HISTORY + "\n");
        if (gameRecords.size() == 0) {
            System.out.print("No records to display.\n");
        }
        for (GameRecord gameRecord : gameRecords) {
            SummaryUi.displaySummary(gameRecord);
            System.out.print(SUMMARY_SEPARATOR + "\n");
        }
    }

    public static void displayHelp() {
        //do after user guide
        System.out.print("history shows the game records for your past games.\n");
        System.out.print("Command format: 'history -g GAME_MODE [-n NUMBER_OF_RECORDS]'\n");
        System.out.print("Arguments in the square brackets are optional.\n");
        System.out.print("GAME_MODE specifies which game mode records you want to view.\n"
                + "The possible values for GAME_MODE are 'time' and 'word'.\n");
        System.out.print("NUMBER_OF_RECORDS specifies the number of past records you want to view.\n"
                + "Only positive integers are allowed.\n"
                + "If not inputted, the default is the total number of game records "
                + "you have for the selected game mode.\n");

    }
}
