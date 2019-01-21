import java.util.*;
/**
 * TreeUtil contains the following methods for manipulating binary trees:
 * 1. leftmost(TreeNode) - gets the leftmost node in a binary tree
 * 2. rightmost(TreeNode) - gets the rightmost node in a binary tree
 * 3. maxDepth(TreeNode) - gets the maximum depth of the binary tree
 * 4. createRandom(int) - creates a random binary tree with a specified depth
 * 5. countNodes(TreeNode) - counts the nodes on a binary tree
 * 6. countLeaves(TreeNode) - counts the leaves on a binary tree
 * 7. preOrder(TreeNode) - traverses the tree in preorder.
 * 8. inOrder(TreeNode) - traverses the tree in inorder.
 * 9. postOrder(TreeNode) - traverses the tree in postorder.
 * 10. fillList(TreeNode, List<String>) - fills a list of strings 
 * with the objects stored in the binary tree
 * 11. saveTree(String, TreeNode) - Saves the contents of a binary tree to a file of a given name. 
 * 12. buildTree(Iterator<String>) - builds a binary tree 
 * given a string iterator with the tree’s contents. 
 * 13. loadTree(String) - loads a filename and returns a binary tree 
 * from the contents of the given file. 
 * 14. copy(TreeNode) - copies a given binary tree
 * 15. sameShape(TreeNode, TreeNode) - checks if two binary trees are copies of each other. 
 * 16. insertMorse(TreeNode, String, String, display) - inserts a given 
 * letter to a morse tree on a given display. 
 * 17. decodeMorse(TreeNode, String, TreeDisplay) - returns the English 
 * equivalent of ciphered text given a decoding binary tree). 
 * @author Arjun Akkiraju
 * @version 1.21.19
 *
 */
public class TreeUtil
{
	//used to prompt for command line input
	private static Scanner in = new Scanner(System.in);
	
	private static final boolean debug = false;


	/**
	 * Returns the value of the leftmost node of a binary tree.
	 * @param t the Binary Tree
	 * @return  the value of the leftmost node of a binary tree.
	 */
	public static Object leftmost(TreeNode t)
	{
	    if(t==null)
	    {
	        return null;
	    }
	    if(t.getLeft()==null)
	    {
	       return t.getValue();
	    }
	    return leftmost(t.getLeft());
	    
	    
	}

	/**
	 * Returns the value of the rightmost node of a binary tree.
     * @param t the Binary Tree
     * @return  the value of the rightmost node of a binary tree.
	 */
	public static Object rightmost(TreeNode t)
	{
	    if(t==null)
        {
            return null;
        }
        if(t.getRight()==null)
        {
           return t.getValue();
        }
        return rightmost(t.getRight());
	}
	/**
	 * Returns the maximum depth contained in the binary tree. Depth is the number
	 * of edges between a leaf node and a root node.
	 * 
	 * @param t the Binary Tree
	 * @return the maximum depth contained in the binary tree.
	 */
	public static int maxDepth(TreeNode t)
	{
	    if(t == null)
	    {
	        return 0;
	    }
	    else
	    {
	        int lDepth = maxDepth(t.getLeft()); 
            int rDepth = maxDepth(t.getRight());
            
            if (lDepth > rDepth) 
                return (lDepth+1); 
             else 
                return (rDepth+1);
	    }
		
	}

