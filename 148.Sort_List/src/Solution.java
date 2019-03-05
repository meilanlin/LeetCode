/*
Sort a linked list in O(n log n) time using constant space complexity.
Example 1:
Input: 4->2->1->3  Output: 1->2->3->4
Example 2:
Input: -1->5->3->4->0  Output: -1->0->3->4->5
*/
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// because the questoin require O(nlogn) time, so I need use merge sort
		ListNode result = split(head);
		return result;
	}

	public ListNode split(ListNode head) {
		if (head.next == null) {
			return head;
		}

		ListNode mid = findMid(head);
		ListNode newHead = mid.next;
		mid.next = null;

		// 这里要有人接受split后的结果
		ListNode head1 = split(head);
		ListNode head2 = split(newHead);

		ListNode result = combine(head1, head2);
		return result;
	}

	public ListNode combine(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(-1);
		ListNode dummy = head;
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
		}

		if (head1 != null) {
			dummy.next = head1;
		} else {
			dummy.next = head2;
		}
		return head.next;
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}