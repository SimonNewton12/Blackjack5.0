package osborn.andrew.blackjack;

public enum Value
{
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(10, "Jack"),
    QUEEN(10, "Queen"),
    KING(10, "King"),
    ACE(1, "Ace");

    private int value;
    private String valueStr;

    Value(int value, String valueStr)
    {
        this.value = value;
        this.valueStr = valueStr;
    }

    public int getValue()
    {
        return value;
    }

    public String getValueStr()
    {
        return valueStr;
    }
}
