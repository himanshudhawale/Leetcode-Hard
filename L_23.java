/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length ==1)
            return lists[0];
        // ListNode head = mergeLists(lists[0],lists[1]);
        for(int i=1;i<lists.length;i++)
        {
            lists[0] = mergeLists(lists[0],lists[i]);
        }
        
        return lists[0];
        
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2)
    {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
   
        ListNode head = new ListNode(-1);
        ListNode h = head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                h.next = l1;
                h = h.next;
                l1=l1.next;
            }
            else{
                h.next=l2;
                h= h.next;
                l2=l2.next;
            }
        }
        if(l1==null)
            h.next=l2;
        if(l2==null)
            h.next=l1;
        
        return head.next;
    }
}