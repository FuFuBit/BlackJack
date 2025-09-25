public class Card
{
    private String suit;
    private String face;
    private int value;

    public Card(String suit, String face, int value)
    {
        this.suit = suit;
        this.face = face;
        this.value = value;
    }

    public String toString()
    {
        return this.face + " of " + this.suit + " (" + this.value + ")";
    }

    public String getFace()
    {
        return this.face;
    }

    public int getValue()
    {
        return this.value;
    }
}