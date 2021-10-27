package seedu.typists.ui;

import seedu.typists.game.GameRecord;

import java.util.ArrayList;

import static seedu.typists.common.Messages.HISTORY;

public class HistoryCommandUi {
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
        }
    }

    public static void displayHelp() {
        //do after user guide
        System.out.print("display help placeholder\n");
    }
}
