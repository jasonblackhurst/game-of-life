## Synopsis

A sample 8 x 6 implementation of Conway's Game of Life using Java and Maven
- [Wikipedia - Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life)

## Motivation

This application was developed as a Kata to practice a simple TDD implementation

## Run
```
mvn compile
java -classpath target/classes/ com.jasonblackhurst.gameoflife.App
   or
mvn exec:java -Dexec.mainClass="com.jasonblackhurst.gameoflife.App"
```

## Test

mvn test

## License

MIT

