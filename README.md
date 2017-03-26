## Synopsis

A sample 8 x 6 implementation of Conway's Game of Life using Java and Maven
https://en.wikipedia.org/wiki/Conway's_Game_of_Life

## Motivation

This application was developed as a Kata to practice a simple TDD implementation

## Run

mvn compile
java -classpath target/classes/ com.jasonblackhurst.gameoflife.App
   or
mvn exec:java -Dexec.mainClass="com.jasonblackhurst.gameoflife.App"

## Test

mvn test

## Sample Output / Usage

Enter the starting state one line at a time using O for live cells and . for dead cells

......O.
OOO...O.
......O.
........
...OO...
...OO...
One tick later looks like this:

.O......
.O...OOO
.O......
........
...OO...
...OO...

## License

MIT

