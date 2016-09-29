package osborn.andrew.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private String name;
    private int bankroll;
    private List<Card> hand;
    private int bet;

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

    public void updateBankroll(int bet)
    {
        this.bet -= bet;
    }

    public String toString()
    {
        return name + " - $" + bankroll + hand;
    }
}
