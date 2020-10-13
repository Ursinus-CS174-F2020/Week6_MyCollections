/**
 * Our very own linked list collection class!  
 * @param <Item> We use a "generic" so that it can be a list of any object type
 */
public class LinkedList<Item> {
    
    /**
     * An "inner class" that's only accessible from within LinkedList.
     * This encapsulates what it means to be a node in a list
     */
    private class Node {
        private Node next; // Reference to next node
        private Item value; // What's being stored in this node
        /**
         * Make a new node to store a particular value
         * with a null next pointer by default
         * @param value Value to store
         */
        public Node(Item value) {
            next = null;
            this.value = value;
        }
        /**
         * Update the reference pointer to point to this node
         * @param newRef Node to which to point
         */
        public void updateReference(Node newRef) {
            next = newRef;
        }
        /**
         * Update the value stored at this node
         * @param value Value to store
         */
        public void setValue(Item value) {
            this.value = value;
        }
        /**
         * Return the item stored at this node
         * @return Item
         */
        public Item getValue() {
            return value;
        }
    }
    
    private Node head; // All the linked list needs for us to 
    // iterate through it is a reference to the head node, 
    // which is null by defalut
    public LinkedList() {
        head = null;
    }
    
    /**
     * Add a new node to the linked list.  If the list is empty (i.e.
     * the head is null), then simply make the head point to this new node.
     * Otherwise, walk through the list until we get to the end, and add
     * the new node there
     * @param value 
     */
    public void add(Item value) {
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }
        else {
            Node node = head;
            // Go until I find the end of the list
            // where the arrow points to nothing
            while (node.next != null) {
                node = node.next;
            }
            node.updateReference(newNode);
        }
    }
    
    @Override
    /**
     * Output all of the elements in the list separated by a space
     */
    public String toString() {
        String ret = "";
        Node node = head;
        while (node != null) {
            ret += node.getValue() + " ";
            node = node.next;
        }
        return ret;
    }
    
    /**
     * Delete the first item and return the value
     * that it was holding
     * @return 
     */
    public Item removeFirst() {
        Item value = head.value;
        //head.next = head.next.next;
        head = head.next;
        return value;
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(5);
        list.add(0);
        System.out.println(list);
        for (int i = 0; i < 3; i++) {
            System.out.println(list.removeFirst());
            System.out.println(list);     
        }

    }
}
