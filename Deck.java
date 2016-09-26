package osborn.andrew.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck
{
    List<Card> cards;

    public Deck()
    {
        cards = new ArrayList<>();
    }

    public void fillDeck()
    {
        for (Suit suit : Suit.values())
        {
            for (Value value : Value.values())
            {
                cards.add(new Card(suit, value));
            }
        }
    }
}
