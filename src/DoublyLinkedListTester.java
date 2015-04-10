/*
   4/10/15 junit test class for the
   DoublyLinkedList
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class DoublyLinkedListTester {
	
	@Test
	public void prependTester() {
		DoublyLinkedList<Integer> p1 = new DoublyLinkedList<Integer>();
		assertEquals(0, p1.size());
		p1.prepend(1);
		// Prepend has 2 cases
		// Case 1: e is empty list
		assertEquals("[1]" , p1.toString());
		assertEquals("[1]" , p1.toStringReverse());
		assertEquals(1, p1.size());
		// Case 2: e is not an empty list
		p1.prepend(2);
		assertEquals("[2, 1]" , p1.toString());
		assertEquals("[1, 2]" , p1.toStringReverse());
		assertEquals(2, p1.size());
	}
	
	@Test
	public void appendTester() {
		DoublyLinkedList<Integer> a1 = new DoublyLinkedList<Integer>();
        assertEquals("[]", a1.toString());
        assertEquals("[]", a1.toStringReverse());
		assertEquals(0, a1.size());
		// Append has 2 cases
		// Case 1: e is empty list
		a1.append(1);
		assertEquals("[1]" , a1.toString());
		assertEquals("[1]" , a1.toStringReverse());
		assertEquals(1, a1.size());
		// Case 2: e is not an empty list
		a1.append(2);
		assertEquals("[1, 2]" , a1.toString());
		assertEquals("[2, 1]" , a1.toStringReverse());
		assertEquals(2, a1.size());
	}
	
	@Test
	public void insertBeforeTester() {
		DoublyLinkedList<Integer> ib = new DoublyLinkedList<Integer>();
        assertEquals("[]", ib.toString());
        assertEquals("[]", ib.toStringReverse());
		assertEquals(0, ib.size());
		ib.append(1);
		assertEquals("[1]", ib.toString());
        assertEquals("[1]", ib.toStringReverse());
		assertEquals(1, ib.size());
		// 2 cases for insert before:
		// Case 1: e is first element in list
		ib.insertBefore(5, ib.getHead());
		assertEquals("[5, 1]", ib.toString());
		assertEquals("[1, 5]" , ib.toStringReverse());
		assertEquals(2, ib.size());
		// Case 2: e is not the first element in list
		ib.insertBefore(7, ib.getHead().successor());
		assertEquals("[5, 7, 1]", ib.toString());
		assertEquals("[1, 7, 5]" , ib.toStringReverse());
		assertEquals(3, ib.size());
	}
	
	@Test
	public void insertAfterTester() {
		DoublyLinkedList<Integer> ia = new DoublyLinkedList<Integer>();
        assertEquals("[]", ia.toString());
        assertEquals("[]", ia.toStringReverse());
		assertEquals(0, ia.size());
		ia.append(1);
		assertEquals("[1]", ia.toString());
        assertEquals("[1]", ia.toStringReverse());
		assertEquals(1, ia.size());
		// 2 cases for insert after:
		// Case 1: e is the last element in the list
		ia.insertAfter(3, ia.getTail());
		assertEquals("[1, 3]", ia.toString());
		assertEquals("[3, 1]" , ia.toStringReverse());
		assertEquals(2, ia.size());
		// Case 2: e is not the last element in the list
		ia.insertAfter(4, ia.getTail().predecessor());
		assertEquals("[1, 4, 3]", ia.toString());
		assertEquals("[3, 4, 1]" , ia.toStringReverse());
		assertEquals(3, ia.size());
	}
	
	@Test
	public void removeTester() {
		DoublyLinkedList<Integer> r1 = new DoublyLinkedList<Integer>();
        assertEquals("[]", r1.toString());
        assertEquals("[]", r1.toStringReverse());
		assertEquals(0, r1.size());
		r1.append(1);
		assertEquals("[1]", r1.toString());
        assertEquals("[1]", r1.toStringReverse());
		assertEquals(1, r1.size());
		// Remove has 4 cases
		// Case 1: e is only node
		r1.remove(r1.getHead());
		assertEquals("[]", r1.toString());
		assertEquals("[]" , r1.toStringReverse());
		assertEquals(0, r1.size());
		// Rebuild List
		r1.append(1);
		r1.append(2);
		r1.append(3);
		r1.append(4);
		r1.append(5);
		assertEquals("[1, 2, 3, 4, 5]", r1.toString());
        assertEquals("[5, 4, 3, 2, 1]", r1.toStringReverse());
		assertEquals(5, r1.size());
		//
		// Case 2: e is first node
		r1.remove(r1.getHead());
		assertEquals("[2, 3, 4, 5]", r1.toString());
		assertEquals("[5, 4, 3, 2]" , r1.toStringReverse());
		assertEquals(4, r1.size());
		// Case 3: e is last node
		r1.remove(r1.getTail());
		assertEquals("[2, 3, 4]", r1.toString());
		assertEquals("[4, 3, 2]" , r1.toStringReverse());
		assertEquals(3, r1.size());
		// Case 4: e is between two nodes
		r1.remove(r1.getTail().predecessor());
		assertEquals("[2, 4]", r1.toString());
		assertEquals("[4, 2]" , r1.toStringReverse());
		assertEquals(2, r1.size());
	}
	
	@Test
	public void allTester() {
		DoublyLinkedList<Integer> A = new DoublyLinkedList<Integer>();
        assertEquals("[]", A.toString());
        assertEquals("[]", A.toStringReverse());
		assertEquals(0, A.size());
		// Append
		A.append(1);
		assertEquals("[1]", A.toString());
        assertEquals("[1]", A.toStringReverse());
		assertEquals(1, A.size());
		A.append(2);
		assertEquals("[1, 2]", A.toString());
        assertEquals("[2, 1]", A.toStringReverse());
		assertEquals(2, A.size());
		// Remove
		A.remove(A.getHead());
		A.remove(A.getHead());
		assertEquals("[]", A.toString());
        assertEquals("[]", A.toStringReverse());
		assertEquals(0, A.size());
		// Prepend
		A.prepend(2);
		assertEquals("[2]", A.toString());
        assertEquals("[2]", A.toStringReverse());
		assertEquals(1, A.size());
		A.prepend(1);
		assertEquals("[1, 2]", A.toString());
        assertEquals("[2, 1]", A.toStringReverse());
		assertEquals(2, A.size());
		// Remove
		A.remove(A.getTail());
		assertEquals("[1]", A.toString());
        assertEquals("[1]", A.toStringReverse());
		assertEquals(1, A.size());
		// Insert Before
		A.insertBefore(0, A.getHead());
		assertEquals("[0, 1]", A.toString());
        assertEquals("[1, 0]", A.toStringReverse());
		assertEquals(2, A.size());
		A.insertBefore(5, A.getTail());
		assertEquals("[0, 5, 1]", A.toString());
        assertEquals("[1, 5, 0]", A.toStringReverse());
		assertEquals(3, A.size());
		// Remove
		A.remove(A.getHead());
		A.remove(A.getHead());
		assertEquals("[1]", A.toString());
        assertEquals("[1]", A.toStringReverse());
		assertEquals(1, A.size());
		// Insert After
		A.insertAfter(3, A.getHead());
		assertEquals("[1, 3]", A.toString());
        assertEquals("[3, 1]", A.toStringReverse());
		assertEquals(2, A.size());
		A.insertAfter(2, A.getHead());
		assertEquals("[1, 2, 3]", A.toString());
        assertEquals("[3, 2, 1]", A.toStringReverse());
		assertEquals(3, A.size());
		// Remove all
		A.remove(A.getHead());
		A.remove(A.getTail());
		A.remove(A.getHead());
		assertEquals("[]", A.toString());
        assertEquals("[]", A.toStringReverse());
		assertEquals(0, A.size());
		// Testing different types
		DoublyLinkedList<String> S1 = new DoublyLinkedList<String>();
		S1.prepend("a");
		assertEquals("[a]", S1.toString());
		assertEquals("[a]", S1.toStringReverse());
		assertEquals(1, S1.size());
	}
}
