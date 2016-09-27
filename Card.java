package osborn.andrew.blackjack;

public class Card
{
    private String suit;
    private int value;
    private String valueStr;

    /**
     * Card constructor
     * @param suit suit of the card
     * @param value numerical value of the card
     * @param valueStr numerical value as a String
     */
    public Card(String suit, int value, String valueStr)
    {
        this.suit = suit;
        this.value = value;
        this.valueStr = valueStr;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return valueStr + " of " + suit;
    }
}
