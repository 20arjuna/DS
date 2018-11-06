import java.util.*;

public class Solitaire
{
	public static void main(String[] args)
	{
		new Solitaire();
	}

	private Stack<Card> stock;
	private Stack<Card> waste;
	private Stack<Card>[] foundations;
	private Stack<Card>[] piles;
	private SolitaireDisplay display;

	public Solitaire()
	{
		foundations = new Stack[4];
		
		piles = deal();
		
		stock = createStock();
		
		waste = new Stack();
		
		display = new SolitaireDisplay(this);
		
	}
	

	//returns the card on top of the stock,
	//or null if the stock is empty
	public Card getStockCard()
	{
	    if(stock.isEmpty())
	    {
	        return null;
	    }
		return stock.peek();
	}

	//returns the card on top of the waste,
	//or null if the waste is empty
	public Card getWasteCard()
	{
	    if(waste.isEmpty())
	    {
	        return null;
	    }
		return waste.peek();
	}

	//precondition:  0 <= index < 4
	//postcondition: returns the card on top of the given
	//               foundation, or null if the foundation
	//               is empty
	public Card getFoundationCard(int index)
	{
	   //foundations[index] = new Stack();
	   if(foundations[index] == null)
	   {
	       return null;
	   }
	   return foundations[index].peek();
	}

	//precondition:  0 <= index < 7
	//postcondition: returns a reference to the given pile
	public Stack<Card> getPile(int index)
	{
	    return piles[index];
	}
	
	public Stack<Card> createStock()
	{
	    ArrayList<Card> deck = new ArrayList<Card>();
	    Stack<Card> s = new Stack();
	    for(int i = 1; i <= 13; i++)
	    {
	        deck.add(new Card(i, "c"));
	    }
	    for(int i = 1; i <= 13; i++)
        {
            deck.add(new Card(i, "d"));
        }
	    for(int i = 1; i <= 13; i++)
        {
            deck.add(new Card(i, "h"));
        }
	    for(int i = 1; i <= 13; i++)
        {
            deck.add(new Card(i, "s"));
        }
	    
	    while(deck.size()>0)
	    {
	        int rand = (int)(Math.random() * deck.size());
	        System.out.println("random: " + rand + "size: " + deck.size());
	        Card temp1 = deck.remove(rand);
	        System.out.println("storing in temp");
	        s.push(temp1);
	        System.out.println("pushing");
	    }
	    System.out.println("done");
	    return s;
	    
	}
	public Stack<Card>[] deal()
	{
	   Stack<Card>[] p = new Stack[7];
	    for(int i =0; i < p.length; i++)
	    {
	        for(int j = 0; j < 7; j++)
	        {
	            p[i].push(stock.pop());
	        }
	        p[i].peek().turnUp();
	    }
	    return p;
	    
	}
	//called when the stock is clicked
	public void stockClicked()
	{
		//IMPLEMENT ME
		System.out.println("stock clicked");
	}

	//called when the waste is clicked
	public void wasteClicked()
	{
		//IMPLEMENT ME
		System.out.println("waste clicked");
	}

	//precondition:  0 <= index < 4
	//called when given foundation is clicked 
	public void foundationClicked(int index)
	{
		//IMPLEMENT ME
		System.out.println("foundation #" + index + " clicked");
	}

	//precondition:  0 <= index < 7
	//called when given pile is clicked
	public void pileClicked(int index)
	{
		//IMPLEMENT ME
		System.out.println("pile #" + index + " clicked");
	}
}