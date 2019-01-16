
public class treeDriver
{
    public static void main (String[] args)
    {
        TreeNode tree = TreeUtil.createRandom(2);
        TreeDisplay display = new TreeDisplay();
        display.displayTree(tree);
        
        System.out.println("left: " + TreeUtil.leftmost(tree));
        System.out.println("right: " + TreeUtil.rightmost(tree));
        System.out.println("Max Depth: " + TreeUtil.maxDepth(tree));
        System.out.println("Node count: " + TreeUtil.countNodes(tree));
    }
}
