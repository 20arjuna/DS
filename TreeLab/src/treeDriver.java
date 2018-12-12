
public class treeDriver
{
    public static void main (String[] args)
    {
        TreeNode tree = TreeUtil.createRandom(6);
        TreeDisplay display = new TreeDisplay();
        display.displayTree(tree);
        
    }
}
