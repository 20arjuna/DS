/**
 * The Card class is a blueprint for a card which is used in the game
 * of Solitaire. A card has a rank (1-13), a suit (club, spade, heart, diamond),
 * and can be turned up or turned down. 
 * 
 * @author 20arjuna
 * @version 11.9.18
 *
 */
public class Card
{
    private int rank;
    private String suit;
    private boolean isFaceUp;
    
    /**
     * Creates a card object
     * 
     * @param r the rank of the card
     * @param s the suit of the card
     */
    public Card(int r, String s)
    {
        rank = r;
        suit= s;
        isFaceUp = false;
    }
    /**
     * Returns the rank of the card 
     * @return the rank of the card
     */
    public int getRank()
    {
        return rank;
    }
    /**
     * Returns the suit of the card
     * @return the suit of the card
     */
    public String getSuit()
    {
        return suit;
    }
    /**
     * Returns whether or not the card is red
     * @return true if the card is red; otherwise,
     *         false.
     */
    public boolean isRed()
    {
        if(suit.equals("d") || suit.equals("h"))
        {
            return true;
        }
        return false;
    }
    /**
     * Returns whether or not the card is faced up
     * @return true if the card is faced up; otherwise,
     *         false.
     */
    public boolean isFaceUp()
    {
        return isFaceUp;
    }
    /**
     * Turns the card up.
     */
    public void turnUp()
    {
        isFaceUp = true;
    }
    /**
     * Turns the card down.
     */
    public void turnDown()
    {
        isFaceUp = false;
    }
    /**
     * Retrieves the path of the card 
     * @return the path of the card 
     */
    public String getFileName()
    {
        if(!this.isFaceUp())
        {
            return "cards/back.gif";
        }
        String s = this.getSuit();
        int r = this.getRank();
        if(s.equals("c"))
        {
            if(r == 1)
            {
                return "cards/ac.gif";
            }
            if(r == 2)
            {
                return "cards/2c.gif";
            }
            if(r == 3)
            {
                return "cards/3c.gif";
            }
            if(r == 4)
            {
                return "cards/4c.gif";
            }
            if(r == 5)
            {
                return "cards/5c.gif";
            }
            if(r == 6)
            {
                return "cards/6c.gif";
            }
            if(r == 7)
            {
                return "cards/7c.gif";
            }
            if(r == 8)
            {
                return "cards/8c.gif";
            }
            if(r == 9)
            {
                return "cards/9c.gif";
            }
            if(r == 10)
            {
                return "cards/tc.gif";
            }
            if(r == 11)
            {
                return "cards/jc.gif";
            }
            if(r == 12)
            {
                return "cards/qc.gif";
            }
            if(r == 13)
            {
                return "cards/kc.gif";
            }
        }
        if(s.equals("s"))
        {
            if(r == 1)
            {
                return "cards/as.gif";
            }
            if(r == 2)
            {
                return "cards/2s.gif";
            }
            if(r == 3)
            {
                return "cards/3s.gif";
            }
            if(r == 4)
            {
                return "cards/4s.gif";
            }
            if(r == 5)
            {
                return "cards/5s.gif";
            }
            if(r == 6)
            {
                return "cards/6s.gif";
            }
            if(r == 7)
            {
                return "cards/7s.gif";
            }
            if(r == 8)
            {
                return "cards/8s.gif";
            }
            if(r == 9)
            {
                return "cards/9s.gif";
            }
            if(r == 10)
            {
                return "cards/ts.gif";
            }
            if(r == 11)
            {
                return "cards/js.gif";
            }
            if(r == 12)
            {
                return "cards/qs.gif";
            }
            if(r == 13)
            {
                return "cards/ks.gif";
            }
        }
        if(s.equals("h"))
        {
            if(r == 1)
            {
                return "cards/ah.gif";
            }
            if(r == 2)
            {
                return "cards/2h.gif";
            }
            if(r == 3)
            {
                return "cards/3h.gif";
            }
            if(r == 4)
            {
                return "cards/4h.gif";
            }
            if(r == 5)
            {
                return "cards/5h.gif";
            }
            if(r == 6)
            {
                return "cards/6h.gif";
            }
            if(r == 7)
            {
                return "cards/7h.gif";
            }
            if(r == 8)
            {
                return "cards/8h.gif";
            }
            if(r == 9)
            {
                return "cards/9h.gif";
            }
            if(r == 10)
            {
                return "cards/th.gif";
            }
            if(r == 11)
            {
                return "cards/jh.gif";
            }
            if(r == 12)
            {
                return "cards/qh.gif";
            }
            if(r == 13)
            {
                return "cards/kh.gif";
            }
        }
        if(s.equals("d"))
        {
            if(r == 1)
            {
                return "cards/ad.gif";
            }
            if(r == 2)
            {
                return "cards/2d.gif";
            }
            if(r == 3)
            {
                return "cards/3d.gif";
            }
            if(r == 4)
            {
                return "cards/4d.gif";
            }
            if(r == 5)
            {
                return "cards/5d.gif";
            }
            if(r == 6)
            {
                return "cards/6d.gif";
            }
            if(r == 7)
            {
                return "cards/7d.gif";
            }
            if(r == 8)
            {
                return "cards/8d.gif";
            }
            if(r == 9)
            {
                return "cards/9d.gif";
            }
            if(r == 10)
            {
                return "cards/td.gif";
            }
            if(r == 11)
            {
                return "cards/jd.gif";
            }
            if(r == 12)
            {
                return "cards/qd.gif";
            }
            if(r == 13)
            {
                return "cards/kd.gif";
            }
        }
        return null;
    }
    
}