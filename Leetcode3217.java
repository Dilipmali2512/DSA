import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3217 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        int map[] = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = nums[i];
        }

        ListNode tempNode = head;
        ListNode preNode = null;

        while (tempNode != null) {
            if (map[tempNode.val] != 0) {
                ListNode temp = tempNode.next;
                if (preNode == null) {
                    head = tempNode.next;
                } else {
                    preNode.next = tempNode.next;
                }
                tempNode = temp;
            } else {
                preNode = tempNode;
                tempNode = tempNode.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        // -1,5,3,4,0
        int list[] = new int[] { 5 };
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(2, null);
        node1 = node1.next;
        node1.next = new ListNode(3, null);
        node1 = node1.next;
        node1.next = new ListNode(4, null);
        // node1 = node1.next;
        // node1.next = new ListNode(1, null);
        // node1 = node1.next;
        // node1.next = new ListNode(2, null);
        // node1 = node1.next;
        // node1.next = new ListNode(4, null);
        // node1 = node1.next;
        // node1.next = new ListNode(-1, null);

        ListNode ans = modifiedList(list, head1);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}