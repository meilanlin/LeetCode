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

public class Solution4 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Write your solution here
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}

		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode dummy = head;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			// if the sum is 2位，把个位存进去，进的十位留到下次使用
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			dummy.next = new ListNode(sum);
			dummy = dummy.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int sum = l1.val + carry;
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			dummy.next = new ListNode(sum);
			dummy = dummy.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			int sum = l2.val + carry;
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			dummy.next = new ListNode(sum);
			dummy = dummy.next;
			l2 = l2.next;
		}

		if (carry == 1) {
			dummy.next = new ListNode(1);
		}

		return head.next;
	}
}