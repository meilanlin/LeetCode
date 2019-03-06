/*
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL  Output: 5->4->3->2->1->NULL
*/

public class Solution1 {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = head;
		while (next != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
