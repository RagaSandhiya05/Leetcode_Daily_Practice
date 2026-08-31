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

// Find the Minimum and Maximum Number of Nodes Between Critical Points
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int FirstCritical = -1;
        int LastCritical = -1;
        int MinDist = Integer.MAX_VALUE;
        while(curr.next != null) {
            ListNode next = curr.next;
            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;
            if(isMax || isMin) {
                if(LastCritical == -1) {
                    FirstCritical = index;
                }
                else {
                    MinDist = Math.min(MinDist, index - LastCritical);
                }
                LastCritical = index;
            }
            prev = curr;
            curr = next;
            index++;
        }
        if(FirstCritical == -1 || FirstCritical == LastCritical) {
            return new int[]{-1, -1};
        }
        int MaxDist = LastCritical - FirstCritical;
        return new int[]{MinDist, MaxDist};
    }
}
