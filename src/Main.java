import java.util.Random;
import java.util.Scanner;

public class Main {
    // create an integer array for player 1
    static int[][] card1 = new int[3][9];
    // create an integer array for player 2
    static int[][] card2 = new int[3][9];
    // convert them to string to add '+' when they have the number
    static String[][] card1String = new String[3][9];
    static String[][] card2String = new String[3][9];
    // permutation array to get random number
    static int[] permutation = new int[90];

    public static void main(String[] args) {
        // scanner to get username and continue to game with pressing enter
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("       Welcome to Tombola Game       ");
        System.out.println("-------------------------------------");
        System.out.println("Player 1 : Please enter your name...");
        String player1Name = scanner.nextLine();
        System.out.println("-------------------------------------");
        System.out.println("Player 2 : Please enter your name...");
        String player2Name = scanner.nextLine();
        System.out.println("-------------------------------------");
        Cards cards = new Cards();
        // fill numbers (0-90) to numbers array to avoid repeated numbers
        cards.generateNumbersArray(cards.numbers);
        // generate tombola card for player 1 and convert it to String array
        cards.generateTombolaCard(card1);
        card1String = convertIntegerArraysToString(card1);
        // print the tombola card 1 before the game started
        cards.printArray(card1String, player1Name);
        // generate tombola card for player 2 and convert it to String array
        cards.generateTombolaCard(card2);
        card2String = convertIntegerArraysToString(card2);
        // print it before the game started
        cards.printArray(card2String, player2Name);
        // fill the permutation array with generatePermutation method
        permutation = generatePermutation(90);
        // create linked lists for permutation and cards
        MultiLinkedList<Integer> permutationList = new MultiLinkedList<>();
        MultiLinkedList<Integer> player1 = new MultiLinkedList<>();
        MultiLinkedList<Integer> player2 = new MultiLinkedList<>();
        // add all the values of the permutation array to the linked list
        for (int i = 0; i < permutation.length; i++) {
            permutationList.add(permutation[i]);
        }
        // add player cards to linked list
        player1.addCardToLinkedList(player1, card1);
        player2.addCardToLinkedList(player2, card2);
        // game loop
        while (true) {
            // get input to continue to game
            System.out.println("Press enter to continue \n(or write 'stop' to exit)");
            System.out.println("-------------------------------------");
            String input = scanner.nextLine();
            // if input equals to stop it will stop the loop
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            // get integer from permutation multi linked list to do operations
            int data = permutationList.removeAndGetData();
            System.out.println("Number is: " + data);
            System.out.println("-------------------------------------");
            // do the check operations
            player1.checkFirstLine(data);
            player1.checkSecondLine(data);
            player1.checkThirdLine(data);
            player2.checkFirstLine(data);
            player2.checkSecondLine(data);
            player2.checkThirdLine(data);
            // check cards and add '+' if one of them have the number
            cards.checkStringArray(card1String, data);
            // print the cards every step of the game
            cards.printArray(card1String, player1Name);
            cards.checkStringArray(card2String, data);
            cards.printArray(card2String, player2Name);
            // when the tombola condition is met stop the game loop
            if (player1.checkBingoOrTombola(player1Name) || player2.checkBingoOrTombola(player2Name)) {
                break;
            }
        }
    }

    // convert number arrays to String array
    public static String[][] convertIntegerArraysToString(int[][] card) {
        String[][] result = new String[card.length][card[0].length];
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                result[i][j] = String.valueOf(card[i][j]);
            }
        }
        return result;
    }

    // permutation method
    public static int[] generatePermutation(int size) {
        // if we give the size 90, 90 will also be included in the array.
        // https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
        int[] permutation = new int[size];
        // generate permutation array
        for (int i = 0; i < size; i++) {
            permutation[i] = i + 1;
        }
        // generate random number for swap operation
        Random random = new Random();
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = size - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = random.nextInt(i + 1);
            // Swap permutation[i] with the element at random index
            int temp = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = temp;
        }
        return permutation;
    }
}
