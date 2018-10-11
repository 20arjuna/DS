import java.util.Iterator;

/**
 * The MyArrayList<E> class stores objects in a sequential list and allows for
 * those objects to be accessed at any time. The MyArrayList<E> class can store
 * all objects, including null. The MyArrayList<E> is expandable and adjust its
 * length depending on how many objects it is being asked to store.
 * 
 * @author Arjun Akkiraju
 * @version 10.10.18
 * @param <E>
 *            The object type that the MyArrayList will store
 */
public class MyArrayList<E>
{
    private int size;
    private Object[] values;
    /**
     * Constructs a MyArrayList object by creating a new array of objects to store
     * the values of the MyArrayList, and sets its size to 0.
     */
    public MyArrayList()
    {
        size = 0;
        values = new Object[1];
    }

    /**
     * Converts the MyArrayList object to string form by listing the elements in a
     * comma separated list surrounded by square brackets.
     * 
     * @return the formatted list of the contents in the MyArrayList
     */
    @Override
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
     * Doubles the size of the array being used to store the elements of the
     * MyArrayList.
     * 
     * @postcondition replaces the array with one that is twice as long, and copies
     *                all of the old elements into it
     */
    private void doubleCapacity()
    {
        Object[] temp = new Object[size];
        for (int i = 0; i < values.length; i++)
        {
            temp[i] = values[i];
        }
        values = new Object[size * 2];
        for (int i = 0; i < temp.length; i++)
        {
            values[i] = temp[i];
        }
    }

    /**
     * Returns the size of the array being used to store the elements in the
     * MyArrayList.
     * 
     * @return the size of the array which stores the contents of the MyArrayList
     * @postcondition returns the length of the array
     */
    public int getCapacity()
    {
        return values.length;
    }

    /**
     * Returns the number of elements in the MyArrayList
     * 
     * @return the number of elements in the MyArrayList
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns the element stored in the MyArrayList at a specified index.
     * 
     * @param index
     *            The specified index where the desired object is stored.
     * @return The object at the specified index in the MyArrayList
     */
    public E get(int index)
    {
        return (E) values[index];

        // (You will need to promise the return value is of type E.)
    }

    /**
     * Changes the object at a certain index to a new object and returns the
     * previous object
     * 
     * @param index
     *            The specified index where the object is being changed.
     * @param obj
     *            The new object which replaces the object at the specified index.
     * @return    The object which was previously occupying index.
     * @postcondition replaces the element at position index with obj returns the
     *                element formerly at the specified position
     */
    public E set(int index, E obj)
    {
        E temp = this.get(index);
        values[index] = obj;
        return temp;

        // (You will need to promise the return value is of type E.)
    }

    /**
     * Adds the specified object to the back of the MyArrayList
     * 
     * @param obj
     *            The object being appended to the back of the MyArrayList
     * @return true Always
     * @postcondition appends obj to end of list; returns true
     */
    public boolean add(E obj)
    {
        if (this.getCapacity() == this.size())
        {
            this.doubleCapacity();
        }
        values[size] = obj;
        size++;
        return true;
    }

    /**
     * Removes the element in the MyArrayList at the specified index
     * 
     * @param index
     *            The index which the object will be removed from
     * @return The object which was removed.
     * @postcondition removes element from position index, moving elements at
     *                position index + 1 and higher to the left (subtracts 1 from
     *                their indices) and adjusts size returns the element formerly
     *                at the specified position
     */
    public E remove(int index)
    {
        E temp = this.get(index);
        for (int i = index; i < size - 1; i++)
        {
            values[i] = values[i + 1];
            values[i + 1] = 0;
        }

        size--;
        return temp;
    }

    /**
     * Provides access to an iterator for the MyArrayList.
     * 
     * @return a new MyArrayListIterator object.
     */
    public Iterator<E> iterator()
    {
        return new MyArrayListIterator();
    }

    /**
     * Adds the specified object to the MyArrayList at a specified index.
     * 
     * @param index
     *            The index at which the specified object will be added.
     * @param obj
     *            The specified object which is to be added to the MyArrayList
     * @precondition 0 <= index <= size
     * @postcondition inserts obj at position index, moving elements at position
     *                index and higher to the right (adds 1 to their indices) and
     *                adjusts size
     */
    public void add(int index, E obj)
    {
        for (int i = index; i < size; i++)
        {
            values[i + 1] = values[i];
        }
        values[index] = obj;
        size++;

    }

    /**
     * The MyArrayListIterator is a type of Iterator which iterates through the
     * MyArrayList object, performing basic operations like adding and removing
     * objects to the MyArrayList efficiently.
     * 
     * @author 20arjuna
     * @version 10.10.18
     */
    private class MyArrayListIterator implements Iterator<E>
    {
        // the index of the value that will be returned by next()

        private int nextIndex;

        /**
         * Creates a new MyArrayListIterator.
         */
        public MyArrayListIterator()
        {
            nextIndex = 0;
        }

        /**
         * Determines if the MyArrayList object that the MyArrayListIterator is
         * iterating through has another element behind the element that the
         * MyArrayListIterator is currently pointing to.
         * 
         * @return true if the MyArrayList object has another element behind the index
         *         that the MyArrayList iterator is pointing to; otherwise, false
         */
        @Override
        public boolean hasNext()
        {
            if (nextIndex < size)
            {
                return true;
            }
            return false;
        }

        /**
         * Returns the element which is at the index behind the index that the
         * MyArrayListIterator is pointing to.
         * 
         * @return the element which is at the index behind the index that the
         *         MyArrayListIterator is pointing to.
         */
        @Override
        public E next()
        {
            int temp = nextIndex;
            nextIndex++;
            return (E) values[temp];
        }

        /**
         * Removes the element returned by the next() method.
         * 
         * @postcondition removes the last element that was returned by next
         */
        @Override
        public void remove()
        {
            MyArrayList.this.remove(nextIndex - 1);
        }
    }
}
