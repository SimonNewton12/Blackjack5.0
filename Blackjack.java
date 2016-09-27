package osborn.andrew.blackjack;

import java.util.Scanner;

public class Blackjack
{
    Deck playingDeck;
    private static int DEAL = 2;
    private static int HIT = 1;

    public Blackjack()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play blackjack!");
        playingDeck = new Deck();
        System.out.print("How many decks would you like to play with?");

        // amount of decks to be played with is set by user and sent as argument
        int numDecks = input.nextInt();
        playingDeck.createFullDeck(numDecks);
        playingDeck.shuffle();
    }

    public void deal()
    {
        String dealtCards = playingDeck.dealCard(DEAL);
        System.out.println(dealtCards);
    }

    public void hit()
    {
        String dealtCards = playingDeck.dealCard(HIT);
        System.out.println(dealtCards);
    }
}
