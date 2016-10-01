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
    private int handValue;
    private Scanner input = new Scanner(System.in);
    private List<Player> activePlayers;
    private static int DEAL = 2;
    private static int HIT = 1;
    private static int BLACKJACK = 21;

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
        // amount of decks to be played with is set by user and sent as argument
        int numDecks = input.nextInt();
        System.out.println("");
        playingDeck.createFullDeck(numDecks);
        playingDeck.shuffle();

        // loops while at least one player is still at the "table"
        while (true)
        {
            placeBets();
            dealToDealer(DEAL);
            System.out.println("The dealer is dealing...\n");
            dealToPlayers(DEAL);
            revealUpcard();
            getUpcardValue();

            for (Player aPlayer : database.getPlayers())
            {
                    revealPlayersHand(aPlayer);
                    calculatePlayerHandValue(aPlayer);
                    do
                    {
                        hitOrStand(aPlayer);
                        revealPlayersHand(aPlayer);
                        calculatePlayerHandValue(aPlayer);
                        if (didPlayerBust(aPlayer))
                        {
                            System.out.println(aPlayer.getName() + " busted!\n");
                            break;
                        }
                    }
                    while (aPlayer.getChoseHit());
            }
            revealDealerHand();
            calculateDealerHandValue();

            if (dealer.getHandValue() < 16)
            {
                dealToDealer(1);
                revealDealerHand();
                calculateDealerHandValue();
            }

            for (Player aPlayer : database.getPlayers())
            {
                winLossOrStand(aPlayer);
                aPlayer.clearHand();
                if (aPlayer.getBankroll() <= 0)
                {
                    database.getPlayers().remove(aPlayer);
                }
            }

            dealer.clearHand();
        }
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
            System.out.println(aPlayer.getName() + "'s bankroll: $" + aPlayer.getBankroll());
            System.out.print(aPlayer.getName() + "'s bet: ");
            int bet = input.nextInt();
            aPlayer.setBet(bet);
            aPlayer.updateBankroll();
        }
        System.out.println("");
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

    private void revealUpcard()
    {
        String dealerHandString = "";
        List<Card> hand = dealer.getHand();

        dealerHandString = hand.get(0).toString() + "HOLE CARD\n";
        System.out.println("Dealer's hand:");
        System.out.print(dealerHandString);
    }

    private void revealDealerHand()
    {
        String dealerHandString = "";
        List<Card> hand = dealer.getHand();
        for (Card aHand : hand)
        {
            dealerHandString += aHand.toString();
        }
        System.out.println("Dealer's hand: ");
        System.out.print(dealerHandString);
    }

    private void getUpcardValue()
    {
        List<Card> dealerHand = dealer.getHand();
        Card upcard = dealerHand.get(0);
        int upcardValue = upcard.getValue();
        System.out.println("\tTotal: " + upcardValue + "\n");
    }

    private void calculateDealerHandValue()
    {
        handValue = 0;
        List<Card> hand = dealer.getHand();
        for (Card aCard : hand)
        {
            handValue += aCard.getValue();
        }
        dealer.setHandValue(handValue);
        System.out.println("\tTotal: " + dealer.getHandValue() + "\n");
    }

    private void calculatePlayerHandValue(Player aPlayer)
    {
        handValue = 0;
        List<Card> hand = aPlayer.getHand();
        for (Card aCard : hand)
            {
                handValue += aCard.getValue();
            }
        aPlayer.setHandValue(handValue);
        System.out.println("\tTotal: " + handValue + "\n");
    }

    public void revealPlayersHand(Player aPlayer)
    {
        String playerHandString = "";
        List<Card> hand = aPlayer.getHand();
        for (Card aCard : hand)
        {
            playerHandString += aCard.toString();
        }
        System.out.println(aPlayer.getName() + "'s hand:");
        System.out.print(playerHandString);
    }

    public void hitOrStand(Player aPlayer)
    {
        System.out.print(aPlayer.getName() + ", hit (h) or stand (s): ");
        String hitOrStand = input.next();
        System.out.println("");
        if (hitOrStand.equals("h"))
        {
            hit(aPlayer);
        }
        else
        {
            aPlayer.setChoseHit(false);
        }
    }

    private void hit(Player aPlayer)
    {
        dealtCard = playingDeck.dealCard();
        aPlayer.addCard(dealtCard);
        aPlayer.setChoseHit(true);
    }

    private boolean didPlayerBust(Player aPlayer)
    {
        boolean bust = false;
        if (aPlayer.getHandValue() > BLACKJACK)
            bust = true;
        return bust;
    }

    private void winLossOrStand(Player aPlayer)
    {
        int bet = aPlayer.getBet();
        int dealerHandValue = dealer.getHandValue();
        String name = aPlayer.getName();
        handValue = aPlayer.getHandValue();
        int payout = bet;
        String message = "";

        if (dealerHandValue < BLACKJACK)
        {
            if (handValue > dealerHandValue && handValue <= BLACKJACK)
            {
                if (handValue == BLACKJACK)
                {
                    payout *= 2.5;
                    message = name + " hit blackjack and won $" + payout + "!";
                }
                else
                {
                    payout *= 2;
                    message = name + " won $" + payout + "!";
                }
            }
            else if (handValue == dealerHandValue)
            {
                payout *= 1;
                message = name + " pushed.";
            }
            else
            {
                payout = 0;
                message = name + " lost.";
            }
        }
        else if (dealerHandValue > BLACKJACK)
        {
                if (handValue < BLACKJACK)
                {
                    payout *= 2;
                    message = name + " won $" + payout + "!";
                }
                else if (handValue == BLACKJACK)
                {
                    payout *= 2.5;
                    message = name + " hit blackjack and won $" + payout + "!";
                }
                else // if (handValue > BLACKJACK)
                {
                    payout = 0;
                    message = name + " lost.";
                }
        }
        else if (dealerHandValue == BLACKJACK)
        {
            if (handValue == BLACKJACK)
            {
                payout *= 1;
                message = name + " pushed.";
            }
            else
            {
                payout = 0;
                message = name + " lost.";
            }
        }
        aPlayer.updateBankroll(payout);
        System.out.println(message + "\n");
    }
}
