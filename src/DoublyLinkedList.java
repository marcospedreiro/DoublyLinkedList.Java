
/*
    Simple doubly linked list
 */

/** An instance is a doubly linked list. */
public class DoublyLinkedList<E> {
    private ListNode head; // first node of linked list (null if none)
    private ListNode tail; // last node of linked list (null if none)

    private int size; // Number of values in linked list.

    /** Constructor: an empty linked list. */
    public DoublyLinkedList() {}

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public ListNode getHead() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public ListNode getTail() {
        return tail;
    }

    /** Return the value of node e of this list.
     * Precondition: e must be a node of this list; it may not be null. */
    public E valueOf(ListNode e) {
        return e.value;
    }

    /** Add value v at the beginning of the list. */
    public void prepend(E v) {
        if(head== null) {
    		head = new ListNode(null, null, v);
    		tail = head;
    	} else {
    		ListNode x = new ListNode(null, head, v);
    		head.pred = x;
    		head = x;
    	}
    	size = size + 1;
    }

    /** Add value v at the end of the list. */
    public void append(E v) {
    	if(tail== null) { 
    		tail = new ListNode(null, null, v);
    		head = tail;
    	} else {
    		ListNode x = new ListNode(tail, null, v);
    		tail.succ = x;
    		tail = x;
    	}
    	size = size + 1;
    }

    /** Insert value v in a new node before node e.
     * Precondition: e must be an node of this list; it may not be null. */
    public void insertBefore(E v, ListNode e) {
    	ListNode x = new ListNode(null, null, v);
        if (e.pred == null) { 
        	head= x;
        	e.pred= x;
            x.succ= e;
        } else {
        	x.pred= e.pred;
        	e.pred.succ= x; 
        	e.pred= x;
        	x.succ= e; 
        }
        size = size + 1;
    }

    /** Insert value v in a new node after node e.
     * Precondition: e must be an node of this list; it may not be null. */
    public void insertAfter(E v, ListNode e) { 
    	ListNode x = new ListNode(null, null, v);
        if (e.succ == null) { 
        	tail= x;
        	x.pred= e;
        	e.succ= x;
        } else {
        	x.pred= e;
        	x.succ= e.succ;
        	e.succ.pred= x;
        	e.succ= x;
        }
        size = size + 1;
    }

    /** Remove node e from this list.
     * Precondition: e must be an node of this list; it may not be null. */
    public void remove(ListNode e) {
    	if(e.pred == null && e.succ == null) {
    		head = null;
    		tail = null;
    	} else if(e.pred == null) {
    		head= e.succ;
    		e.succ.pred= null;	
    		e.succ= null;
    	} else if(e.succ == null) {
    		tail= e.pred;
    		e.pred.succ= null;
    		e.pred= null;
    	} else {
    		e.pred.succ= e.succ;
    		e.succ.pred= e.pred;
    		e.succ= null;
    		e.pred= null;
    	}
    	size = size - 1;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, return "[6, 3, 8]". */
    public @Override String toString() {
    	ListNode x= head;
    	String s= "[";
    	while (x!= null) {
    		if(x.succ!=null) {
    			s= s + x.getValue() + ", ";
    		} else {
    			s= s + x.getValue();
    		}
    		x= x.succ;
    	}
    	return s + "]";
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end.
     * E.g. for the list containing 6 3 8 in that order, return "[8, 3, 6]".*/
    public String toStringReverse() {
    	ListNode x= tail;
    	String s= "[";
    	while (x!= null) {
    		if(x.pred!=null) {
    			s= s + x.getValue() + ", ";
    		} else {
    			s= s + x.getValue();
    		}
    		x= x.pred;
    	}
    	return s + "]";
    }
    
    /*********************/

    /** An instance is a node of this list. */
    public class ListNode {
        /** Predecessor of this node on the list (null if the list is empty). */
        private ListNode pred;

        /** The value of this node. */
        private E value; 

        /** Successor of this node on the list. (null if the list is empty). */
        private ListNode succ; 

        /** Constructor: an instance with predecessor p (p can be null),
         * successor s (s can be null), and value v. */
        private ListNode(ListNode p, ListNode s, E v) {
            pred= p;
            succ= s;
            value= v;
        }

        /** Return the value of this node. */
        public E getValue() {
            return value;
        }
        
        /** Return the predecessor of this node in the list (null if this node
         *  is the first node of this list). */
        public ListNode predecessor() {
            return pred;
        }

        /** Return the successor of this node in the list (null if this node
         *  is the last node of this list). */
        public ListNode successor() {
            return succ;
        }
    }
}
