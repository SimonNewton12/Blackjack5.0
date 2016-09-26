package osborn.andrew.blackjack;

public class Card
{
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    public String toString()
    {
        return value + " of " + suit;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public Value getValue()
    {
        return value;
    }
}
