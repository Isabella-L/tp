# Lu Sicheng - Project Portfolio Page

## Overview: TYPIST
Typists is a command line interface typing game targeted at users who love to type and are
familiar with the command line interface. There are two game modes in types, time-limited
(aim to type as much as possible in a limited time) and word-limited (aim to type a chosen
number of words as fast as possible).

Given below are my contributions to the project: 

#### Code contributed: [RepoSense link](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-25&tabOpen=true&tabType=zoom&zA=Isabella-L&zR=AY2122S1-CS2113-T13-4%2Ftp%5Bmaster%5D&zACS=167.6350974930362&zS=2021-09-25&zFS=&zU=2021-11-08&zMG=false&zFTF=commit&zFGS=groupByRepos&zFR=false)

#### Features 

* **New Feature**: Added the Time-Limited Game
  * What it does: allows the user to type words within a set period of time and analyse the result. 
  * Justification: It allows the user to control the input time.
  * Highlights: This feature is one of the 2 game modes. It is the one of the fundamentals of Typist. 
  And it required manipulation of the `Data/Time` java API.
* **New Feature**: Added the ability to put game usages into 1 command
  * What it does: gives the user option to input all usage command at once. 
  For instance, the `-sn` tag will enable user to start timer immediately without the "Enter 'start' to start timer" prompt.
  The `-c` tag enable user to override the current content set before starting game.
  Adding integer directly after `game -MODE ` will avoid the "enter the game limit" prompt.
  * Justification: This feature increases the usability significantly because users (assumed familiar 
  with cli and typing) would have a much more convenient, effective and smooth experience using the app. 
  * Highlights: This enhancement affects existing commands and commands to be added in the future. It required 
  rather sophisticated dealing of arraylists, exceptions and constructor overloading for `game` and its subclassess.
* **New Feature**: Added the feature to display different man pages for different commands.

#### Project Management 

* Managed Releases: `v1.0`, `v2.1` on GitHub.

#### Enhancements to existing features:

* Implemented the Factory Design pattern suggested by [Jiajing](limjiajing.md): [#56](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/56).
* Added Typist starting display (with ASCII) and other display format: 
[#15](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/15),
[#16](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/16).

#### Documentation

* User Guide:
  * Added documentation for `game` feature (excluding Word Limit Game section by [Zhansen](shizhansen.md)) and Command Summary: [#152](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/152).
  * Added documentations for Introduction, quickstart, table of content and other cosmetic tweaks. 
  * Added documentations for `man` feature.
* Developer Guide:
  * Added design detail for Architecture (excluding the diagram by [William](williamwahyudi.md).
  * Added design detail for Command Component, Game Component and Time Limit Game section: [#155](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/155). 
  * Added details for manual testing.

#### Community
* [16 PRs reviewed](https://github.com/AY2122S1-CS2113-T13-4/tp/pulls?q=is%3Apr+is%3Aclosed)
* Some parts of `Util` and `TextUi` features I added was adopted by other classmates([#87](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/87)).
* The `game` class I added is inherited by both `TimeLimitGame` and `WordLimitGame`
  ([#56](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/56), [#144](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/144)).
* The `GameCommand` class I added is also applied to both `TimeGameCommand` and `WordGameCommand`([#81](https://github.com/AY2122S1-CS2113-T13-4/tp/pull/81/files)).
