/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Runtime 21 ms
Memory  48.1 MB
*/

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}

		ListNode head = new ListNode(0);
		ListNode dummy = new ListNode(0);
		head.next = dummy;
		ListNode cur = dummy;

		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 == null) {
				sum = l2.val + dummy.val;
			} else if (l2 == null) {
				sum = l1.val + dummy.val;
			} else {
				sum = l1.val + l2.val + dummy.val;
			}

			if (sum < 10) {
				dummy.val = sum;
				dummy.next = new ListNode(0);
			} else {
				sum = sum % 10;
				dummy.val = sum;
				dummy.next = new ListNode(1);
			}

			cur = dummy;
			dummy = dummy.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}

		if (cur.next.val == 0) {
			cur.next = null;
		}
		return head.next;
	}
}