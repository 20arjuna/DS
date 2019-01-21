/**
 * 
 * @author 20arjuna
 *
 */
public class HeapUtils
{
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
    private static Comparable [] swap(Comparable[] heap, int i1,int i2)
    {
        Comparable temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
        return heap;
    }
    public static void buildHeap(Comparable[] heap, int heapSize)
    {
        for(int i = heap.length/2; i >= 1; i--)
        {
            heapify(heap, i, (int)heap[i]-(int)heap[1]);
        }
    }
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
    public static Comparable remove(Comparable[] heap, int heapSize)
    {
        Comparable temp = heap[1];
        heap[1] = null;
        swap(heap, (int)heap[heapSize], (int)heap[1]);
        return temp;
        
    }
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
