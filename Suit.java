package osborn.andrew.blackjack;

public enum Suit
{
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    SPADES("Spades"),
    HEARTS("Hearts");

    private String suit;

    Suit(String suit)
    {
        this.suit = suit;
    }

    public String getSuit()
    {
        return suit;
    }
}
