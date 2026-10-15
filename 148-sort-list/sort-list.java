/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode second = p1.next;
        p1.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(second);

        return merge(list1, list2);
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode curr = temp;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if(list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return temp.next;
    }
}