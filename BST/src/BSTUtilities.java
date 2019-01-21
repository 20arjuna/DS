/**
 * A class which is used to perform basic functions on binary search trees
 * @author Arjun Akkiraju
 * @version 1.21.19
 *
 */
public abstract class BSTUtilities
{
	/**
	 * Checks whether a specified value is present in
	 * the given binary search tree
	 * @param t the Binary Search Tree
	 * @param x the object being checked
	 * @param display the display where the bst is displayed
	 * @precondition t is a binary search tree in ascending order
	 * @postcondition returns true if t contains the value x;
 	 *               otherwise, returns false
	 * @return  the value of the leftmost node of a binary tree.
	 */

	public static boolean contains(TreeNode t, Comparable x, TreeDisplay display)
	{
		if(x.compareTo(t.getValue()) == 0)
		{
			return true;
		}
		else if (this.contains(t.getLeft(), x, display));
		{
			return true;
		}
		else if (this.contains(t.getRight(), x, display));
		{
			return true;
		}
		return false;
	}
	/**
	 * Inserts the given value into the given binary search tree
	 * @param t the Binary Search Tree
	 * @param x the object being checked
	 * @param display the display where the bst is displayed
	 * @precondition t is a binary search tree in ascending order
	 * @postcondition if t is empty, returns a new tree containing x;
 	 *              otherwise, returns t, with x having been inserted
 	 *               at the appropriate position to maintain the binary
 	 *              search tree property; x is ignored if it is a
 	 *               duplicate of an element already in t; only one new
 	 *               TreeNode is created in the course of the traversal
	 * @return  the value of the leftmost node of a binary tree.
	 */
	public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (t == null) {
            t = new TreeNode(x);
            return root;
        }


        if (x.compareTo(t.getValue()) < 0)
            t.setLeft(insert(t.getLeft(), x, display));
        else if (x.compareTo(t.getValue()) > 0)
            t.setRight(insert(t.getLeft(), x, display));
				else if (x.compareTo(t.getValue()) == 0)
				{
					return t;
				}
        return t;
	}
	/**
	 * Helper method for the delete method. deleteNode
	 * deletes the root node of a specified tree.
	 * @param t the Binary Search Tree
	 * @param x the object being checked
	 * @param display the display where the bst is displayed
	 * @precondition t is a binary search tree in ascending order
	 * @postcondition returns a pointer to a binary search tree,
 	 *               in which the value at node t has been deleted
 	 *               (and no new TreeNodes have been created)
	 * @return  the value of the leftmost node of a binary tree.
	 */
	private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
	{
		/* Base Case: If the tree is empty */
        if (t == null)
				{
					return null;
				}


        if (x.compareTo(t.getLeft()) < 0)
            t.setLeft(deleteNode(t.getLeft(), display));
        else if (x.compareTo(t.getRight()) > 0)
            t.setRight(deleteNode(t.getRight(), display));


        else
        {

            if (t.getLeft() == null)
                return t.getRight();
            else if (t.getRight() == null)
                return t.getLeft();
        }

        return t;
	}
	/**
	 * Deletes the given value from the binary search tree.
	 * @param t the Binary Search Tree
	 * @param x the object being checked
	 * @param display the display where the bst is displayed
	 * @precondition t is a binary search tree in ascending order
	 * @postcondition returns a pointer to a binary search tree,
 	 *               in which the value x has been deleted (if present)
 	 *               (and no new TreeNodes have been created)
	 * @return  the value of the leftmost node of a binary tree.
	 */
	public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
	{
		if(x.compareTo(t.getValue()) == 0)
		{
			deleteNode(t, display);
		}
		else if(x.compareTo(t.getValue()) < 0)
		{
			delete(t.getLeft(), x, display);
		}
		else if(x.compareTo(t.getValue()) > 0)
		{
			delete(t.getRight(), x, display);
		}
		return t;
	}
}
