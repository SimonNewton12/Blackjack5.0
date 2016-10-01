package osborn.andrew.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private String name;
    private int bankroll;
    private List<Card> hand;
    private int handValue;
    private int bet;
    private boolean choseHit = false;

    /**
     * Player constructor creates a new player, sets his or her name and bankroll, and adds the player
     * to List<Player> players
     *
     * @param name sets player's name
     * @param bankroll sets player's bankroll
     */
    public Player(String name, int bankroll)
    {
        setName(name);
        setBankroll(bankroll);
        hand = new ArrayList<>();
        Database.addPlayer(this);
    }

    private void setBankroll(int bankroll)
    {
        this.bankroll = bankroll;
    }

    public int getBankroll()
    {
        return bankroll;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }

    public void setBet(int bet)
    {
        this.bet = bet;
    }

    public int getBet()
    {
        return bet;
    }

    // updates a player's bankroll after placing a bet
    public void updateBankroll()
    {
        this.bankroll -= bet;
    }

    public void updateBankroll(int payout)
    {
        this.bankroll += payout;
    }

    public List<Card> getHand()
    {
        return hand;
    }

    public void setChoseHit(boolean choseHit)
    {
        this.choseHit = choseHit;
    }

    public boolean getChoseHit()
    {
        return choseHit;
    }

    public void clearHand()
    {
        hand.clear();
    }

    public void setHandValue(int handValue)
    {
        this.handValue = handValue;
    }

    public int getHandValue()
    {
        return handValue;
    }

    public String toString()
    {
        return name + " - $" + bankroll + hand;
    }
}
