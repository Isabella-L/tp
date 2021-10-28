# User Guide
* [Introduction](#introduction)
* [Quick Start](#quick-start)
* [Features](#features)
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Introduction 

Typist is a CLI typing game. 

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed. 
2. Down the latest version of `Typist` from [here](http://link.to/duke).
3. Navigate to the folder containing the jar file and run `java -jar tp.jar`

## Features

### Notes about the command format:

* Words in UPPER_CASE are parameters to be supplied by the user.  
e.g. in `history -g GAME_MODE`, `GAME_MODE` is a parameter which can be used as `history -g time`.
* Items in square brackets are optional.  
e.g. `-g GAME_MODE [-n NUMBER_OF_RECORDS]` can be used as `-g time -n 9` or as `-g time`
* Parameters can be in any order.  
e.g. if command specifies `history -g GAME_MODE [-n NUMBER_OF_RECORDS]`, `history [-n NUMBER_OF_RECORDS] -g GAME_MODE`  
is also acceptable.
* If a parameter is expected only once in the command but you specified it multiple times, 
only the first occurrence of the parameter will be taken  
e.g. if you specify `history -g time -g time -n 10`, only `history -g time -n 10` will be taken. 
* For commands which have a help parameter, if `-h` is among the parameters provided, 
all other parameters will be ignored and the guide for that command will be displayed.
e.g. `history -g time -h -n 10` will be interpreted as `history -h`.

### Usage
### Open Game

### {Feature name}: {`Keyword`}
Description of feature  
Format: {format of command}
* Explanation 1 of format
* Explanation 2 of format
<!-- -->
Examples
* command example 1
* command example 2
<!-- -->

### Open Game: `game`
Start a typing game.
Format: `game GAME_MODE [-c]`
* SET_CONTENT `-c` is optional, it allows user to set input content before game starts.
* GAME_MODE 
  * `-w` for game in Word Limit Mode 
  * `-t` for game in Time Limit Mode
* For Time Limit Game:
  * Format: `game -t TIME_LIMIT [-sn] [-c]`
  * START_NOW `-sn` allows user to start the game immediately without the "ready to start?" prompt.
<!-- -->
Examples
* `game -t 30 -sn` 
* `game -w -c`
<!-- --> 


### View past records: `history`
View past game records.  
Format: `history -g GAME_MODE [-n NUMBER_OF_RECORDS] [-h]`
* NUMBER_OF_RECORDS defaults to all records if not provided
* Possible arguments for GAME_MODE are - `word` or `time`
<!-- -->
Examples
* `history -g time -n 10`
* `history -g word`
<!-- -->

### Clear past records: `clear` 
Clear all past game records
Format: `clear [-g GAME_MODE] [-h]`
* GAME_MODE defaults to `all` if not provided
* Possible arguments for GAME_MODE are - `word`, `time` or `all`
<!-- -->
Examples
* `clear -g time`
* `clear`
<!-- -->

### Saving the data
Typists automatically stores the updated game records into text files when gamer enters the 
`bye` command to exit Typists.


### !Warning: Editing the data file
Typists is a game application and only game records will be stored. 
Gamers should not edit the data it will manipulate the integrity of the records.
In the event where the data is editted and the wrong format is inputted, the game will crash when it tries to read the file. 
The only way to make it run smoothly again is to delete the text files, hence losing all the game data.



### `Keyword` - Describe action

List of the keywords are shown below:

`content`-Set the content

`new`-Enter a word-limited game mode

>Exit word-limited game mode command: `Exit`

`time`-Enter a time-limited game mode

`error`-Enter a error detecting game mode

`bye`-Exit the program.

### Showing summary of a game
Statistics of game is shown automatically after a game is finished.

## Example of usage:

```
game -w
     | Enter how many words you want the game to run: 
5
     | lorem ipsum is simply dummy 
lorem ipsum is simply dummy
     | Your progress:5/5
```
```
game -t 30 -sn
     | lorem ipsum is simply dummy text of the printing and 
lorem ipsum is simply dummy text of the printing and 
     | typesetting imply dummy text of the printing and typesetting industry 
typesetting imply dummy text of the printing and typesetting industry
     | Timer's UP!
```
## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

| Feature  | Command |
| ------------- | ------------- | 
| Start Word Limit Game| `game -w [-c]` | 
| Start Time Limit Game | `game -t TIME_LIMIT [-sn] [-c]`
| Get History | `history -h`|