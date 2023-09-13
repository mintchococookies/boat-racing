# Boat Racing
A Java OOP implementation of a boat racing game, similar to snake and ladders. In this game, snakes are replaced by traps and ladders are replaced by currents. Players take turns to roll a dice to progress from the start to end along a board with randomly placed currents and traps. 3 difficulty levels are available with different numbers of traps and currents on the board.

![Alt Text](https://github.com/mintchococookies/boat-racing/blob/main/boatracing1.png)
![Alt Text](https://github.com/mintchococookies/boat-racing/blob/main/boatracing2.png)

## Features
1. **Menu Screen**
   - Players are presented with options to start the game, view the scoreboard, read game instructions, or exit the game.

2. **Difficulty Levels**
   - Players choose a difficulty level (Easy, Intermediate, or Hard) to start the game, which determines the river map's characteristics.

3. **Game Starts**
   - Players' boats start at location 0, and they take turns rolling a dice to move their boats.

4. **Currents**
   - When a player lands on a location with a current, their boat moves forward by a certain number of steps based on the current's value.

5. **Traps**
   - When a player lands on a location with a trap, their boat moves backward by a certain number of steps based on the trap's value.

6. **Game Ends**
   - The player whose boat reaches location 100 first wins the game, and a winning message is displayed along with the number of moves used. Top 5 scores are recorded in the scoreboard.

7. **Scoreboard**
   - Players can view scoreboards for different difficulty levels and see the recorded scores.

8. **Game Instructions**
   - Players can access game instructions to learn how to play the game.

9. **Exit the Game**
    - Players can choose to exit the game, which terminates the program.

10. **Error Validation**
    - Error messages are displayed if players enter invalid options, guiding them to make valid choices. Error validation is also applied to difficulty and scoreboard level selections.
