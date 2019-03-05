/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Runtime 20 ms
Memory  48.2 MB
*/

class Solution3 {
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

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + dummy.val;
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
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null) {
			cur = addLast(l1, dummy);
		}

		if (l2 != null) {
			cur = addLast(l2, dummy);
		}

		if (cur.next.val == 0) {
			cur.next = null;
		}
		return head.next;
	}

	public ListNode addLast(ListNode l, ListNode dummy) {
		ListNode cur = dummy;
		while (l != null) {
			int sum = l.val + dummy.val;
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
			l = l.next;
		}
		return cur;
	}
}