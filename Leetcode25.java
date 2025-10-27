public class Leetcode25 {

    public class ListNode {
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

    public static ListNode reverseOrder(ListNode tempHead, ListNode mainHead) {
        ListNode nextNode = tempHead.next;
        tempHead.next = null;
        ListNode head = mainHead;
        ListNode prev = mainHead;
        mainHead = mainHead.next;
        while (mainHead != null) {
            ListNode temp = mainHead.next;
            mainHead.next = prev;
            prev = mainHead;
            mainHead = temp;
        }
        head.next = nextNode;
        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        int step = 1;
        ListNode tempHead = head;
        ListNode mainHead = head;
        ListNode returnMainNode = null;
        ListNode prevMainHead = head;
        int i = 0;
        while (tempHead.next != null) {
            // if (step == 1)
            // prevMainHead = mainHead;
            step++;
            tempHead = tempHead.next;
            if (step == k) {
                ListNode newTempNode = reverseOrder(tempHead, mainHead);
                tempHead = prevMainHead.next;
                mainHead = prevMainHead.next;
                if (i == 0) {
                    returnMainNode = newTempNode;
                } else {
                    prevMainHead.next = newTempNode;
                }
                step = 1;
                i++;
            }
        }

        return returnMainNode;
    }

    public static void main(String[] args) {

    }
}
