import java.util.Random;

public class Cards {

    // numbers array that contains numbers from 0 to 89
    int[][] numbers = new int[10][9];

    // fill the numbers array according to the rule of tombola card
    public void generateNumbersArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                // fill numbers according to their columns
                // 0-9 first column, 10-19 second column, ... , 80-89 ninth column
                numbers[i][j] = j * 10 + i;
            }
        }
    }

    // generate tombola cards according to the tombola card rules
    public void generateTombolaCard(int[][] card) {
        // we need 15 numbers the rest of them will be '0'
        int numberCounter = 15;
        while (numberCounter > 0) {
            // generate random integer values
            int i = (int) (Math.random() * 3);
            int j = (int) (Math.random() * 9);
            // generate a number according to the rules
            int data = checkArray(i, j, card);
            // if the rules are met the program will generate different number from '-1'
            // and we don't want '0' so numbers greater than '0' need to be generated
            if (data > 0) {
                // fill the card with that number
                card[i][j] = data;
                // and decrease the counter
                numberCounter--;
            }
        }
    }

    // print tombola card arrays at each step of the game
    public void printArray(String[][] card, String name) {
        System.out.println(name + "'s Card: \n-------------------------------------");
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                System.out.print(card[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    // check the arrays to print them with '+' if they have the number
    public void checkStringArray(String[][] card, int data) {
        String stringData = String.valueOf(data);
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j].equals(stringData)) {
                    card[i][j] = card[i][j] + "+";
                }
            }
        }
    }

    // check bingo cards and generate numbers for them if they match the rules
    public int checkArray(int i, int j, int[][] card) {
        // if the i, j coordinate is not empty return -1
        if (card[i][j] != 0) {
            return -1;
        }

        // row counter to check if it has more than 2 number in the same column
        int rowCounter = 0;
        for (int r = 0; r < 3; r++) {
            // if there is a number of the jth column increase the counter
            if (card[r][j] != 0) {
                rowCounter++;
            }
        }

        // if it has 2 number at the same column it will return -1
        if (rowCounter >= 2) {
            return -1;
        }

        // row counter to check if it has more than 5 number in the same row
        int columnCounter = 0;
        for (int c = 0; c < 9; c++) {
            // if there is a number of the ith row increase the counter
            if (card[i][c] != 0) {
                columnCounter++;
            }
        }

        // if it has 5 number at the same column it will return -1
        if (columnCounter >= 5) {
            return -1;
        }

        // if all rules are met get suitable number for that column
        return getRandomNumberForColumn(j);
    }

    // get random number for given column
    public int getRandomNumberForColumn(int column) {
        // create a Random object to generate random numbers
        Random random = new Random();

        // choose random row
        int randomRow = random.nextInt(numbers.length);

        // return a number from numbers array with given column and random row
        int number = numbers[randomRow][column];
        // and set that number to '0' so other cards do not have the same value
        numbers[randomRow][column] = 0;
        return number;
    }

}