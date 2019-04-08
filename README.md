# Chess Knight Shortest Path

## Requirements:

A Java console application that should represent an empty chessboard where the user will be able to enter a starting 
position and an ending position. The application should then calculate a list of all possible paths that one knight 
(αλογάκι) piece in the starting position could take to reach the ending position in 3 moves. 

Some inputs might not have a solution, in this case the program should display a message that no solution has been 
found. Otherwise, the shortest path (if that exists) should be returned.

## Build and Execution

### Prerequisites
    - OpenJdk 11
    - Apache Maven 3
     
### Build

You can build the project by executing the command ``mvn clean install``

### Execution
java -jar target/roukou-chess-1.0.0.jar E1 B5
