/**
 * The HeapUtils class allows for the manipulation of heaps 
 * including the implementation of the HeapSort algorithm.
 * @author Arjun Akkiraju
 * @version 1.21.19
 *
 */
public class HeapUtils
{
    /**
     * Creates a maxheap from a specified heap. A max heap is a heap in which
     * all the root nodes of all the subtrees have a greater value than their
     * children nodes. Heapify swaps nodes until it has created a maxheap.
     * It does this through a process called "bubbling up" in which the largest nodes
     * reach the root of the heap. Runs at O(n) time where n is the number of nodes.
     * @param heap The heap being heapified.
     * @param index The current index of the node bubbling up
     * @param heapSize The number of nodes in the heap.
     */
    public static void heapify(Comparable[] heap, int index, int heapSize)
    {
        int left = (int) heap[1];
        int right = (int) heap[2];
        int largest =0;
        if(left < heapSize)
        {
            if(left > (int)heap[0])
            {
                largest = left;
            }
        }
        if(right < heapSize)
        {
            if(right > (int)heap[0])
            {
                largest = Math.max(right, left);
            }
        }
        if(largest != index)
        {
            heap = swap(heap, largest, index);
        }
        heapify(heap, largest, heapSize);
    }
    /**
     * Helper method to heapify which swaps the values of the 2 indices.
     * in an array. 
     * @param heap The array
     * @param i1 The 1st index
     * @param i2 The 2nd index
     * @return
     */
    private static Comparable [] swap(Comparable[] heap, int i1,int i2)
    {
        Comparable temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
        return heap;
    }
    /**
     * Build the maxheap by heapifying all the nodes.
     * A max heap is a heap in which
     * all the root nodes of all the subtrees have a greater value than their
     * children nodes. Runs at O(n) time where n is the number of nodes.
     * @param heap The heap which is being transformed into a maxheap
     * @param heapSize The number of nodes in the heap.
     */
    public static void buildHeap(Comparable[] heap, int heapSize)
    {
        for(int i = heap.length/2; i >= 1; i--)
        {
            heapify(heap, i, (int)heap[i]-(int)heap[1]);
        }
    }
    /**
     * Inserts a node into the heap. In order to keep 
     * the structure a heap, the insert method must insert
     * the node as right as possible on the lowest level
     * of the heap. Runs at O(n) time wher e
     * n is the number of nodes. 
     * @param heap The heap which is being added to.
     * @param item The value of the node being added.
     * @param heapSize The number of nodes in the heap.
     * @return
     */
    public static Comparable[] insert(
            Comparable[] heap, Comparable item, int heapSize)
    {
        Comparable[] newHeap = new Comparable[heap.length+1];
        for(int i = 0; i< heap.length; i++)
        {
            newHeap[i]=heap[i];
        }
        newHeap[newHeap.length -1] = item;
        return newHeap;
    }
    /**
     * Removes the root of the node and swaps it with the rightmost
     * leaf node. Runs at O(1) time.
     * @param heap The heap which is being altered.
     * @param heapSize The number of nodes in the heap.
     * @return
     */
    public static Comparable remove(Comparable[] heap, int heapSize)
    {
        Comparable temp = heap[1];
        heap[1] = null;
        swap(heap, (int)heap[heapSize], (int)heap[1]);
        return temp;
        
    }
    /**
     * Sorts the given Comparable array in ascending order.
     * First, the algorithm builds the heap, creating a tree
     * in which the nodes on the lowest level are as far right
     * as possible.
     * Next, the algorithm heapifyes the heap, meaning it creates 
     * a maxheap in which the parent nodes are greater than their
     * child nodes.
     * Then, the algorithm removes the root node by switching it
     * with the last node in the heap and setting it to null. 
     * All of this happens in a loop which executes the same number
     * of times are there are nodes in the heap. The operation runs
     * at O(nlogn) time where n is the number of nodes in the heap.
     * @param heap The heap being sorted
     * @param heapSize The number of nodes in the heap. 
     * @return
     */
    public static Comparable[] heapSort(Comparable[] heap, int heapSize)
    {
       for(int i = heapSize-1; i>=0; i--)
       {
           buildHeap(heap, heapSize);
           heapify(heap, i, heapSize);
           remove(heap, heapSize);
       }
       return heap;
        
    }
}
