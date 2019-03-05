// LeetCode #86 (Partition List).

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode smallCur = small;
		ListNode largeCur = large;
		while (head != null) {
			if (head.val < x) {
				smallCur.next = head;
				smallCur = smallCur.next;
			} else {
				largeCur.next = head;
				largeCur = largeCur.next;
			}
			head = head.next;
		}
		smallCur.next = large.next;
		// Important!
		largeCur.next = null;
		return small.next;
	}
}