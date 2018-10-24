import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
/**
 * The MyLinkedList class implements a linked list data structure
 * with nodes that can access the previous and next nodes. It 
 * includes several adding, removing, and setting functions for
 * MyLinkedList collections.
 *
 * @param <E> the type of object that can be in the linked list
 * @author  Arun Sundaresan
 * @version  October 17, 2018
 */
public class MyLinkedList<E>
{

    private DoubleNode first;
    private DoubleNode last;
    private int size;

    /**
     * Constructor for objects of the MyLinkedList class
     */
    public MyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Builds a Strign with the values held in the Linked List
     *
     * @return  a String with the values of the Linked List in 
     *          String form.
     */
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
     * Gets the node at the specified position, starting from 
     * the first node.
     *
     * @param index the position whose node to retrieve
     * @return the node at the specified position
     * @precondition  0 <= index <= size / 2
     * @postcondition the node at the specified position is 
     *                  returned, with the traversal starting 
     *                  from the first node.
     */
    private DoubleNode getNodeFromFirst(int index)
    {
        if (first == null || last == null)
        {
            return null;
        }
        else if (!(index >=0 && index < size))
        {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode traverse = first;
        for(int i = 0; i < index; i ++)
        {
            traverse = traverse.getNext();
        }
        return traverse;
       
    }

    /**
     * Gets the node at the specified position, starting from 
     * the first node.
     *
     * @param index the position whose node to retrieve
     * @return the node at the specified position
     * @precondition  0 <= index <= size / 2
     * @postcondition the node at the specified position is 
     *                  returned, with the traversal starting 
     *                  from the first node.
     */
    private DoubleNode getNodeFromLast(int index)
    {
        if (first == null || last == null)
        {
            return null;
        }
        else if (!(index >=0 && index < size))
        {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode last2 = last;
        int i = size - index - 1;
        while (i != 0)
        {
            last2 = last.getPrevious();
        }
        return last2 ;
    }

    /**
     * Retreives the node located at the specified position using
     * helper methods
     *
     * @param index the position whose node to retreive
     * @return the DoubleNode located at index
     * @precondition 0 <= index < size
     * @postcondition starting from the beginning or the end 
     *                  (whichever is closer), retrieves the node 
     *                  at the given index
     */
    private DoubleNode getNode(int index)
    {
        if (first == null || last == null)
        {
            return null;
        }
        else if (!(index >=0 && index < size))
        {
            throw new IndexOutOfBoundsException();
        }
        if (index >= 0 && index <= size / 2)
        {
            return getNodeFromFirst(index);
        }
        return getNodeFromLast(index);
    }

    /**
     * Retrieves the number of nodes in the Linked List
     *
     * @return the number of nodes in the Linked List
     */
    public int size()
    {
        return size;
    }

    /**
     * Retreives the value of the node at the given index
     *
     * @param index whose node's value to return
     * @return  the value of the node at the given index
     */
    public E get(int index)
    {
        return (E) getNode(index).getValue();
    }

    /**
     * Sets the value of the element at the given index to the given
     * value, and returns the value formerly at the modified element.
     *
     * @param index the index whose node to modify
     * @param obj the new value of the node at the given index
     *
     * @postcondition replaces the element at the given index
     *                  with the given element and returns the
     *                  element that was replaced
     * @return the element that was replaced
     */
    public E set(int index, E obj)
    {
        if (first == null || last == null)
        {
            return null;
        }
        else if (!(index >=0 && index < size))
        {
            throw new IndexOutOfBoundsException();
        }
        E prev = get(index);
        DoubleNode old = getNode(index);
        
        old.setValue(obj);
        return prev;
    }

    /**
     * Appends a node with the specified value to the end of the list.
     *
     * @param obj the value of the node to be added
     * @postcondition a node with the specified value is added to the
     *                  end of the list, increments the size, and 
     *                  returns true
     * @return  true
     */
    public boolean add(E obj)
    {
        size++;
        if (size == 0)
        {
            first = new DoubleNode(obj);
            last = first;
            
            return true;
        }
        if (size == 1)
        {
            last = new DoubleNode(obj);
            last.setNext(null);
            last.setPrevious(first);
            first.setNext(last);
            
            return true;
        }
        
        
       
        DoubleNode prevLast = getNode(size - 1);
        if (prevLast == null)
        {
            prevLast = new DoubleNode(obj);
            first = prevLast;
            last = first;
            return true;
        }
        prevLast.setNext(new DoubleNode(obj));
        DoubleNode newLast = prevLast.getNext();
        newLast.setNext(null);
        
        newLast.setPrevious(prevLast);
        
        
        last = newLast;
        return true;
    }

    /**
     * Removes the node at the given index, shifts all nodes after 
     * the given index one position to the left, and returns the value
     * of the node removed.
     *
     * @param index the index of the node to be removed
     * @postcondition removes the node from the given index, shifts
     *                  all nodes after the index to the left by one
     *                  position and returns the value of the node 
     *                  removed
     * @return the value of the node formerly at the given index
     */
    public E remove(int index)
    {
        if (first == null || last == null)
        {
            return null;
        }
        else if (!(index >=0 && index < size))
        {
            throw new IndexOutOfBoundsException();
        }
        
        
            DoubleNode temp = getNode(index);
            
        if (index == 0)
        {
            if (size == 1)
            {
                    first = null;
                    last = null;
            }
            else
            {
                first = first.getNext();
                first.setPrevious(null);
            }
        }
        else if (index == size - 1)
        {
            last = last.getPrevious();
            last.setNext(null);
        }
        else
        {
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }
        size--;
        return (E) temp.getValue();
    }

    /**
     * Adds a node with the given value at the specified index
     *
     * @param index the index to add a node at
     * @param obj the value of the node to be placed at the
     *              given index
     * @preconditions 0 <= index <= size
     * @postconditions inserts a node at the specified position, 
     *                  moving element at position index and higher 
     *                  to the right and increments the size
     */
    public void add(int index, E obj)
    {
        if (first == null || last == null)
        {
            return;
        }
        else if (!(index >=0 && index < size))
        {
            throw new IndexOutOfBoundsException();
        }     
        
        DoubleNode temp = new DoubleNode(obj);
        if (size == 0)
        {
            first = temp;
            last = temp;
            size++;
        }
        else
        {
            if (index == 0)
            {
                first.setPrevious(temp);
                temp.setNext(first);
                
                temp.setPrevious(null);
                first = temp;
                
                size++;
            }
            else if (index == size)
            {
                last.setNext(temp);
                temp.setNext(null);
                temp.setPrevious(last);
                last = temp;
                size++;
            }
            else
            {
                DoubleNode node = first;
                while (index != 0)
                {
                    node = node.getNext();
                    index--;
                }
                DoubleNode prevNode = node.getPrevious();
                prevNode.setNext(temp);
                
                node.setPrevious(temp);
                temp.setNext(node);
                
                
                temp.setPrevious(prevNode);
                size++;
            }
        }
    }

    /**
     * Adds an node with the specified value to the 
     * beginning of the list
     *
     * @param obj the value of the node to be added to the list
     * @preconditions 0 <= index <= size
     * @postcondition inserts a node with the specified value
     *                  at the beginning and increments size
     */
    public void addFirst(E obj)
    {
        DoubleNode newNode = new DoubleNode(obj);
        if (first == null || last == null)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            first.setPrevious(newNode);
            newNode.setNext(first);
            newNode.setPrevious(null);
            first = newNode;
        }
        size++;
    }

    /**
     * Adds a node with the sepcified value to the end of
     * the list.
     *
     * @param obj the value of the node to be added to the end
     * @preconditions 0 <= index <= size
     * @postcondition inserts node with the sepcified value to 
     *                  the end of the list, and increments the size
     */
    public void addLast(E obj)
    {
        DoubleNode newNode = new DoubleNode(obj);
        if (first == null || last == null)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            last.setNext(newNode);
            newNode.setNext(null);
            newNode.setPrevious(last);
            last = newNode;
        }
        size++;
    }

