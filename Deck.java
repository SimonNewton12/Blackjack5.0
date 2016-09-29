package osborn.andrew.blackjack;

import java.util.*;

public class Deck
{
    private List<Card> cards;
    private Card topCard;

    public Deck()
    {
        cards = new ArrayList<>();
    }

    /**
     * createFullDeck(int numDecks) creates a stack of cards with the amount of decks
     * specified by the user
     *
     * @param numDecks number of decks to use in stack of cards
     */
    public void createFullDeck(int numDecks)
    {
        for (int i = 0; i < numDecks; i++)
        {
            for (Suit suit : Suit.values())
            {
                for (Value value : Value.values())
                {
                    cards.add(new Card(suit.getSuit(), value.getValue(), value.getValueStr()));
                }
            }
        }
    }

    // shuffles List<Card> cards via Collections.shuffle()
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * dealCard() selects the card at the top of the deck, removes it from the deck,
     * and returns it as a Card object
     *
     * @return the dealt card
     */
    public Card dealCard()
    {
        topCard = cards.get(0);
        removeCard();
        return topCard;
    }

    // removes card from deck
    public void removeCard()
    {
            cards.remove(topCard);
    }
}
