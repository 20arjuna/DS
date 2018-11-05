
public class Card
{
    private int rank;
    private String suit;
    private boolean isFaceUp;
    
    public Card(int r, String s)
    {
        rank = r;
        s = suit;
        isFaceUp = false;
    }
    public int getRank()
    {
        return rank;
    }
    public String getSuit()
    {
        return suit;
    }
    public boolean isRed()
    {
        if(suit.equals("d") || suit.equals("h"))
        {
            return true;
        }
        return false;
    }
    public boolean isFaceUp()
    {
        return isFaceUp;
    }
    public void turnUp()
    {
        isFaceUp = true;
    }
    public void turnDown()
    {
        isFaceUp = false;
    }
    
}