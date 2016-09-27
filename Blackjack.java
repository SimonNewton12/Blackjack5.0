package osborn.andrew.blackjack;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play blackjack!");
        Deck playingDeck = new Deck();
        System.out.print("How many decks would you like to play with?");
        int numDecks = input.nextInt();

        // amount of decks to be played with is set by user and sent as argument
        playingDeck.createFullDeck(numDecks);
        playingDeck.shuffle();
    }
}
