//package at.jku.pervasive.swe14.UE12.linearList;

class List {
	ListNode head;
	ListNode tail; // only for 'rotate'

	List() { 
		head = null;
		tail = null; // only for 'rotate'
	}

	void deleteNegatives() {
		ListNode prev = null, n = head;

		while (n != null) { 
			if (n.val < 0) {
				if (prev == null) // special case: remove first element
					head = n.next;
				else
					prev.next = n.next;
			}
			else
				prev=n;
			// if (n != null)  -> if not required; n still points to an element
			n = n.next;
		}
	}

	void rotate(int n) {

		if (head == tail) {
			return;
		}

		tail.next = head;
		for (int i = 0; i < n; i ++) {
			//tail.next = head;
			head      = head.next;
			tail      = tail.next;
			//tail.next = null;
		}
		tail.next = null;
	}

} // List
