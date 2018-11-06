
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
    public String getFileName()
    {
        if(!this.isFaceUp())
        {
            return "/Users/20arjuna/Desktop/DS/Solitaire/cards/back.gif";
        }
        String suit = this.getSuit();
        int rank = this.getRank();
        if(suit.equals("c"))
        {
            if(rank == 1)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/ac.gif";
            }
            if(rank == 2)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/2c.gif";
            }
            if(rank == 3)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/3c.gif";
            }
            if(rank == 4)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/4c.gif";
            }
            if(rank == 5)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/5c.gif";
            }
            if(rank == 6)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/6c.gif";
            }
            if(rank == 7)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/7c.gif";
            }
            if(rank == 8)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/8c.gif";
            }
            if(rank == 9)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/9c.gif";
            }
            if(rank == 10)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/tc.gif";
            }
            if(rank == 11)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/jc.gif";
            }
            if(rank == 12)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/qc.gif";
            }
            if(rank == 13)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/kc.gif";
            }
        }
        if(suit.equals("s"))
        {
            if(rank == 1)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/as.gif";
            }
            if(rank == 2)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/2s.gif";
            }
            if(rank == 3)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/3s.gif";
            }
            if(rank == 4)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/4s.gif";
            }
            if(rank == 5)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/5s.gif";
            }
            if(rank == 6)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/6s.gif";
            }
            if(rank == 7)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/7s.gif";
            }
            if(rank == 8)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/8s.gif";
            }
            if(rank == 9)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/9s.gif";
            }
            if(rank == 10)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/ts.gif";
            }
            if(rank == 11)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/js.gif";
            }
            if(rank == 12)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/qs.gif";
            }
            if(rank == 13)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/ks.gif";
            }
        }
        if(suit.equals("h"))
        {
            if(rank == 1)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/ah.gif";
            }
            if(rank == 2)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/2h.gif";
            }
            if(rank == 3)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/3h.gif";
            }
            if(rank == 4)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/4h.gif";
            }
            if(rank == 5)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/5h.gif";
            }
            if(rank == 6)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/6h.gif";
            }
            if(rank == 7)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/7h.gif";
            }
            if(rank == 8)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/8h.gif";
            }
            if(rank == 9)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/9h.gif";
            }
            if(rank == 10)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/th.gif";
            }
            if(rank == 11)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/jh.gif";
            }
            if(rank == 12)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/qh.gif";
            }
            if(rank == 13)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/kh.gif";
            }
        }
        if(suit.equals("d"))
        {
            if(rank == 1)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/ad.gif";
            }
            if(rank == 2)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/2d.gif";
            }
            if(rank == 3)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/3d.gif";
            }
            if(rank == 4)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/4d.gif";
            }
            if(rank == 5)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/5d.gif";
            }
            if(rank == 6)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/6d.gif";
            }
            if(rank == 7)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/7d.gif";
            }
            if(rank == 8)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/8d.gif";
            }
            if(rank == 9)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/9d.gif";
            }
            if(rank == 10)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/td.gif";
            }
            if(rank == 11)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/jd.gif";
            }
            if(rank == 12)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/qd.gif";
            }
            if(rank == 13)
            {
                return "/Users/20arjuna/Desktop/DS/Solitaire/cards/kd.gif";
            }
        }
        throw new RuntimeException("invalid card");
    }
    
}