package proj5;

/** BSTNode CLASS
 * The BSTNode class is more data-specific than the BST class.  It
 * details what a single node looks like.  This node has 2 data field: its key and its data. It also has 2 pointers pointing towards its (at most) 2 children
 *
 * @author Jordan An
 * @version 6/5/2020
 */

public class BSTNode<Key extends Comparable, T> {
    public Key key;              // Key for this node
    public T data;            // Element for this node
    public BSTNode<Key, T> llink;  // Pointer to left child
    public BSTNode<Key, T> rlink; // Pointer to right child

    /**
     * Default Constructor
     */
    public BSTNode() {
        llink = null;
        rlink = null;
        key = null;
        data = null;
    }

    /**
     * Create a node with specific key and dta
     * @param k the ket
     * @param d the data
     */
    public BSTNode(Key k, T d)
    {
        llink = null;
        rlink = null;
        key = k;
        data = d;
    }

    /**
     * See if the node has no children
     * @return true if the node has no children, false other wise.
     */
    public boolean hasNoChildren() {
        return (llink == null) && (rlink == null);
    }
}