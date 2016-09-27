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
     * suggested by the user
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
     * dealCard(int numCardsToDeal) selects the card at the top of the deck, removes it from the deck,
     * and returns its contents as a string
     *
     * @param numCardsToDeal deals one or two cards, based on whether the card retrieval is in response to a
     *                       deal(2 cards) or a hit(1 card)
     * @return a list of the dealt cards is returned as a string
     */
    public String dealCard(int numCardsToDeal)
    {
        String topCardString = "";

        for (int x = 0; x < numCardsToDeal; x++)
        {
            topCard = cards.get(0);
            removeCard();

            // supports appending card contents when numCardsToDeal > 1
            topCardString += topCard.toString();
        }
        return topCardString;
    }

    // removes card from deck
    public void removeCard()
    {
            cards.remove(topCard);
    }
}
