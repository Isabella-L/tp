# User Guide
1. [Introduction](#1-introduction)
2. [Quick Start](#2-quick-start)
3. [Features](#3-features)
   1. [Set Content](#31-set-content-content)
   2. [Open Game](#32-open-game-game)
      1. [Word Mode Game](#321-word-limit-game)
      2. [Time Mode Game](#322-time-limit-game)
   3. [View history](#33-view-past-records-history)
   4. [Clear history](#34-clear-past-records-clear)
   5. [Display Summary](#35-view-summary-of-game)
   6. [Save Data](#36-saving-the-data)
4. [FAQ](#faq)
5. [Command Summary](#command-summary)

## 1. Introduction 

Welcome to Typist! The ultimate CLI typing game!  
Go to [Quick Start](#quick-start) to get started!

## 2. Quick Start

1. Ensure that you have Java 11 installed in your local environment.
2. Down the latest version of `Typist` from [here](https://github.com/AY2122S1-CS2113-T13-4/tp/releases).
3. Navigate to the folder containing the jar file and run `java -jar tp.jar`.
4. If everything goes well, the command interface should display the following:
```
     | Typist - Version 2.0
     | ===========================================================
     |   ______            _      __
     |  /_  __/_  ______  (_)____/ /_
     |   / / / / / / __ \/ / ___/ __/
     |  / / / /_/ / /_/ / (__  ) /_
     | /_/  \__, / .___/_/____/\__/
     |     /____/_/
     | Welcome to Typist -- the ultimate cli typing game.
     | Brought to you by -- AY2122S1-CS2113-T13-4.
     | Manual:
     | content: set the content
     | game -time: start a new time game
     | game -word: start a new word game
     | history -g GAME_MODE [-n NUMBER_OF_RECORDS]: view past game records
     | clear [-g GAME_MODE]: clear all game records
     | bye: exit typist
     | ===========================================================
```

## 3. Features

### Notes about the command format:

* Words in UPPER_CASE are arguments to be supplied by the user.  
e.g. in `history -g GAME_MODE`, `GAME_MODE` is an argument which can be used as `history -g time`.
* Items in square brackets are optional.  
e.g. `-g GAME_MODE [-n NUMBER_OF_RECORDS]` can be used as `-g time -n 9` or as `-g time`
* Parameters can be in any order.  
e.g. if command specifies `history -g GAME_MODE [-n NUMBER_OF_RECORDS]`, `history [-n NUMBER_OF_RECORDS] -g GAME_MODE`  
is also acceptable.  
Note: One parameter is defined as the option e.g. `-g` and its value (if there is such a field) e.g. `time`
* If a parameter is expected only once in the command, but you specified it multiple times, 
only the first occurrence of the parameter will be taken  
e.g. if you specify `history -g time -g time -n 10`, only `history -g time -n 10` will be taken. 
* For commands which have a `-h` parameter, if `-h` is among the parameters provided, all other parameters will be 
ignored and the guide for that command will be displayed.    
e.g `history -g time -h -n 10` will be interpreted as `history -h`.
* All parameters which do not conform to the command syntax will be ignored.  
e.g.2 `clear -gtime` will be interpreted as `clear`

### 3.1 Set Content: `content`
Set the typing content before the game.  
Format: `content` `1-3` `[optional]`

After entering `content`, user can type an integer from 1-3 to choose from following:

1. Opening of famous books
2. Wikipedia article
3. Random sentence of custom length

<!-- input example --> 

Examples
* `content` `1` `3`

<!-- -->

### 3.2 Open Game: `game`
Start a typing game.  
Format: `game -GAME_MODE [GAME_LIMIT] [-c] [-sn]`

* GAME_MODE 
  * `word` for game in Word Limit Mode 
  * `time` for game in Time Limit Mode
#### 3.2.1 Word Limit Game
  In a Word-Limit game, user needs to specify the total number of words 
they want to type. Game will terminate once they finish typing the specified 
number of words. 
* Format: `game -word [WORD_LIMIT] [-c] [-sn]`
* Example: `game -word`
* ```
  game -word 
     | Enter how many words you want the game to run: 
  10
     | Timer will start once you entered "start":
  start
     | Lorem Ipsum is simply dummy
  lorem ipsum is simply dummy
     | Your progress:5/10
  ```
* Exit: `Exit` allows user to terminate the current game.

#### 3.2.2 Time Limit Game
In a Time-Limit Game, user needs to specify the duration 
they want to type. Timer will stop once the duration is reached
and terminates the game at the same time. 
>**NOTE**: 
> The time limit that user inputs needs to be a positive integer that represents time in seconds. 
> It also needs to be multiple of 30. 

* Format: `game -time [TIME_LIMIT] [-c] [-sn]`
* Example: `game -time`  
* ```
  game -time
     | Enter how long you want the game to run:
  60
     | Timer will start once you entered "start":
  start
     | Lorem Ipsum is simply dummy text of the printing and
  Lorem Ipsum is simply dummy text of the printing and
     | Timer's Up!
  ```

    **Exceeding Time:**  
    When you are at the last sentence. Even though Timer is up, the game will wait
    until you finish the last sentence to terminate. You will be informed of the exceeding time,
    and it will count towards your game summary.

#### Optional arguments
* SET_CONTENT `-c`: allows user to set input content before game starts.
* START_NOW `-sn`: allows timer to start immediately without the "start timer" prompt.
* GAME_LIMIT: a positive integer that sets the word/time limit of the game 
 without the "enter limit" prompt.
  > **NOTE**:
  > if you want to specify GAME_LIMIT, it needs to be right after the GAME_MODE argument.
  > If the GAME_LIMIT entered is invalid, game will still start but with the "enter limit" prompt.

<!-- -->

Example 1: `game -time 30`  
Expected outcome: 
```
game -time 30
     | Timer will start once you entered "start": 
start
     | Lorem Ipsum is simply dummy text of the printing and 
```
Example 2: `game -time 30 -sn`  
Expected outcome:
```
game -time -sn 
     | Enter how long you want the game to run: 
30
     | Lorem Ipsum is simply dummy text of the printing and 
```
Example 3: `game -word 20 -sn -c`  
Expected outcome: 
```
(\ 
\'\ 
 \'\     __________  
 / '|   ()_________)
 \ '/    \ ~~~~~~~~ \
   \       \ ~~~~~~   \
   ==).      \__________\
  (__)       ()__________)
     | Content selection (input 0 to go back): 
     | 1. Opening of famous books 
     | 2. Wikipedia article 
     | 3. Random sentence of custom length 
     | Enter your selection:  
```
<!-- --> 


### 3.3 View past records: `history`
View past game records.  
Format: `history -g GAME_MODE [-n NUMBER_OF_RECORDS] [-h]`
* NUMBER_OF_RECORDS defaults to all records if not provided
* Possible arguments for GAME_MODE are - `word` or `time`

<!-- --> 

Examples
* `history -g time -n 10`
* `history -g word`  

<!-- --> 

Example of usage
```
history -g time -n 1
    __  _____________________  ______  __
   / / / /  _/ ___/_  __/ __ \/ __ \ \/ /
  / /_/ // / \__ \ / / / / / / /_/ /\  / 
 / __  // / ___/ // / / /_/ / _, _/ / /  
/_/ /_/___//____//_/  \____/_/ |_| /_/
Game Mode: Time-limited
WPM: 49.71
Total Time taken for the game: 36.21 seconds
Number of Wrong Words: 0/30|0.00%
Number of Correct Words: 30/30|100.00%
Mistakes: No words typed wrongly.
==================================================================
```

### 3.4 Clear past records: `clear` 
Clear all past game records
Format: `clear [-g GAME_MODE] [-h]`
* GAME_MODE defaults to `all` if not provided
* Possible arguments for GAME_MODE are - `word`, `time` or `all`

<!-- --> 

Examples
* `clear -g time`
* `clear`

<!-- --> 

Example of usage
```
clear -g time
   ________    _________    ____     ____  ________________  ____  ____  _____
  / ____/ /   / ____/   |  / __ \   / __ \/ ____/ ____/ __ \/ __ \/ __ \/ ___/
 / /   / /   / __/ / /| | / /_/ /  / /_/ / __/ / /   / / / / /_/ / / / /\__ \
/ /___/ /___/ /___/ ___ |/ _, _/  / _, _/ /___/ /___/ /_/ / _, _/ /_/ /___/ /
\____/_____/_____/_/  |_/_/ |_|  /_/ |_/_____/\____/\____/_/ |_/_____//____/

Successfully cleared Time-limited game records.
```

### 3.5 View summary of game
View summary of a just-played game.
Typists automatically generates and displays the summary after a game ends.   
The summary consists of the following fields:
* Game mode
* Word per minute (WPM)
* Total time taken for the game
* Number of wrong words and its percentage
* Number of correct words and its percentage
* Wrongly and not typed words (Mistakes)

<!-- --> 

Example of usage
```
   _____ __  ____  _____  ______    ______  __
  / ___// / / /  |/  /  |/  /   |  / __ \ \/ /
  \__ \/ / / / /|_/ / /|_/ / /| | / /_/ /\  /
 ___/ / /_/ / /  / / /  / / ___ |/ _, _/ / /  
/____/\____/_/  /_/_/  /_/_/  |_/_/ |_| /_/
Game Mode: Time-limited
WPM: 49.71
Total Time taken for the game: 36.21 seconds
Number of Wrong Words: 0/30|0.00%
Number of Correct Words: 30/30|100.00%
Mistakes: No words typed wrongly.
```
### 3.6 Saving the data
Typists automatically stores the game records (and any changes to them) into text files.


### !Warning: Editing the data file
Typists is a game application and only game records will be stored. 
Gamers should not edit the data it will manipulate the integrity of the records.
In the event where the data is edited and the wrong format is inputted, the file contents will be cleared, 
hence losing all the game data.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

| Command  | Action |
| ------------- | ------------- | 
|`content`| Set the content
|`game -word [WORD_LIMIT] [-sn] [-c]` | Start a word-limited game
|`game -time [TIME_LIMIT] [-sn] [-c]` | Start a time-limited game
|`history -g GAME_MODE [-n NUMBER_OF_RECORDS] [-h]` | Clear history
|`clear` | Clear history
|`bye`| Exit the program
