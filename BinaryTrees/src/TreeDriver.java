import java.util.*;
/**
 * TreeDriver is the driver class for the Binary Trees Lab.
 * It is used to run and test all TreeUtil Methods.
 * @author Arjun Akkiraju
 * @version 1.21.19
 *
 */
public class TreeDriver
{
    /**
     * Main Method for running TreeUtil Methods
     * @param args Arguments from the command line. 
     */
    public static void main(String[] args)
    {
        
        TreeNode tree = TreeUtil.loadTree("test.txt");
        TreeDisplay display = new TreeDisplay();
        display.displayTree(tree);
        List<String> list = new ArrayList<String>();
        
    }

}
