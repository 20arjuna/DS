
public class Main
{

    public static void main(String[] args)
    {
       Integer [] intObjs = new Integer [12];
       for(int i =1; i < intObjs.length; i++)
       {
           intObjs[i] = (int) ((Math.random() * 99) + 1);
       }
       HeapDisplay display = new HeapDisplay();
       display.displayHeap(intObjs, 11\);
       for(int x = 0; x < intObjs.length; x++)
       {
           System.out.println(intObjs[x]);
       }
    }

}
