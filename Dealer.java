package osborn.andrew.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer
{
    private List<Card> hand;

    public Dealer()
    {
        hand = new ArrayList<>();
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }

    public List<Card> getHand()
    {
        return hand;
    }
}
