/*
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL  Output: 5->4->3->2->1->NULL
*/

public class Solution2 {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode next = head.next;
		while (next != null) {
			head.next = prev;
			prev = head;
			head = next;
			next = head.next;
		}
		head.next = prev;
		return head;
	}
}
