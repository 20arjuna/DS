import java.util.Iterator;
import java.util.ListIterator;

/**
 * MyLinkedList<E> is a blueprint 
 * @author 20arjuna
 *
 * @param <E>
 */
public class MyLinkedList<E>
{
	private DoubleNode first;
	private DoubleNode last;
	private int size;

	public MyLinkedList()
	{
		first = null;
		last = null;
		size = 0;
	}

	public String toString()
	{
		DoubleNode node = first;
		if (node == null)
			return "[]";
		String s = "[";
		while (node.getNext() != null)
		{
			s += node.getValue() + ", ";
			node = node.getNext();
		}
		return s + node.getValue() + "]";
	}

	/** 
	* @precondition  0 <= index <= size / 2
	* @postcondition starting from first, returns the node
	*               with given index (where index 0
	*                returns first)
	*/              
	private DoubleNode getNodeFromFirst(int index)
	{ 
	    DoubleNode temp = first;
	   for(int i = 0; i < index; i ++)
	   {
	       temp = temp.getNext();
	   }
	   return temp;
	   
	}

	/** 
	* @precondition  size / 2 <= index < size
	* @postcondition starting from last, returns the node
	*               with given index (where index size-1
	*               returns last)
	*/               
	private DoubleNode getNodeFromLast(int index)
	{
	    DoubleNode temp = first;
	       for(int i = 0; i < index; i ++)
	       {
	           temp = temp.getPrevious();
	       }
	       return temp;
	}

	/** 
	* @precondition  0 <= index < size
	* @postcondition starting from first or last (whichever
	*               is closer), returns the node with given
	*               index
	*/               
	private DoubleNode getNode(int index)
	{
		int half = size / 2;
		if(index < half)
		{
		    return this.getNodeFromFirst(index);
		}
		return this.getNodeFromLast(index);
	}

	public int size()
	{
		return size;
	}

	public E get(int index)
	{
		return (E) this.getNode(index).getValue();

		//(You will need to promise the return value is of type E.)
	}

	/** 
	* @postcondition replaces the element at position index with obj
	               returns the element formerly at the specified position
	*/
	public E set(int index, E obj)
	{
		E temp = this.get(index);
		this.getNode(index).setValue(obj);
		return temp;

		//(You will need to promise the return value is of type E.)
	}

	/**
	* @postcondition appends obj to end of list; returns true
	*/
	public boolean add(E obj)
	{
	    size ++;
		DoubleNode temp = last;
		temp.getPrevious().setNext(new DoubleNode(obj));
		return true;
		
	}

	/** 
	* @postcondition removes element from position index, moving elements
	*               at position index + 1 and higher to the left
	*               (subtracts 1 from their indices) and adjusts size
	               returns the element formerly at the specified position
	*/
	public E remove(int index)
	{
	    DoubleNode temp = this.getNode(index);
		DoubleNode temp1 = this.getNode(index-1);
	    DoubleNode temp2 = this.getNode(index+1);
	    temp1.setNext(temp2);
	    temp2.setPrevious(temp1);
	    E val = (E) temp.getValue();
	    temp.setNext(null);
	    temp.setPrevious(null);
	    size--;
	    return val;
	    


		//(You will need to promise the return value is of type E.)
	}

	/** 
	* @precondition  0 <= index <= size
	* @postcondition inserts obj at position index,
	*                moving elements at position index and higher
	*                to the right (adds 1 to their indices) and adjusts size
	*/
	public void add(int index, E obj)
	{
		DoubleNode temp = this.getNode(index -1);
		temp.setNext(new DoubleNode(obj));
		temp.getNext().setPrevious(temp);
		temp.getNext().getNext().setPrevious(temp.getNext());
		temp.getNext().setNext(temp.getNext().getNext());
		size++;
	}

	public void addFirst(E obj)
	{
	    size++;
		first = new DoubleNode(obj);
		
	}

	public void addLast(E obj)
	{
	    this.add(obj);
	}

	public E getFirst()
	{
		return (E) first.getValue();
	}

	public E getLast()
	{
		return (E) last.getValue();

		//(You will need to promise the return value is of type E.)
	}

	public E removeFirst()
	{
		E temp = this.getFirst();
		first.setPrevious(first.getNext());
		return temp;
		//(You will need to promise the return value is of type E.)
	}

	public E removeLast()
	{
	    E val = this.getLast();
	    DoubleNode temp = this.getNode(size - 2);
	    temp.setNext(null);
	    return val;
		

		//(You will need to promise the return value is of type E.)
	}

	public Iterator<E> iterator()
	{
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<E>
	{
		private DoubleNode nextNode;

		public MyLinkedListIterator()
		{
			nextNode = first;
		}

		public boolean hasNext()
		{
			if(nextNode.getNext()!=null)
			{
			    return true;
			}
			return false;
		}

		public E next()
		{
		    E temp = (E)nextNode.getValue();
			nextNode = nextNode.getNext();
			return temp;

		}

		//@postcondition removes the last element that was returned by next
		public void remove()
		{
		   DoubleNode temp = nextNode.getPrevious();
		   int index = 0;
		   for(int i = 0; i < size; i ++)
		   {
		       if (getNode(i).equals(temp))
		       {
		           index = i;
		       }
		   }
		   MyLinkedList.this.remove(index);
		   
		}
	}
}