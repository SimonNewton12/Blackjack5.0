package osborn.andrew.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer
{
    private List<Card> hand;
    private int handValue;

    public Dealer()
    {
        hand = new ArrayList<>();
    }

    public void addCard(Card card)
    {
        hand.add(card);
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

    public List<Card> getHand()
    {
        return hand;
    }
}
