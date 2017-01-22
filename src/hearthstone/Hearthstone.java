package hearthstone;

import java.util.Random;
import java.util.Scanner;

public class Hearthstone {

    public static void main(String[] args) {
        int playerOneChoice;
        int playerTwoChoice;
        String player1;
        String player2;

        Random RNG = new Random();
        Scanner myKeyboard = new Scanner(System.in);

        System.out.println("Hearthstone!\n");
        System.out.println("Adjust the output window to fullscreen so the text can be as clear as possible\n");

        System.out.println("Player One: Please enter your name");
        player1 = myKeyboard.next();

        Hero p1Hero = new Hero(player1);

        System.out.println("Player Two: Please enter your name");
        player2 = myKeyboard.next();

        Hero p2Hero = new Hero(player2);

        do {
            System.out.println("\n" + p1Hero.name + ", what Hero would you like to choose? ");
            System.out.println("1. Hunter\n"
                    + "2. Mage\n"
                    + "3. Paladin");
            p1Hero.restriction = 0;
            playerOneChoice = myKeyboard.nextInt();

        } while (playerOneChoice != 1 && playerOneChoice != 2 && playerOneChoice != 3);

        p1Hero = p1Hero.chooseClass(playerOneChoice);

        do {
            System.out.println("\n" + p2Hero.name + ", what Hero would you like to choose? ");
            System.out.println("1. Hunter\n"
                    + "2. Mage\n"
                    + "3. Paladin");
            p1Hero.restriction = 0;
            playerTwoChoice = myKeyboard.nextInt();
        } while (playerTwoChoice != 1 && playerTwoChoice != 2 && playerTwoChoice != 3);

        p2Hero = p2Hero.chooseClass(playerTwoChoice);

        Game start = new Game();
        start.startGame(player1, player2, p1Hero, p2Hero, RNG);
    }

}
