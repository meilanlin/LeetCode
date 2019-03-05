/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Runtime 19 ms
Memory  48.1 MB
*/

class Solution1 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}

		ListNode head = new ListNode(0);
		ListNode dummy = head;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum = sum / 10; // ÄÃµ½½øÎ»

			if (l1 != null) {
				sum = l1.val + sum;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum = l2.val + sum;
				l2 = l2.next;
			}
			dummy.next = new ListNode(sum % 10);
			dummy = dummy.next;
		}

		if (sum >= 10) {
			dummy.next = new ListNode(1);
		}

		return head.next;
	}
}