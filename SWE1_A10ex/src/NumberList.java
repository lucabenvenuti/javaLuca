//package at.jku.pervasive.swe14.UE12.numberList;

public class NumberList {
	NumberNode head;
	// adds the new number at the correct position of the sorted list

	public void add(int num) {
		NumberNode q = new NumberNode(num);
		NumberNode p = head, prev = null;

		while (p != null && p.getNum() < num) { // find the location to insert
			prev = p;                        // the new node
			p = p.next;
		}
		q.next = p;

		if (p == head) { // check if the head needs to be changed...
			head = q;
		} else {
			prev.next = q;
		}
	}

	// counts the number of occurrences of the given number
	public int getFrequency(int num) {
		int count = 0;
		NumberNode p = head;

		// go through the list, increase counter if the number is found
		while (p != null && p.getNum() <= num) {
			if (p.getNum() == num) {
				count++;
			}
			p = p.next;
		}
		return count;
	}
}
