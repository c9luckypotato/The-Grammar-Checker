package proj5;

/** BST CLASS
 * Binary search tree is an abstract data structure used to store data.
 *
 * @author Jordan An
 * @version 6/5/2020
 */

/**
 * CLASS INVARIANT
 * 1. There is one special node, called the root.
 * 2. Each node can be associated with up to two other different
 * nodes, called its left child and its right child. If a
 * node c is the child of another node p, then we say that “p
 * is c’s parent.”
 * 3. Each node, except the root, has exactly one parent; the
 * root has no parent.
 * 4. If you start at a node and move to the node’s parent (provided
 * there is one), and then move again to that node’s
 * parent, and keep moving upward to each node’s parent,
 * you will eventually reach the root.
 * 5. The number of nodes in the tree is kept track of using variable size.
 */

public class BST<Key extends Comparable, T> {
    private BSTNode<Key, T> root; // Root of the BST
    private int size;             // Number of nodes in the BST

    /**
     * Default constructor.
     */
    public BST() {
        root = null;
        size = 0;
    }


    /**
     * Insert BSTNode
     * @param newKey the key of the node to insert
     * @param newData the data of the node to insert
     */
    public void insert(Key newKey, T newData) {
        root = insertHelper(root, newKey, newData);
        size++;
    }


    /**
     * Remove a node
     * @param k the key of the node to remove
     * @return the node that has been removed, return null if there is no node with key k
     */
    public T remove(Key k) {
        T temp = findHelper(root, k);
        if (temp != null) {
            root = removeHelper(root, k);
            size--;
        }
        return temp;
    }


    /**
     * Find a node
     * @param k the key of the node to find
     * @return the node with key k
     */
    public T find(Key k) {
        return findHelper(root, k);
    }


    /**
     * Get the number of nodes of the trees
     * @return the number of nodes of the trees
     */
    public int size() {
        return size;
    }


    /**
     * Set data of node
     * @param k the key of the node to set
     * @param newData the new data to set
     */
    public void setDataAtKey(Key k, T newData){
        BSTNode<Key, T> found = getNodeAtKey(root, k);
        found.data = newData;
    }


    /**
     * Get the node at key recursively
     * @param start the starting node
     * @param k the key to find
     * @return the node with k key
     */
    private BSTNode<Key, T> getNodeAtKey(BSTNode<Key, T> start, Key k){
        if (start == null){
            return null;
        }

        if (start.key.compareTo(k) > 0){
            return getNodeAtKey(start.llink, k);
        }
        else if (start.key.compareTo(k) < 0){
            return getNodeAtKey(start.rlink, k);
        }
        else{
            return start;
        }
    }


    /**
     * Recursive helper method
     * @param start the starting node
     * @param k the key of the node we finding
     * @return the data of the node with key K
     */
    private T findHelper(BSTNode<Key, T> start, Key k) {
        if (start == null){
            return null;
        }

        if (start.key.compareTo(k) > 0){
            return findHelper(start.llink, k);
        }
        else if (start.key.compareTo(k) < 0){
            return findHelper(start.rlink, k);
        }
        else{
            return start.data;
        }
    }

    /**
     * Recursive helper method
     * @param start starting node
     * @param newKey the new key of the new node to insert
     * @param newData the new data of the new node to insert
     * @return the node (recursive)
     */
    private BSTNode<Key, T> insertHelper(BSTNode<Key, T> start, Key newKey, T newData) {
        if (start == null){
            return new BSTNode<Key, T>(newKey, newData);
        }
        else if (start.key.compareTo(newKey) > 0){
            start.llink = insertHelper(start.llink, newKey, newData);
        }
        else {
            start.rlink = insertHelper(start.rlink, newKey, newData);
        }
        return start;
    }


    /**
     * Recursive helper method
     * @param start starting node
     * @param k key of the node to remove
     * @return the removed node
     */
    private BSTNode<Key, T> removeHelper(BSTNode<Key, T> start, Key k) {
        if (start == null) {
            return null;
        }
        if (start.key.compareTo(k) > 0) {
            start.llink = removeHelper(start.llink, k);
        }
        else if (start.key.compareTo(k) < 0) {
            start.rlink = removeHelper(start.rlink, k);
        }
        else { // Found it
            if (start.hasNoChildren()){
                return null;
            }
            else if (start.llink == null){
                return start.rlink;
            }
            else{
                BSTNode<Key, T> temp = getMax(start.llink);
                start.data = temp.data;
                start.key = temp.key;
                start.llink = deleteMax(start.llink);
            }

        }
        return start;
    }


    /**
     * Get the maximum node of a subtree
     * @param start starting node
     * @return the maximum node of subtree with start as its root
     */
    private BSTNode<Key, T> getMax(BSTNode<Key, T> start) {
        if (start.rlink == null){
            return start;
        }
        return getMax(start.rlink);
    }

    /**
     * Delete the maximun node of a subtree
     * @param start starting node
     * @return the deleted node
     */
    private BSTNode<Key, T> deleteMax(BSTNode<Key, T> start) {
        if (start.rlink == null){
            return start.llink;
        }
        start.rlink = deleteMax(start.rlink);
        return start;
    }

    /**
     * String representation of BST
     * @return String representation of BST
     */
    public String toString() {
        String ans = toStringHelper(root);
        return ans;
    }


    /**
     * Recursive helper method
     * @param start starting node
     * @return the string representation built recursively
     */
    private String toStringHelper(BSTNode<Key, T> start)
    {
        String ans = "";
        if (start == null)
        {
            return "";
        }

        ans += toStringHelper(start.llink);
        if (start.key instanceof String && start.data instanceof Integer){
            ans = ans + start.key.toString() + ": " + start.data.toString() + "\n";
        }
        else if (start.key instanceof String && start.data instanceof LinkedList){
            ans = ans + start.key.toString() + " - " + start.data.toString() + "\n";
        }
        else if (start.key instanceof String && start.data instanceof GenericBag){
            ans = ans + start.key.toString() + " - " + start.data.toString() + "\n";
        }
        else {
            ans = ans + start.data.toString() + " ";
        }
        ans += toStringHelper(start.rlink);

        return ans;
    }



}
