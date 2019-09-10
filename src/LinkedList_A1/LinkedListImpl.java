/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
 */
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node root;// this will be the entry point to your linked list (the head)

	public LinkedListImpl() {// this constructor is needed for testing purposes.
								// Please don't modify!
		root = new Node(0); // Note that the root's data is not a true part of
							// your data set!
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to
							// grab your linkedList easily.
		return root;
	}

	@Override
	public boolean insert(Node n, int index) {
		if (index == 0) { // Two conditions: one at the first element and one
							// that is not at the first element
			if (n == null || index <= -1) { // When we are at the first element,
											// we cannot use (index - 1) because
											// that will result in null due to
											// the error testing mechanism in
											// get()
				return false;
			} else {
				n.next = get(0);
				this.root.next = n;
				return true;
			}
		} else {
			if (this.get(index - 1) == null || n == null || index <= -1) {
				return false;
			} else {
				n.next = get(index);
				this.get(index - 1).next = n;
				return true;
			}
		}
	}

	@Override
	public boolean remove(int index) {
		if (this.get(index) == null || index <= -1) { // Error test
			return false;
		} else if (index == 0) {
			this.root.next = this.get(1);
			return true;
		} else {
			this.get(index - 1).next = this.get(index + 1);
			return true;
		}
	}

	@Override
	public Node get(int index) {
		Node currentNode = root;
		if (index < 0 || index >= this.size()) { // Test if index is out of
													// bound
			return null;
		}
		for (int i = -1; i < index; i++) {
			currentNode = currentNode.getNext();
			if (currentNode == null) {
				break;
			}
		}
		return currentNode;
	}

	@Override
	public int size() {
		Node currentNode = root;
		int sizeOfList = -1; // We do not need to count the root.
		while (currentNode != null) {
			currentNode = currentNode.getNext();
			sizeOfList++;
		}
		return sizeOfList;
	}

	@Override
	public boolean isEmpty() {
		if (root.getNext() == null) { // If the next item of root is null,
										// then the list is empty
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		root.next = null; // Make everything after root (the very first node)
							// null will result in cutting everything after root
	}
}