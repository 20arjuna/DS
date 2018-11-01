import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The MyLinkedList class is the blueprint for a linked list data structure
 * which stores data in a collection of nodes which holds a value and two references,
 * one to the node after it, and one to the node before it. A MyLinkedList object is great
 * for quickly inserting/deleting data held in the data structure.
 *
 * @param <E> The type of object being stored in the MyLinkedList
 * @author Arjun Akkiraju
 * @version  10.24.18
 */
public class MyLinkedList<E>
{

    private DoubleNode first;
    private DoubleNode last;
    private int size;

    /**
     * Constructs a MyLInkedList object
     */
    public MyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Formats the MyLInkedList into a string in the format [object1, object2 ...]
     *
     * @return  A formatted string with the values of the MyLinkedList arranged in order.
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
     * Gets the node at the specified position by traversing from the first node
     *
     * @param index of the node in the MyLinkeList
     * @return the node at the specified position
     * @precondition  0 <= index <= size / 2
     * @postcondition starting from first, returns the node
    *                 with given index (where index = 0)
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
     * Gets the node at the specified position by traversing from the first node
     *
     * @param index the position whose node to retrieve
     * @return the node at the specified position
     * @precondition  0 <= index <= size / 2
     * @postcondition starting from last, returns the node
    *                 with given index (where index size-1
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
            i--;
        }
        return last2;
    }

    /**
     * Gets the node at the specified index by traversing either from the start of
     * the MyLinkedList or the end depending on the position of the index relative
     * to the MyLinkedList
     *
     * @param index the position whose node to retrieve
     * @return the DoubleNode located at index
     * @precondition 0 <= index < size
     * @postcondition starting from first or last (whichever
    *                 is closer), returns the node with given
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
     * Gets the number of values stored in the MyLinkedList
     *
     * @return the number of values in the MyLinkedList
     */
    public int size()
    {
        return size;
    }

    /**
     * Gets the value of the node at the specified index
     *
     * @param index where the node with the desired value is
     * @return  the value of the node at the specified index
     */
    public E get(int index)
    {
        return (E) getNode(index).getValue();
    }

    /**
     * Sets the value of the element at the specified index to the specified
     * value and returns the value which formerly occupied the specified index.
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
     * Attaches a node storing the given object to the end of the MyLinkedList
     *
     * @param obj the value of the node to be added
     * @postcondition a node with the specified value is added to the
     *                  end of the list, increments the size, and 
     *                  returns true
     * @return  true always
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
     * Removes the node at the specified index and shifts all nodes
     * which have indices bigger than the specified index to the left by 1, while
     * returning the value of the node being removed. 
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
     * Adds a node which stores the specified object to the MyLinkedList at the given index
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
     * Adds an node containing the specified object to the beginning of the MyLinkedList object
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
     * Adds a node which contains the specified object to the end of the MyLinkedList
     *
     * @param obj the value of the node to be added to the end
     * @preconditions 0 <= index <= size
     * @postcondition inserts node with the sepcified value to 
     *                  the end of the list, and increments the size
     */
    public void addLast(E obj)
    {
        this.add(obj);
    }

    /**
     * Returns the value of the first node of the MyLinkedList.
     *
     * @return the value of the first node of the list.
     */
    public E getFirst()
    {
        return (E) first.getValue();
    }

    /**
     * Retrieves the value of the last node of the MyLinkedList.
     *
     * @return the value of the last node of the list.
     */
    public E getLast()
    {
        return (E) last.getValue();
    }

    /**
     * Removes the first node of the MyLinkedList and returns the value of the node being removed.
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
                DoubleNode old = first;
                first = null;
                last = null;
                size--;
                return (E) old;
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
     * Removes the first node of the MyLinkedList and returns the value of the node being removed.
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
            return null;
        }
        else
        {
            size--;
            E lastNode = (E) last.getValue();
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
     * The MyLinkedListIterator class is a blueprint for an iterator which can
     * Iterate through the MyLinkedList object efficiently and providing basic
     * functions like adding and removing element from the MyLinkedList.
     *
     * @author Arjun Akkiraju
     * @version 10.24.18
     */
    private class MyLinkedListIterator implements Iterator<E>
    {
        private DoubleNode nextNode;
        private int nextIndex;
        private boolean nextCalled;
        private String listDesc;
        
        /**
         * Constructs a MyLinkedListIterator object
         */
        public MyLinkedListIterator()
        {
            nextNode = first;
            nextIndex = 0;
            listDesc = MyLinkedList.this.toString();
        }

        /**
         * Determines if the MyLinkedList object that the MyLinkedListIterator is
         * iterating through has another element behind the element that the
         * MyLinkedListIterator is currently pointing to.
         *
         * @return true if the MyLinkedList object has another element 
         *         behind the index that the MyLinkedList iterator is pointing to; otherwise, 
         *         false
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
         *  Returns the element which is at the index behind the index that the
         * MyLinkedListIterator is pointing to.
         * 
         * @return the element which is at the index behind the index that the
         *         MyLinkedListIterator is pointing to.
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
         * Removes the element returned by the next() method.
         * 
         * @postcondition removes the last element that was returned by next
         */
        public void remove()
        {
            if (!this.nextCalled)
            {
                throw new IllegalStateException();
            }
                
            MyLinkedList.this.remove(nextIndex - 1);
            listDesc = MyLinkedList.this.toString();
            
            nextCalled = false;
            nextIndex--;
        }
    }
}
