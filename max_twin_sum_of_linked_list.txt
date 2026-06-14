class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }

        int ans = 0;
        ListNode left = prev, right = slow;

        while (left != null) {
            ans = Math.max(ans, left.val + right.val);
            left = left.next;
            right = right.next;
        }

        return ans;
    }
}