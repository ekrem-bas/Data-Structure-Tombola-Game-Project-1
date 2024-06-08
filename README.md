## Tombola Game

Welcome to the Tombola Game, a classic bingo-style game implemented in Java! This game supports two players and allows them to compete by marking off numbers on their cards as they are randomly drawn. The game continues until one of the players achieves "Bingo" or "Tombola".

## Features

- **Two-player game:** Each player gets a unique card.
- **Random number generation:** Numbers are drawn randomly, ensuring a fair game.
- **Game state visualization:** Players' cards are printed at each step, showing the progress.
- **Bingo/Tombola detection:** The game detects when a player achieves Bingo or Tombola and announces the winner.

## How to Play

1. **Start the game:**

- Run the Main class.
- Enter the names of Player 1 and Player 2 when prompted.

2. **Gameplay:**

- Press Enter to draw the next number.
- The drawn number is announced, and each player's card is updated.
- The game continues until one player achieves Bingo or Tombola.

3. **End the game:**

- The game will automatically announce the winner and end when a player wins.
- You can also type stop and press Enter to exit the game early.

## Code Structure
- **Main.java:** The main class that sets up the game, handles user input, and controls the game loop.
- **Cards.java:** Handles the generation and display of tombola cards.
- **MultiLinkedList.java:** A custom linked list implementation to manage the game state.
- **Node.java:** Represents a node in the linked list.

## Classes and Methods

Main.java
- main(String[] args): The main method that initializes the game.
- convertIntegerArraysToString(int[][] card): Converts integer arrays to string arrays for display.
- generatePermutation(int size): Generates a permutation of numbers from 1 to size.

Cards.java
- generateNumbersArray(int[][] numbers): Fills the numbers array according to tombola card rules.
- generateTombolaCard(int[][] card): Generates a tombola card with unique numbers.
- printArray(String[][] card, String name): Prints the tombola card for a player.
- checkStringArray(String[][] card, int data): Updates the card to mark the drawn number.
- checkArray(int i, int j, int[][] card): Checks if a position in the card can be filled.
- getRandomNumberForColumn(int column): Generates a random number for a given column.
  
MultiLinkedList.java
- add(T data): Adds a node to the list.
- addChild(T data): Adds a child node to the list.
- addGrandChild(T data): Adds a grandchild node to the list.
- checkFirstLine(T data): Checks the first line for the drawn number.
- checkSecondLine(T data): Checks the second line for the drawn number.
- checkThirdLine(T data): Checks the third line for the drawn number.
- addCardToLinkedList(MultiLinkedList<Integer> player, int[][] card): Adds a card to the linked list.
- checkBingoOrTombola(String player): Checks if a player has achieved Bingo or Tombola.
- removeAndGetData(): Removes and returns the data from the head of the list.
  
Node.java
- Node(T data): Constructs a new node with the given data.

## How to Run

1. Clone the repository:
    ```sh
    git clone https://github.com/ekrem-bas/Data-Structure-Tombola-Game-Project.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Data-Structure-Tombola-Game-Project
    ```
3. Compile the Java files:
    ```sh
    javac Main.java
    ```
4. Run the game:
   ```sh
   java Main
   ```

Enjoy the game and may the best player win!

## Screenshots

![Resim1](https://github.com/ekrem-bas/TombolaGame/assets/145195096/b50b1395-4532-4546-8080-766d20880021)

![Resim2](https://github.com/ekrem-bas/TombolaGame/assets/145195096/5c2b0291-a7a6-4b9c-a262-656e94d8aec8)

![Resim3](https://github.com/ekrem-bas/TombolaGame/assets/145195096/f8870f04-faa4-48e7-99ce-e5025069f1ed)

![Resim4](https://github.com/ekrem-bas/TombolaGame/assets/145195096/d193abb2-1f02-4419-b0ca-d9bd8a01a2bf)

![Resim5](https://github.com/ekrem-bas/TombolaGame/assets/145195096/2feead98-44ac-459d-adc2-daefe68a7709)

![Resim6](https://github.com/ekrem-bas/TombolaGame/assets/145195096/3cd7ba10-e736-46f0-bf4a-70f251cba09f)

![Resim7](https://github.com/ekrem-bas/TombolaGame/assets/145195096/e6d450cb-cf46-4413-ae54-d09de957741b)







