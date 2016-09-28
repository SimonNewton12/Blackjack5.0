package osborn.andrew.blackjack;

import java.util.Scanner;

public class Blackjack
{
    private Database database;
    private Dealer dealer;
    private Deck playingDeck;
    private Scanner input = new Scanner(System.in);
    private static int DEAL = 2;
    private static int HIT = 1;

    public Blackjack()
    {
        database = new Database();
        dealer = new Dealer();

        System.out.println("Let's play blackjack!");
        playingDeck = new Deck();
        System.out.print("How many decks would you like to play with?");

        // amount of decks to be played with is set by user and sent as argument
        int numDecks = input.nextInt();
        playingDeck.createFullDeck(numDecks);
        playingDeck.shuffle();

        createPlayers();
    }

    public void createPlayers()
    {
        System.out.print("Player 1, enter your name: ");
        String name = input.next();
        System.out.println();
        int bankroll = input.nextInt();
        new Player(name, bankroll);
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
