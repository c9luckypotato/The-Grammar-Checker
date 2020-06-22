package proj5;

//I was using linkedlist to store synonym, but GrapeScope didn't let me pass so I use Generic Bag as an alternative. I keep this cause if I delete, I would have to delete a bunch of tests.

/**
 *  LINKED LIST CLASS (5/14/2020)
 *  * Linked List are ADT to store data. Each element is a node that is linked to different node through its instance variable next in ListNode class.
 *  * @author Quoc (Jordan) An
 *  * @version 1
 *  * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 *  * accordance with the Union College Honor Code and the course syllabus.
 */

public class LinkedList<T>
{
    private int length;
    private ListNode<T> firstNode;

    /**
     * Create an empty LinkedList
     */
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }


    /**
     * Get the length of the list
     * @return length of the list
     */
    public int getLength()
    {
        return length;
    }


    /**
     * Helper method to check if the index the user entered is a valid one
     * @param index the index
     * @return true if the index is valid, false if not (with 0 index as the first node)
     */
    private boolean validIndex(int index){
        return index >= 0 && index < this.getLength();
    }


    /**
     * Check if the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return firstNode == null;
    }


    /**
     * Remove a node at a particular index
     * @param index the index
     */
    public void removeAtIndex (int index){
        if (validIndex(index)) {
            if (index == 0){
                this.firstNode = this.firstNode.next;
            }
            else {
                ListNode runner = this.firstNode;
                for (int i = 0; i < index - 1; i++) {
                    runner = runner.next;
                }
                runner.next = runner.next.next;
            }
            length--;
        }
    }


    /**
     * Clear the list
     */
    public void clear(){
        length = 0;
        firstNode = null;
    }


    /**
     * Add another linked list to this list tail
     * @param another another linked list
     */
    public void addLinkedListToTail(LinkedList another){
        LinkedList temp = another.copy();
        ListNode runner = this.firstNode;
        if(this.isEmpty()){
            this.firstNode = another.firstNode;
        }
        else {
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = temp.firstNode;
        }
        this.length += another.getLength();
    }


    /**
     * Create a copy of this linked list
     * @return a copy of this linked list
     */
    public LinkedList copy(){
        LinkedList copyList = new LinkedList();
        if (!this.isEmpty()) {
            ListNode copyFirstNode = new ListNode(this.firstNode.data);
            copyList.firstNode = copyFirstNode;
            ListNode runner = firstNode;

            while (runner.next != null) {
//            ListNode copyNode = new ListNode();
                copyList.insertAtTail(runner.next.data);
                runner = runner.next;
            }
        }
        copyList.length = this.getLength();
        return copyList;
    }


    /**
     * Insert a node after an index
     * @param index the index
     * @param newData the data of the node to add
     */
    public void insertAfterIndex(int index, T newData){
        if (validIndex(index)){
            ListNode newNode = new ListNode(newData);
            ListNode runner = firstNode;
            for (int i = 0; i < index; i++){
                runner = runner.next;
            }
            ListNode temp = runner.next;
            runner.next = newNode;
            newNode.next = temp;
            length++;
        }
    }


    /**
     * Insert a node before an index
     * @param index the index
     * @param newData the data of the node to add
     */
    public void insertBeforeIndex(int index, T newData){
        if (validIndex(index)) {
            ListNode newNode = new ListNode(newData);
            if (index == 0) {
                newNode.next = firstNode;
                firstNode= newNode;
            }
            else{
                ListNode runner = firstNode;
                for (int i = 0; i < index - 1; i++){
                    runner = runner.next;
                }
                ListNode temp = runner.next;
                runner.next = newNode;
                newNode.next = temp;

            }
            length++;
        }
    }


    /**
     * Insert a node at the start of linked list
     * @param newData the data of the node to add
     */
    public void insertAtHead(T newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (getLength() == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }


    /** remove and return data at the head of the list
     *
     *  @return the data the deleted node contains.  Returns null if list empty.
     */
    public T removeHead()
    {
        if (!isEmpty()) {
            T head = firstNode.data;
            firstNode = firstNode.next;
            length--;
            return head;
        }
        else{
            return null;
        }
    }


    /** insert data at end of list
     *
     * @param newData new data to be inserted
     */
    public void insertAtTail(T newData)
    {
        ListNode<T> newNode = new ListNode(newData);
        ListNode<T> runner = firstNode;
        if(!isEmpty()) {
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        else{
            firstNode = newNode;
        }
        length++;
    }


    /**
     * search for first occurrence of value and return index where found
     *
     * @param value string to search for
     * @return index where string occurs (first node is index 0).  Return -1 if value not found.
     */
    public int indexOf(T value)
    {
        final int notFoundIndex = -1;

        int indexValue = 0;
        ListNode runner = firstNode;

        if(!isEmpty()) {
            String runnerValue = runner.toString();

            if (runnerValue.equals(value)) {
                return indexValue;
            }

            while (runner.next != null) {
                if (runnerValue.equals(value)) {
                    return indexValue;
                }
                runner = runner.next;
                indexValue++;
                runnerValue = runner.toString();
            }

            if (runnerValue.equals(value)) {
                return indexValue;
            }
        }
        else{
            return notFoundIndex;
        }
        return notFoundIndex;
    }


    /**
     * Get the data of the node at a certain index
     * @param index the index
     * @return the data of the node at that index
     */
    public T search (int index){
        if (validIndex(index)){
            ListNode runner = this.firstNode;
            for (int i = 0; i < index; i++){
                runner = runner.next;
            }
            return (T) runner.data;
        }
        else {
            return null;
        }
    }


    /**
     * Compare 2 Linked List.
     * @param other the other linked list
     * @return true if each node of this list contain the same data as the node in the other linked list with the same order. False other wise.
     */
    public boolean equals(LinkedList other) {
        if (this.getLength() == other.getLength()) {
            ListNode thisRunner = firstNode;
            ListNode otherRunner = other.firstNode;
            while (thisRunner != null) {
                if (!thisRunner.data.equals(otherRunner.data)) {
                    return false;
                }
                thisRunner = thisRunner.next;
                otherRunner = otherRunner.next;
            }
            return true;
        }
        return false;
    }


    /**
     * String representation of linked list
     * @return String representation of linked list
     */
	public String toString(){ 
		String toReturn = "{";
		ListNode runner = firstNode;
		while(runner != null){
			toReturn = toReturn + runner;
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn += "}";
		return toReturn;
	}

}


