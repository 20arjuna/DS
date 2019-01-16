import java.util.*;
public class TreeDriver
{

    public static void main(String[] args)
    {
        TreeNode tree = TreeUtil.createRandom(4);
        TreeDisplay display = new TreeDisplay();
        display.displayTree(tree);
        List<String> list = new ArrayList<String>();
        /*
        System.out.println("Leftmost: " + TreeUtil.leftmost(tree));
        System.out.println("Rightmost: " + TreeUtil.rightmost(tree));
        System.out.println("Max depth: " + TreeUtil.maxDepth(tree));
        System.out.println("Number of nodes: " + TreeUtil.countNodes(tree));
        System.out.println("Number of leaves: " + TreeUtil.countLeaves(tree));*/
        
       /* Scanner sc = new Scanner(System.in);
        System.out.println("1. PreOrder");
        System.out.println("2. InOrder");
        System.out.println("3. PostOrder");
        
        int choice = sc.nextInt();
        if(choice == 1) 
        {
            TreeUtil.preOrder(tree, display);
        }
        else if(choice==2)
        {
            TreeUtil.inOrder(tree, display);
        }
        else if(choice ==3)
        {
            TreeUtil.postOrder(tree, display);
        }*/
        //TreeUtil.fillList(tree, list);
        //System.out.println(list);
        
        TreeUtil.saveTree("test.txt", tree);

    }

}
