/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MostEfficientLinkedListReverse {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head!=null)
        {
            ListNode node = new ListNode(head.val);
            node.next = newHead;
            newHead = node;
            head = head.next;
        }
        return newHead;
    }
}
