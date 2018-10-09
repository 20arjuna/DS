import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<E>
{
	private int size;
	private Object[] values;  //(Java doesn't let us make an array of type E)

	public MyArrayList()
	{
		size = 0;
		values = new Object[1];
	}

	public String toString()
	{
		if (size == 0)
			return "[]";

		String s = "[";
		for (int i = 0; i < size - 1; i++)
			s += values[i] + ", ";
		return s + values[size - 1] + "]";
	}

	/**
	* @postcondition replaces the array with one that is
	*               twice as long, and copies all of the
	*               old elements into it
	*/
	private void doubleCapacity()
	{
		Object [] temp = new Object [size];
		for (int i = 0; i < values.length; i ++)
		{
			temp[i] = values[i];
		}
		values = new Object [size * 2];
		for (int i = 0; i < temp.length; i++)
		{
			values[i] = temp[i];
		}
	}

	/**
	* @postcondition returns the length of the array
	*/
	public int getCapacity()
	{
		return values.length;
	}

	public int size()
	{
		return size;
	}

	public E get(int index)
	{
		return (E) values[index];

		//(You will need to promise the return value is of type E.)
	}

	/** 
	* @postcondition replaces the element at position index with obj
	*               returns the element formerly at the specified position
	*/
	public E set(int index, E obj)
	{
		values[index] = obj;
		return this.get(index);

		//(You will need to promise the return value is of type E.)
	}

	/**
	* @postcondition appends obj to end of list; returns true
	*/
	public boolean add(E obj)
	{
		if(this.getCapacity() == this.size())
		{
			this.doubleCapacity();
		}
		values[size] = obj;
		return true;
	}

	/**
	* @postcondition removes element from position index, moving elements
	*               at position index + 1 and higher to the left
	*               (subtracts 1 from their indices) and adjusts size
	*               returns the element formerly at the specified position
	*/
	public E remove(int index)
	{
		for(int i = index+1; i <=size; i++)
		{
			values[i-1] = values[i];
		}
		size--;
		return this.get(index);
	}

	public Iterator<E> iterator()
	{
		return new MyArrayListIterator();
	}

	/**
	* @precondition  0 <= index <= size
	* @postcondition inserts obj at position index,
	*               moving elements at position index and higher
	*               to the right (adds 1 to their indices) and adjusts size
	*/
	public void add(int index, E obj)
	{
		for(int i = index; i <size; i++)
		{
			values[i+1] = values[i];
		}
		values[index] = obj;
		size++;
		
	}

	private class MyArrayListIterator implements Iterator<E>
	{
		//the index of the value that will be returned by next()
		private int nextIndex;

		public MyArrayListIterator()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");
		}

		public boolean hasNext()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");
		}

		public E next()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");

			//(You will need to promise the return value is of type E.)
		}

		//@postcondition removes the last element that was returned by next
		public void remove()
		{
			throw new RuntimeException("INSERT MISSING CODE HERE");
		}
	}
}