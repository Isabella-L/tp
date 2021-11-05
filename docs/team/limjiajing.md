# Lim Jia Jing - Project Portfolio Page

## Overview
Typists is a command line interface typing game targeted at users who love to type and are 
familiar with the command line interface. There are two game modes in types, time-limited 
(aim to type as much as possible in a limited time) and word-limited (aim to type a chosen 
number of words as fast as possible).

### Summary of Contributions
#### Code contributed: [RepoSense link](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=2021-09-25&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=LimJiaJing&tabRepo=AY2122S1-CS2113-T13-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)

#### Contribution to code design
Suggest having all command classes implement a common interface and using factory 
design pattern to create instantiate objects of classes which implement the interface 
for code to have less coupling.

#### Enhancements implemented
* New feature: Added the summary feature that will show the game's summary after a game finishes.
   * What it does: Shows the summary of the game to gamers after they complete a game.
   * Justification: This feature improves the project significantly because gamers mostly 
   want to know how they did in a game. 
   * Highlights: The logic of getting the mistakes made was fairly complicated as it required taking into
   considerations many conditions and scenarios. The implementation of this feature also affects the implementation 
   of the `view history` feature, hence the design had to be well-thought-out.
  
<div style="page-break-after: always;"></div>
   
* New feature: Added the ability to view records of past games.
    * What it does: Allows gamers to select which game mode's past records they want to view 
   and how many records (from the most recent) they want to view. Defaults to 
   all the records in the selected game mode if they do not specify the number to records to view.
    * Justification: Gamers would want to view how they did in the past and see how they improved over time. 
   The gamers could also be typists who use this application to improve their typing. They might want to view 
   which words they type wrongly most often so that they can work on it.
    * Highlights: The command related to this feature `history` has both optional and compulsory parameters. The parsing
   for this command was hence rather complicated to implement.


* New feature: Added the ability to clear all past game records.
    * What it does: Clear the past game records of a selected game mode. If the game mode is
   not specified, game records from both game modes are wiped.
    * Justification: Gamers would at times like to clear their past records so that they can start afresh.


* New feature: Added automatic storage of game records.
    * What it does: Automatically stores changes in game records to the corresponding text file 
   (different text files for different game modes). 
    * Justification: This feature is required for the `view history` feature.
    * Highlights: Extensive exception handling had to be done for the scenario where 
    the gamer modifies the text files to an unreadable format.

#### Documentation
* User Guide
  * Added `Notes about command format` section.  
  * Added documentation for features `view game summary`, `view past records`,  
  `clear past records`and `automatic storage`.
* Developer Guide
  * Added implementation details for the proposed `view statistics` feature.

#### Project management
* Assigned issues created during practical examination dry-run to teammates responsible for those parts.
* Wrapped up milestones.
* Create issues for v1.0 user stories.

