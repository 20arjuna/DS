import java.util.*;
/**
 * The Solitaire class is a blueprint for the solitaire game, a one player card
 * game which consists of 4 important piles, the stock, the waste, the foundations,
 * and the piles. The object of the game is to fill the foundations with all the 
 * playing cards. Cards are distributed across the 7 piles with each subsequent pile
 * containing one more card than the pile to its left. The first card in the pile is face
 * up while the others are face down. From the piles, players must distribute all the cards
 * to the foundations by utilizing cards from both the stock, and the waste.
 * 
 * @author 20arjuna
 * @version 11.9.18
 */
public class Solitaire
{
    /**
     * Oversees the running of the solitaire game
     * @param args Arguments from the command line
     */
    public static void main(String[] args)
	{
		new Solitaire();
	}
    
	private Stack<Card> stock;
	private Stack<Card> waste;
	private Stack<Card>[] foundations;
	private Stack<Card>[] piles;
	private SolitaireDisplay display;

	/**
	 * Constructs a new solitaire game by creating the foundations,
	 * waste, piles, and the stock. Also sets up the display and deals
	 * cards and resets the stock to start the game. 
	 */
	public Solitaire()
	{
		foundations = new Stack[4];
		for(int i = 0; i < foundations.length; i++)
		{
		    foundations[i] = new Stack<Card>();
		}
		
		piles = new Stack[7];
		for(int j = 0; j < piles.length; j++)
        {
            piles[j] = new Stack<Card>();
        }
		
		stock = new Stack<Card>();
		
		waste = new Stack();
		
		
		createStock();
		deal();
		dealThreeCards();
		resetStock();
		display = new SolitaireDisplay(this);
		
	}
	
	/**
	 * Gets the card on top of the stock 
	 * @return the card on top of the stock, or null if 
	 *         the stock is empty. 
	 */
	public Card getStockCard()
	{
	    if(stock.isEmpty())
	    {
	        return null;
	    }
		return stock.peek();
	}
	/**
	 * Gets the card on top of the waste
	 * @return the card on top of the waste, or null if
	 *         the waste is empty
	 */
	public Card getWasteCard()
	{
	    if(waste.isEmpty())
	    {
	        return null;
	    }
		return waste.peek();
	}
	/**
	 * Gets the card on top of the foundation at the specified index
	 * 
	 * @param index the index of the foundation from which the card on top is returned
	 * @return the card on top of the given foundation, or null if the foundation is empty
	 * @precondition:  0 <= index < 4
     * @postcondition: returns the card on top of the given
     *                 foundation, or null if the foundation
     *                 is empty
	 */
	public Card getFoundationCard(int index)
	{
	   if(foundations[index].isEmpty())
	   {
	       return null;
	   }
	   return foundations[index].peek();
	}
	/**
	 * Gets the reference to the specified pile
	 * @param index The index of the pile whose reference is to be returned
	 * @return a reference to the given pile
	 * 
	 * @precondition:  0 <= index < 7
     * @postcondition: returns a reference to the given pile
	 */
	public Stack<Card> getPile(int index)
	{
	    return piles[index];
	}
	/**
	 * Creates the stock by dealing all 52 cards from the deck and 
	 * shuffling the cards in a random order. 
	 */
	private void createStock()
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
	        
	        Card temp1 = deck.remove(rand);
	        
