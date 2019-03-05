
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		// justify wheather has a cycle
		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;
		// there should use &&, not ||
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isCycle = true;
				break;
			}
		}

		// find the entrance of the cycle
		if (isCycle) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next; // the speed of fast pointer should be same a the slow pointer
			}
			return slow;
		} else {
			return null;
		}

	}
}