	/**
	 * create a random tree of the specified depth.  No attempt to balance the tree
	 * is provided.
	 * @param depth - depth of the tree
	 * @return TreeNode object that points to the generated tree
	 */
	public static TreeNode createRandom(int depth)
	{
		if (Math.random() * Math.pow(2, depth) < 1)
			return null;
		return new TreeNode(((int)(Math.random() * 10)),
			createRandom(depth - 1),
			createRandom(depth - 1));
	}
	/**
	 * Counts the number of nodes in a binary tree.
	 * @param t the binary tree.
	 * @return the number of nodes in the binary tree.
	 */
	public static int countNodes(TreeNode t)
	{
	    if(t==null)
	    {
	        return 0;
	    }
		if(t.getLeft()==null && t.getRight()==null)
		{
		    return 1;
		}
		return 1+ countNodes(t.getLeft())+countNodes(t.getRight());
	}
	/**
	 * Counts the number of leaves in a binary tree. A leaf is a binary tree without children. 
     * @param t the binary tree.
     * @return the number of leaves in the binary tree.
	 */
	public static int countLeaves(TreeNode t)
	{
	    if(t==null)
        {
            return 0;
        }
        if(t.getLeft()==null && t.getRight()==null)
        {
            return 1;
        }
        return countLeaves(t.getLeft())+countLeaves(t.getRight());
		
	}
	/**
	 * Traverses the tree in preOrder, meaning it visits the root first,
	 * then the left subtree, then the right subtree.
	 * @param t - The binary tree
	 * @param display - The display where the tree is displayed.
	 */
	public static void preOrder(TreeNode t, TreeDisplay display)
	{
	    if(t==null)
	    {
	        return;
	    }
		display.visit(t);
		preOrder(t.getLeft(), display);
		preOrder(t.getRight(), display);
	}
    /**
     * Traverses the tree in inOrder, meaning it visits the left subtree first,
     * then root, then the right subtree.
     * @param t - The binary tree
     * @param display - The display where the tree is displayed.
     */
	public static void inOrder(TreeNode t, TreeDisplay display)
	{
	    if(t==null)
        {
            return;
        }
        inOrder(t.getLeft(), display);
        display.visit(t);
        inOrder(t.getRight(), display);
	}
    /**
     * Traverses the tree in postOrder, meaning it visits the left subtree first,
     * then the right subtree, then the root.
     * @param t - The binary tree
     * @param display - The display where the tree is displayed.
     */
	public static void postOrder(TreeNode t, TreeDisplay display)
	{
	    if(t==null)
        {
            return;
        }
        postOrder(t.getLeft(), display);
        postOrder(t.getRight(), display);
        display.visit(t);
	}
	/**
	 * Fills a given list with the contents of a binary tree.
	 * @param t - The binary tree
	 * @param list - the list where the contents will be stored. 
	 */
	public static void fillList(TreeNode t, List<String> list)
	{
		if(t == null)
		{
		    list.add("$");
		    return;
		}
		if(t.getLeft() == null && t.getRight() == null)
		{
		    list.add(t.getValue().toString());
		    list.add("$");
		    list.add("$");
		    return;
		}
		list.add(t.getValue().toString());
		fillList(t.getLeft(), list);
		fillList(t.getRight(), list);
		
	}
	/**
	 * saveTree uses the FileUtil utility class to save the tree rooted at t
	 * as a file with the given file name
	 * @param fileName is the name of the file to create which will hold the data
	 *        values in the tree
	 * @param t is the root of the tree to save
	 */
	public static void saveTree(String fileName, TreeNode t)
	{
		ArrayList<String> data = new ArrayList<String>();
		fillList(t, data);
		Iterator<String> it = data.iterator();
		FileUtil.saveFile(fileName, it);
	}
	/**
	 * buildTree takes in an iterator which will iterate through a valid description of
	 * a binary tree with String values.  Null nodes are indicated by "$" markers
	 * @param it the iterator which will iterate over the tree description
	 * @return a pointer to the root of the tree built by the iteration
	 */
	public static TreeNode buildTree(Iterator<String> it)
	{
	    TreeNode tree = new TreeNode(it.next());
        while(it.hasNext())
        {
            String temp = it.next();
            if(temp.equals("$"))
            {
                tree.setRight(new TreeNode(it.next()));
            }
            else
            {  
                tree.setLeft(new TreeNode(temp));
            }
        }
        return tree;
	    

	}
	/**
	 * read a file description of a tree and then build the tree
	 * @param fileName is a valid file name for a file that describes a binary tree
	 * @return a pointer to the root of the tree
	 */
	public static TreeNode loadTree(String fileName)
	{
		Iterator<String> it = FileUtil.loadFile(fileName);
		TreeNode tree = buildTree(it);
		return tree; 
	}
	/**
	 * utility method that waits for a user to type text into Std Input and then press enter
	 * @return the string entered by the user
	 */
	private static String getUserInput()
	{
		return in.nextLine();
	}
	/**
	 * plays a single round of 20 questions
	 * postcondition:  plays a round of twenty questions, asking the user questions as it
     *                 walks down the given knowledge tree, lighting up the display as it goes;
     *                 modifies the tree to include information learned.
	 * @param t a pointer to the root of the game tree
	 * @param display which will show the progress of the game
	 */
	private static void twentyQuestionsRound(TreeNode t, TreeDisplay display)
	{	
		System.out.println("Twenty Questions round ");
	}
	/** 
	 * plays a game of 20 questions
	 * Begins by reading in a starting file and then plays multiple rounds
	 * until the user enters "quit".  Then the final tree is saved
	 */
	public static void twentyQuestions()
	{
		throw new RuntimeException("Write ME!");
	}
	/**
	 * copy a binary tree
	 * @param t the root of the tree to copy
	 * @return a new tree, which is a complete copy
	 *         of t with all new TreeNode objects
	 *         pointing to the same values as t (in the same order, shape, etc)
	 */
	public static TreeNode copy(TreeNode t)
	{
		TreeUtil.saveTree("test.txt", t);
		Iterator<String> it = FileUtil.loadFile("test.txt");
		return TreeUtil.buildTree(it);
		 
		 
	}
	
