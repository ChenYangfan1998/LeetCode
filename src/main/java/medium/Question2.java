package medium;

/**
 * 这个代码真是异常僵硬...
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(l1.val + l2.val);
        int flag = 0;
        if (node.val >= 10) {
            node.val-=10;
            flag = 1;
        }
        ListNode result = node;

        while (null != l1.next || null != l2.next) {

            int val1 = (l1.next == null ? 0 : l1.next.val);
            int val2 = (l2.next == null ? 0 : l2.next.val);

            l1 = (l1.next == null ? l1 : l1.next);
            l2 = (l2.next == null ? l2 : l2.next);

            ListNode next = new ListNode(val1 + val2 + flag);
            if (next.val >= 10) {
                next.val -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            node.next = next;
            node = next;
        }

        if (flag == 1) {
            node.next = new ListNode(1);
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}


