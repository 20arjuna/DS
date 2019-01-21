//a collection of static methods for operating on binary search trees
public abstract class BSTUtilities
{
	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns true if t contains the value x;
	//               otherwise, returns false
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

	//precondition:  t is a binary search tree in ascending order
	//postcondition: if t is empty, returns a new tree containing x;
	//               otherwise, returns t, with x having been inserted
	//               at the appropriate position to maintain the binary
	//               search tree property; x is ignored if it is a
	//               duplicate of an element already in t; only one new
	//               TreeNode is created in the course of the traversal
	public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (t == null) {
            t = new TreeNode(x);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (x.compareTo(t.getValue()) < 0)
            t.getLeft() = insert(t.getLeft(), x, display);
        else if (x.compareTo(t.getValue()) > 0)
            t.getRight() = insert(t.getLeft(), x, display);
				else if (x.compareTo(t.getValue()) == 0)
				{
					return t;
				}

        /* return the (unchanged) node pointer */
        return t;
	}

	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns a pointer to a binary search tree,
	//               in which the value at node t has been deleted
	//               (and no new TreeNodes have been created)
	private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
	{
		/* Base Case: If the tree is empty */
        if (t == null)
				{

				}

        /* Otherwise, recur down the tree */
        if (x.compareTo(t.getLeft()) < 0) 
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
	}

	//precondition:  t is a binary search tree in ascending order
	//postcondition: returns a pointer to a binary search tree,
	//               in which the value x has been deleted (if present)
	//               (and no new TreeNodes have been created)
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
