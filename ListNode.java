package proj5;

/**
 * *  LIST NODE CLASS (5/14/2020)
 *
 *  * The ListNode class is more data-specific than the proj3.LinkedList class.  It
 *  * details what a single node looks like.  This node has one data field,
 *  * holding a pointer to a String object.
 *
 *  * @author Quoc (Jordan) An
 *  * @version 1
 *  * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 *  * accordance with the Union College Honor Code and the course syllabus.
 *
 */

public class ListNode<T>
{
    public T data;
    public ListNode next;

    /**
     * Create a list node with data
     * @param new_data the data of the new list node
     */
    public ListNode(T new_data)
    {
        data = new_data;
        next = null;
    }

    /**
     * String representation of list node
     * @return String representation of list node
     */
    public String toString(){
    	return data.toString();
    }

}