    /**
     * Retrieves the value of the first node of the list.
     *
     * @return the value of the first node of the list.
     */
    public E getFirst()
    {
        return (E) first.getValue();
    }

    /**
     * Retrieves the value of the last node of the list.
     *
     * @return the value of the last node of the list.
     */
    public E getLast()
    {
        return (E) last.getValue();
    }

    /**
     * Removes the first node of the list and returns its value
     * @return the value of the removed node
     * @postconditions the list's first node should be removed, its
     *                  value should be returned, all other nodes should
     *                  be shifted one position to the left, and the
     *                  size should be decremented               
     */
    public E removeFirst()
    {
        if (first != null)
        {
            if (first.getNext() == null)
            {
                DoubleNode oldFirst = first;
                first = null;
                last = null;
                size--;
                return (E) oldFirst;
            }
            DoubleNode oldFirst = first;
            first = first.getNext();
            first.setPrevious(null);
            size--;
            return (E) oldFirst.getValue();
        }
        else
        {
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes the last node of the list and returns its value
     * @return the value of the removed node
     * @postconditions the list's last node should be removed, its
     *                  value should be returned, the value of
     *                  the last node instance variable should be
     *                  changed, and the size should be 
     *                  decremented               
     */
    public E removeLast()
    {
        if (last == null)
        {
            throw new NullPointerException();
        }
        else
        {
            size--;
            Object lastNode = last.getValue();
            if (last.getPrevious() == null)
            {
                last = null;
                first = null;
                return (E) lastNode;
            }
            last = last.getPrevious();
            last.setNext(null);
            return (E) lastNode;
        }
    }

    /**
     * Creates an Iterator for MyLinkedList collections
     *
     * @return an Iterator for MyLinkedList collections
     */
    public Iterator<E> iterator()
    {
        return new MyLinkedListIterator();
    }

    /**
     * The MyLinkedListIterator class focuses on a mechanism
     * to safely remove elements from MyLinkedList collections
     *
     * @author Arun Sundaresan
     * @version October 17, 2018
     */
    private class MyLinkedListIterator implements Iterator<E>
    {
        private DoubleNode nextNode;
        private int nextIndex;
        private boolean nextCalled;
        private String listDesc;
        
        /**
         * Constructor for objects of class MyLinkedListIterator
         */
        public MyLinkedListIterator()
        {
            nextNode = first;
            nextIndex = 0;
            listDesc = MyLinkedList.this.toString();
        }

        /**
         * Determines if there are elements after the position
         * of the iterator
         *
         * @return true if there are elements after the position
         *              of the iterator; otherwise
         *              false
         */
        public boolean hasNext()
        {
            if (nextNode == null)
            {
                return false;
            }
            return true;
        }

        /**
         * Returns the value of the next node in the MyLinkedList
         *
         * @precondition  there must be more elements after
         *                  the position of the iterator
         *
         * @return  the value of the next node in the MyLinkedList
         */
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            
            Object next = nextNode.getValue();
            nextNode = nextNode.getNext();
            nextIndex++;
            nextCalled = true;
            return (E) next;
        }

        /**
         * Removes the last element returned by a call to next()
         *
         * @precondition next() has been called
         * @postcondition The last element that was returned by 
         *                  next() was removed
         */
        public void remove()
        {
            if (!nextCalled)
                throw new IllegalStateException();
            MyLinkedList.this.remove(nextIndex - 1);
            listDesc = MyLinkedList.this.toString();
            nextCalled = false;
            nextIndex--;
        }
    }
}