	        s.push(temp1);
	        
	    }
	    
	    stock = s;
	    
	}
	/**
	 * Deals the shuffled cards from the stock to the 7 piles with the first
	 * pile having 1 card, the second pile having 2 cards, etc until the last pile
	 * has 7 cards.  
	 */
	private void deal()
	{
	   //Stack<Card>[] p = new Stack[7];
	   int x = 1;
	    for(int i =0; i < piles.length; i++)
	    {
	        for(int j = 0; j < x; j++)
	        {
	           //System.out.println("in while");
	            piles[i].push(stock.pop());
	           
	           
	        }
	        x++;
	        piles[i].peek().turnUp();
	        
	    } 
	}
	/**
	 * Deals three cards from the stock to the waste. If the stock has
	 * less than three cards remaining, all the cards on the stock are 
	 * added to the waste.
	 */
	private void dealThreeCards()
	{
	    for(int i=0; i < 3; i ++)
	    {
	       if(stock.isEmpty())
	       {
	           return ;
	       }
	       waste.push(stock.pop());
	       waste.peek().turnUp();
	       
	    }
	   
	}
	/**
	 * Resets the stock by adding all the cards from the
	 * waste back to the stock. 
	 */
	private void resetStock()
	{
	    while(!waste.isEmpty())
	    {
	        stock.push(waste.pop());
	        stock.peek().turnDown();
	    }
	}
	/**
	 * Determines whether or not it is possible to add the specified
	 * card to the pile at the specified index based on the rules of 
	 * solitaire. These rules are that only Kings can be added to an empty
	 * pile, a card with the opposite color of the top card on the specified pile
	 * and a rank which is one less than the rank of the top card can be added to the
	 * pile at the specified index, and that no card can be placed on a pile wit its 
	 * top card facing down.  
	 * 
	 * @param card The card in question.
	 * @param index The index of the pile which the card wants to be added. 
	 * @return true if the specified card can be added to the pile at the 
	 *         given index, otherwise, false
	 */
	private boolean canAddToPile(Card card, int index)
	{
	    if(piles[index].isEmpty() && card.getRank() == 13)
	    {
	        return true;
	    }
	    Card pileTop = piles[index].peek();
	    if(pileTop.isFaceUp() && ((pileTop.getRank() - card.getRank()) == 1) && (pileTop.isRed() != card.isRed()))
	    {
	        return true;
	    }
	    return false;
	    
	    
	}
	/**
	 * Removes all the face up cards on the top of the given pile.
	 * 
	 * @param index The pile which the face up cards are being removed
	 * @return A stack containing the face up cards.
	 * @precondition 0 <= index < 7
	 * @postcondition: Removes all face-up cards on the top of
     *                 the given pile; returns a stack
     *                 containing these cards
	 */
	private Stack<Card> removeFaceUpCards(int index)
    {
	     
	     Stack<Card> allUp = new Stack<Card>();
	     if(piles[index].peek().isFaceUp())
	     {
	         allUp.push(piles[index].pop());
	     }
	     return allUp;
	}
	/**
	 * Adds the specified stack of cards to the pile at the specified index.
	 * 
	 * @param cards The stack of cards which is being added at the specified index.
	 * @param index The index of the pile which the addition is taking place.
	 * @precondition:  0 <= index < 7
     * @postcondition: Removes elements from cards, and adds
     *              them to the given pile.
	 */
	
	private void addToPile(Stack<Card> cards, int index) 
	{
	    
	    while(!cards.isEmpty())
	    {
	        piles[index].push(cards.pop());
	    }
	}
	
	/** 
	 * Determines whether or not the specified card can be added to the foundation
	 * at the specified index based on the rules of solitaire. The rules are that only aces
	 * can be added to the foundation if the foundation is empty, and that cards placed on top
	 * of a foundation must be of the same suit and must have a rank one higher than the rank of
	 * the card previously on top of the foundation.
	 * 
	 * @param card
	 * @param index
	 * @return true if the specified card can be added to the pile at the
	 *         given index; otherwise, false.
     * @precondition:  0 <= index < 4
     * @postcondition: Returns true if the given card can be
     *                 legally moved to the top of the given
     *                 foundation
	 */
    private boolean canAddToFoundation(Card card, int index)
    {
        if(foundations[index].isEmpty() && card.getRank() == 1)
        {
            return true;
        }
        String topSuit = foundations[index].peek().getSuit();
        int topRank = foundations[index].peek().getRank();
        
        String cardSuit = card.getSuit();
        int cardRank = card.getRank();        
        if((topRank - cardRank) == -1 && topSuit.equals(cardSuit))
        {
            return true;
        }
        return false;
        
    }
    /**
     * Deals three cards or resets depending on the number of cards
     * currently in the stock when the stock is clicked. 
     */
	public void stockClicked()
	{
	    if(!display.isWasteSelected() && !display.isPileSelected())
	    {
	        if(stock.isEmpty())
	        {
	            resetStock();
	        }
	        else
	        {
	            dealThreeCards();
	        }
	        
	        System.out.println("Cards left in the stock: " + stock.size());
	    }
		
	}

	/**
	 * Selects the waste when the waste is clicked for the first time and then unselects
	 * it after it has already been selected. 
	 */
	public void wasteClicked()
	{
	    boolean wasteSelected = display.isWasteSelected();
		if(!waste.isEmpty() && (!display.isWasteSelected() && !display.isPileSelected()))
		{
		    
		    display.selectWaste();
		}
		if(wasteSelected)
		{
		    
		    display.unselect();
		}
		
		
	    
	}
	
	/**
	 * Selects the foundation if nothing else is selected. If something else is selected,
	 * that card is added to the foundation if it passes the solitaire rules for adding to 
	 * the foundations. 
	 * @param index
	 */
	public void foundationClicked(int index)
	{
	    Card card = null;
	    if(display.isPileSelected())
	    {
	        card = piles[display.selectedPile()].peek();
	        if(canAddToFoundation(card, index))
	        {
	            foundations[index].push(piles[display.selectedPile()].pop());
	        }
	    }
	    else if(display.isWasteSelected())
	    {
	        card = waste.peek();
	        foundations[index].push(waste.pop());
	    }
	    display.unselect();
		
		System.out.println("foundation #" + index + " clicked");
	}

	/**
	 * Selects the pile at the specified index if nothing else is selected. 
	 * If this is not the case then the selected card will attempt to transfer
	 * to the pile at the specified index based on the solitaire rules. 
	 * 
	 * @param index The index of the pile where the action is being performed
	 * @precondition:  0 <= index < 7
     * @called when given pile is clicked
	 */
	
	public void pileClicked(int index)
	{
	    boolean pileSelected = display.isPileSelected();
	    int selected = display.selectedPile();
	    if(!display.isPileSelected() && !display.isWasteSelected())
	    {
	        display.selectPile(index);
	        selected = display.selectedPile();
	        System.out.println("Selected: " + selected);
	    }
	    
	    if(pileSelected)
	    {
	        display.unselect();
	    }
		if(display.isWasteSelected())
		{
		    if(canAddToPile(waste.peek(), index))
		    {
		        piles[index].push(waste.pop());
	            display.unselect();
		    }
		    else
		    {
		        System.out.println("move not valid");
		    }
		    
		}
		
		if(selected != index && selected !=-1)
		{
		    System.out.println("Selected: " + selected);
		    System.out.println("index: " + index);
		    Stack<Card> inTransit = removeFaceUpCards(selected);
		    
            while(!inTransit.isEmpty())
            {
                if(this.canAddToPile(inTransit.peek(), index))
                {
                   
                    addToPile(inTransit, index);
                }
                else
                {
                    addToPile(inTransit, selected);
                    
                }
            }
            display.unselect();
		}
		if(piles[index].peek().isFaceUp() == false)
		{
		    piles[index].peek().turnUp();
		    display.unselect();
		}
		
		    
		
		
	}
}