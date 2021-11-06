package seedu.typists.ui;

import java.util.Scanner;

public class GameUi extends TextUi {

    public void printEnd(String endMessage) {
        printScreen(endMessage);
    }

    public void readyToStartTimer() {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (!command.equals("start")) {
            printScreen("Timer will start once you entered \"start\": ");
            command = in.nextLine();
        }
    }

    public void printOvershoot(double overshoot) {
        printScreen(
                "While on your last sentence, "
                        + "you exceeds the game by "
                        + String.format("%.2f", overshoot)
                        + " seconds."
        );
    }

    public void printGameMode1Progress(int a, int b) throws InterruptedException {
        viewAnimateLeft("Your progress:" + String.valueOf(a) + "/" + String.valueOf(b));
    }

    public void printResetContent(int n) {
        printScreen(
                "Please reset your content to more than "
                + n + " words."
        );
    }
}
