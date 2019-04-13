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
        PriorityQueue<ListNode> currList = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) {
                    return -1;
                }
                return 1;
            }
        });
        
        for (int i = 0;i < lists.length;i++) {
            if (lists[i] != null) {
                currList.add(lists[i]);
            }
        }
        
        ListNode root = null;
        ListNode curr = null;
        
        while (!currList.isEmpty()) {
            ListNode currNode = currList.poll();
            if (root == null) {
                root = currNode;
            } else {
                curr.next = currNode;
            }
            curr = currNode;
            if (currNode.next != null) {
                currList.add(currNode.next);
            }
        }
        
        return root;
    }
}