# Sudoku-CommandLineApp
Sudoku-CommandLineApp is a Java-based console application that leverages Spring Shell to provide an interactive command-line interface for solving Sudoku puzzles. Designed with clean architecture principles, the app showcases the use of design patterns, dependency injection (DI), factory methods, and concurrency to create a flexible and extensible platform for Sudoku solving.

## Features
- Interactive Shell Interface: Utilises Spring Shell for the command-line experience.
- Clean Architecture: Organised codebase emphasizing separation of concerns for maintainability and extensibility.
- Grid Factory: Demonstrates using the Factory pattern to support the easy addition of new grid types.
- Dependency Injection: Leverages Spring's DI capabilities for modular and testable components.
- Concurrency: Implements concurrency for educational purposes has made it extremely slow.
- Extensible Design: Architectured to easily accommodate additional features like new solving algorithms or grid types.

## Running the Application
Clone the Repository
```
git clone https://github.com/yourusername/Sudoku-CommandLineApp.git
cd Sudoku-CommandLineApp
```

Build the Application

Using the Gradle Wrapper:
```
./gradlew build
```
Then run the application from the Main file.

## How to Use
Once the application starts, you'll be presented with a shell interface. Here are some commands to get you started:

help: Lists available commands.
display-grid: Displays the current state of the Sudoku grid.
solve: Solves the current Sudoku puzzle and displays the solution.
Example session:
```
shell:> help
shell:> display-grid
shell:> solve
```
## Concurrency
For educational purposes, the application explores the use of Java's concurrency this has however made it extremely slow, at least how I am implementing it at the moment.

## Architecture Overview
The application is designed with clean architecture principles, structuring the code into layers that separate core logic.

- Domain Layer: Contains the core logic for Sudoku solving, including the puzzle representation and algorithms.
- Service Layer: Coordinates the application's operations, serving as a bridge between the domain and interface layers.
- Interface Layer: Implements the command-line interface using Spring Shell, allowing user interaction with the application.


