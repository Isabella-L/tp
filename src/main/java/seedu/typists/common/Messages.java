package seedu.typists.common;

/**
 * Container for user visible messages.
 */
public class Messages {
    public static final String LOGO =
            "  ______            _      __\n"
                    + " /_  __/_  ______  (_)____/ /_\n"
                    + "  / / / / / / __ \\/ / ___/ __/\n"
                    + " / / / /_/ / /_/ / (__  ) /_\n"
                    + "/_/  \\__, / .___/_/____/\\__/\n"
                    + "    /____/_/";

    public static final String SUMMARY =
            "   _____ __  ____  _____  ______    ______  __\n"
                    + "  / ___// / / /  |/  /  |/  /   |  / __ \\ \\/ /\n"
                    + "  \\__ \\/ / / / /|_/ / /|_/ / /| | / /_/ /\\  / \n"
                    + " ___/ / /_/ / /  / / /  / / ___ |/ _, _/ / /  \n"
                    + "/____/\\____/_/  /_/_/  /_/_/  |_/_/ |_| /_/";

    public static final String HISTORY =
            "    __  _____________________  ______  __\n"
                    + "   / / / /  _/ ___/_  __/ __ \\/ __ \\ \\/ /\n"
                    + "  / /_/ // / \\__ \\ / / / / / / /_/ /\\  / \n"
                    + " / __  // / ___/ // / / /_/ / _, _/ / /  \n"
                    + "/_/ /_/___//____//_/  \\____/_/ |_| /_/";

    public static final String CLEAR_RECORDS =
            "   ________    _________    ____     ____  ________________  ____  ____  _____\n"
                    + "  / ____/ /   / ____/   |  / __ \\   / __ \\/ ____/ ____/ __ \\/ __ \\/ __ \\/ ___/\n"
                    + " / /   / /   / __/ / /| | / /_/ /  / /_/ / __/ / /   / / / / /_/ / / / /\\__ \\ \n"
                    + "/ /___/ /___/ /___/ ___ |/ _, _/  / _, _/ /___/ /___/ /_/ / _, _/ /_/ /___/ / \n"
                    + "\\____/_____/_____/_/  |_/_/ |_|  /_/ |_/_____/\\____/\\____/_/ |_/_____//____/  \n";


    public static final String KEYBOARD =
            ",---,---,---,---,---,---,---,---,---,---,---,---,---,-------,\n"
                    + "|1/2| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 0 | + | ' | <-    |\n"
                    + "|---'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-----|\n"
                    + "| ->| | Q | W | E | R | T | Y | U | I | O | P | ] | ^ |     |\n"
                    + "|-----',--',--',--',--',--',--',--',--',--',--',--',--'|    |\n"
                    + "| Caps | A | S | D | F | G | H | J | K | L | \\ | [ | * |    |\n"
                    + "|----,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'---'----|\n"
                    + "|    | < | Z | X | C | V | B | N | M | , | . | - |          |\n"
                    + "|----'-,-',--'--,'---'---'---'---'---'---'-,-'---',--,------|\n"
                    + "| ctrl |  | alt |                          |altgr |  | ctrl |\n"
                    + "'------'  '-----'--------------------------'------'  '------'\n";

    public static final String LETTER =
            "(\\ \n"
                    + "\\'\\ \n"
                    + " \\'\\     __________  \n"
                    + " / '|   ()_________)\n"
                    + " \\ '/    \\ ~~~~~~~~ \\\n"
                    + "   \\       \\ ~~~~~~   \\\n"
                    + "   ==).      \\__________\\\n"
                    + "  (__)       ()__________)";

    public static final String CLOCK =
            ".'`~~~~~~~~~~~`'.\n"
                    + "(  .'11 12 1'.  )\n"
                    + "|  :10 \\|   2:  |\n"
                    + "|  :9   @   3:  |\n"
                    + "|  :8       4;  |\n"
                    + "'. '..7 6 5..' .'\n"
                    + " ~-------------~ ";

    public static final String MESSAGE_WELCOME = "Welcome to Typist -- the ultimate cli typing game.";
    public static final String MESSAGE_ACKNOWLEDGE = "Brought to you by -- AY2122S1-CS2113-T13-4.";
    public static final String MESSAGE_MAN = "man: check man page to get started!";
    public static final String MESSAGE_HELP = "Manual:\n"
            + "content: set the content\n"
            + "game -time: start a new time game\n"
            + "game -word: start a new word game\n"
            + "history -g GAME_MODE [-n NUMBER_OF_RECORDS]: view past game records\n"
            + "clear [-g GAME_MODE]: clear all game records\n"
            + "man [COMMAND]: view the man page for a the command\n"
            + "bye: exit typist";

    public static final String MESSAGE_HELP_HISTORY = "View past game records.\n"
            + "Command format: 'history -g GAME_MODE [-n NUMBER_OF_RECORDS]'\n"
            + "Input \"history -h\" for complete detail";

    public static final String MESSAGE_HELP_GAME = "Start a typing game.\n"
            + "Command format: game -GAME_MODE [GAME_LIMIT] [-c] [-sn]\n"
            + "GAME_MODE:\n"
            + "     time: time-limited (aim to type as much as possible in a limited time)\n"
            + "     word: word-limited (aim to type a chosen number of words as fast as possible)\n"
            + "[GAME_LIMIT]: number of words/time you want the game to run.\n"
            + "[-c]: override current content \n"
            + "[-sn]: start the timer immediately (once all conditionals are specified by user)";

    public static final String MESSAGE_HELP_CONTENT = "Set the typing content before the game.\n"
            + "Command format: content 1-3";

    public static final String MESSAGE_HELP_CLEAR = "Clear all past game records.\n"
            + "Command format: clear [-g GAME_MODE] [-h]";

    public static String MESSAGE_TIME_GAME_END = "Timer's UP!";

    //This sample text is gotten from https://www.lipsum.com/
    public static final String SAMPLE_TEXT =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
                    + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
                    + "when an unknown printer took a galley of type and scrambled it to make a type specimen book. "
                    + "It has survived not only five centuries, but also the leap into electronic typesetting, "
                    + "remaining essentially unchanged. It was popularised in the 1960s with the release of "
                    + "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing"
                    + " software like Aldus PageMaker including versions of Lorem Ipsum.";
}
