package osborn.andrew.blackjack;

public enum Suit
{
    SPADE("Spade"),
    HEART("Heart"),
    CLUB("Club"),
    DIAMOND("Diamond");

    private String suit;

    Suit(String suit)
    {
        this.suit = suit;
    }
}
