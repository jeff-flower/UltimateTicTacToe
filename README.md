## About This Project
This project enjoys long walks on the beach, fluffy dogs and staring deeply
into the glowing light of a command line terminal.

But seriously...
This project was originally a program meant to run on a server for competing
in an AI Bot Challenge run by [The AI Games](http://theaigames.com). Specifcally,
[Ultimate Tic Tac Toe](http://theaigames.com/competitions/ultimate-tic-tac-toe/rules)

When we couldn't get Clojure to work on their servers, we went ahead and built a program
that could run a game between two competing programs.

The two bots are given separate Clojure channels. The game engine informs the moving 
bot of the board state.  When the game engine receives a response from the moving bot
it confirms the move is valid, produces a new board state and informs the other bot
of the board state.  This continues until the game engine determines the board state is 
a winning board state for one of the bots (or in the event of no winning state, a draw).

Currently the project includes program files for a naive game playing bot (it chooses a 
valid move at random) and a slightly more sophisticated bot that uses a rule based
system for movement selection.  Any program that adheres to the api described at the 
[The AI Games](http://theaigames.com) and implements a function that reads and writes to
a channel should be able to run on the game engine.

### Is our game engine any good?
Probably not. But it's ours, and we love it anyways.

## Running

### In the terminal
Although it won't be very exciting, in the terminal, assuming leiningen is installed,
navigate to the root of the project folder and enter:

    => lein run

### And if I don't have Leiningen or Clojure installed?
Leiningen has tools for packaging the program as a JAR file. We don't have one yet,
but eventually we will.

## Testing with [Midje](https://github.com/marick/Midje)

### Setup
1) In ~/.lein/profiles.clj and add:

    {:user {:plugins [[lein-midje "3.1.3"]]}}

### [Tutorial](https://github.com/marick/Midje/wiki/A-tutorial-introduction)

### Running your tests

#### Autotest
Autotest will watch your files and rerun your tests any time you save your files.
To run Autotest from an active repl:

    => (use 'midje.repl)
    => (autotest)

#### Run tests once only
If you just want to run your tests once, from the terminal navigate to the root of
your project and enter:

    => lein midje
