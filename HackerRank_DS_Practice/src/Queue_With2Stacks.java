import java.util.*;
import java.io.*;
public class Queue_With2Stacks
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        File input = new File("/Users/20arjuna/Desktop/DS/HackerRank_DS_Practice/inputFiles/queueWith2Stacks.txt");
        Scanner sc = new Scanner(input);
        sc.nextLine();
        Stack<String> s1 = new Stack();
        Stack<String> s2 = new Stack();
        ArrayList<String> queueFunctions = new ArrayList<String>();
        while(sc.hasNext())
        {
            String x = "hello";
            String temp = sc.nextLine();
            
            if(temp.substring(0,1).equals("1"))
            {
                s1.push(temp.substring(2));
            }
            else
            {
                queueFunctions.add(temp);
            }
            
        }
       
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        //System.out.println("s2: " + s2.toString());
        //System.out.println("queueFunctions" + )
        for(int i = 0; i < queueFunctions.size(); i ++)
        {
            if(queueFunctions.get(i).equals("2"))
            {
                s2.pop();
            }
            else if(queueFunctions.get(i).equals("3"))
            {
                System.out.println(s2.peek());
            }
        }
    }
}