	/**
	 * tests to see if two trees have the same shape, but not necessarily the
	 * same values.  Two trees have the same shape if they have TreeNode objects
	 * in the same locations relative to the root
	 * @param t1 pointer to the root of the first tree
	 * @param t2 pointer to the root of the second tree
	 * @return true if t1 and t2 describe trees having the same shape, false otherwise
	 */
	public static boolean sameShape(TreeNode t1, TreeNode t2)
	{
		if(t1 == null && t2 == null)
		{
		    return true;
		}
		if((t1 == null && t2!= null) || (t1!=null && t2==null))
		{
		    return false;
		}
		if(sameShape(t1.getLeft(), t2.getLeft()) && sameShape(t1.getRight(), t2.getRight()))
		{
		    return true;
		}
		return false;
	}
	/**
	 * Generate a tree for decoding Morse code
	 * @param display the display that will show the decoding tree
	 * @return the decoding tree
	 */
	public static TreeNode createDecodingTree(TreeDisplay display)
	{
		TreeNode tree = new TreeNode("Morse Tree");
		display.displayTree(tree);
		insertMorse(tree, "a", ".-", display);
		insertMorse(tree, "b", "-...", display);
		insertMorse(tree, "c", "-.-.", display);
		insertMorse(tree, "d", "-..", display);
		insertMorse(tree, "e", ".", display);
		insertMorse(tree, "f", "..-.", display);
		insertMorse(tree, "g", "--.", display);
		insertMorse(tree, "h", "....", display);
		insertMorse(tree, "i", "..", display);
		insertMorse(tree, "j", ".---", display);
		insertMorse(tree, "k", "-.-", display);
		insertMorse(tree, "l", ".-..", display);
		insertMorse(tree, "m", "--", display);
		insertMorse(tree, "n", "-.", display);
		insertMorse(tree, "o", "---", display);
		insertMorse(tree, "p", ".--.", display);
		insertMorse(tree, "q", "--.-", display);
		insertMorse(tree, "r", ".-.", display);
		insertMorse(tree, "s", "...", display);
		insertMorse(tree, "t", "-", display);
		insertMorse(tree, "u", "..-", display);
		insertMorse(tree, "v", "...-", display);
		insertMorse(tree, "w", ".--", display);
		insertMorse(tree, "x", "-..-", display);
		insertMorse(tree, "y", "-.--", display);
		insertMorse(tree, "z", "--..", display);
		return tree;
	}
	/**
	 * helper method for building a Morse code decoding tree.
	 * postcondition:  inserts the given letter into the decodingTree,
     *                 in the appropriate position, as determined by
     *                 the given Morse code sequence; lights up the display
     *                 as it walks down the tree
	 * @param decodingTree is the partial decoding tree
	 * @param letter is the letter to add
	 * @param code is the Morse code for letter
	 * @param display is the display that will show progress as the method walks 
	 *        down the tree
	 */
	private static void insertMorse(TreeNode decodingTree, String letter,
									String code, TreeDisplay display)
	{
	        if(code.equals("-"))
	        {
	            display.visit(decodingTree.getLeft());
	            decodingTree.setLeft(new TreeNode(letter));
	        }
	        if(code.equals("."))
            {
                display.visit(decodingTree.getRight());
                decodingTree.setRight(new TreeNode(letter));
            }
	        if(code.substring(0, 1).equals("-"))
		    {
		        insertMorse(decodingTree.getLeft(), letter, code.substring(1), display);
		    }
	        else if(code.substring(0,1).equals("."))
	        {
	            insertMorse(decodingTree.getRight(), letter, code.substring(1), display);
	        }
		
	}
	/**
	 * decodes Morse code by walking the decoding tree according to the input code
	 * @param decodingTree is the Morse code decoding tree
	 * @param cipherText is Morse code consisting of dots, dashes, and spaces
	 * @param display is the display object that will show the decoding progress
	 * @return the string represented by cipherText
	 */
	public static String decodeMorse(TreeNode decodingTree, String cipherText, TreeDisplay display)
	{
		if(decodingTree == null)
		{
		    return "";
		}
		if(cipherText.equals("-"))
		{
		    display.visit(decodingTree.getLeft());
		    return (String) decodingTree.getLeft().getValue();
		}
		if(cipherText.equals("."))
        {
		    display.visit(decodingTree.getRight());
            return (String) decodingTree.getRight().getValue();
        }
		if(cipherText.substring(0, 1).equals("-"))
        {
            decodeMorse(decodingTree.getLeft(), cipherText.substring(1), display);
        }
		else if(cipherText.substring(0, 1).equals("."))
        {
            decodeMorse(decodingTree.getRight(), cipherText.substring(1), display);
        }
		return "";
	}
	/**
	* optional work
	*/
	public static int eval(TreeNode expTree)
	{
		throw new RuntimeException("Write ME!");
	}
	/**
	* optional work
	*/
	public static TreeNode createExpressionTree(String exp)
	{
		throw new RuntimeException("Write ME!");
	}

	/**
	 * debug printout
	 * postcondition: out is printed to System.out
	 * @param out the string to send to System.out
	 */
	
	private static void debugPrint(String out)
	{
	    if(debug) System.out.println("debug: " + out);
	}
}
	