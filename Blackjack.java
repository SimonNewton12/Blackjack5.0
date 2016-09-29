package osborn.andrew.blackjack;

import java.util.List;
import java.util.Scanner;

public class Blackjack
{
    private Database database;
    private Dealer dealer;
    private Deck playingDeck;
    private int numPlayers;
    private Player player;
    private Card dealtCard;
    private Scanner input = new Scanner(System.in);
    private static int DEAL = 2;
    private static int HIT = 1;

    public Blackjack()
    {
        database = new Database();
        dealer = new Dealer();

        System.out.println("Let's play blackjack!\n");
        System.out.print("How many players? ");
        numPlayers = input.nextInt();
        createPlayers();

        playingDeck = new Deck();
        System.out.print("How many decks would you like to play with? ");
        System.out.println("");

        // amount of decks to be played with is set by user and sent as argument
        int numDecks = input.nextInt();
        playingDeck.createFullDeck(numDecks);
        playingDeck.shuffle();

        placeBets();

        System.out.println("The dealer is dealing...\n");
        dealToDealer(DEAL);
        dealToPlayers(DEAL);
        revealDealerHand();
    }

    /**
     * createPlayers(int numPlayers) creates the appropriate amount of players
     */
    private void createPlayers()
    {
        for (int i = 1; i < numPlayers + 1; i++)
        {
            System.out.print("Player " + i + "'s name: ");
            String name = input.next();
            System.out.print("Player " + i + "'s deposit: ");
            int bankroll = input.nextInt();
            new Player(name, bankroll);
            System.out.println("");
        }
    }

    private void placeBets()
    {
        for (Player aPlayer : database.getPlayers())
        {
            System.out.print(aPlayer.getName() + "'s bet: ");
            int bet = input.nextInt();
            aPlayer.setBet(bet);
            aPlayer.updateBankroll();
        }
    }

    private void dealToDealer(int numCards)
    {
        for (int x = 0; x < numCards; x++)
        {
            dealtCard = playingDeck.dealCard();
            dealer.addCard(dealtCard);
        }
    }

    private void dealToPlayers(int numCards)
    {
        for (Player aPlayer : database.getPlayers())
        {
            for (int y = 0; y < numCards; y++)
            {
                dealtCard = playingDeck.dealCard();
                aPlayer.addCard(dealtCard);
            }
        }
    }

    private void revealDealerHand()
    {
        String dealerHandString = "";
        List<Card> hand = dealer.getHand();
        for (Card aHand : hand)
        {
            dealerHandString += aHand.toString();
        }
        System.out.println("Dealer's hand:");
        System.out.println(dealerHandString);
        System.out.println("");
    }

    private void hit()
    {
        dealtCard = playingDeck.dealCard();
    }
}
