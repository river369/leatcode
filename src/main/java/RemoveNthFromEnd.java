public class RemoveNthFromEnd {

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode current = root;
        for (int i=2; i<=5; i++) {
            ListNode li = new ListNode(i);
            current.next = li;
            current = li;
        }
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        current=removeNthFromEnd.removeNthFromEnd(root, 2);
        while( current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        int toBeProcessedNode = 0;
        if (head == null) return head;

        // count the length
        ListNode current = head;
        while( current != null) {
            System.out.println(current.val);
            current = current.next;
            length++;
        }
        System.out.println("list node length = " + length);
        if (n > length) return null;
        toBeProcessedNode =  length - n;
        System.out.println("To be removed pre = " + toBeProcessedNode);

        //remove item
        current = head;
        int pointer = 1;
        while(pointer<toBeProcessedNode) {
            pointer++;
            current = current.next;
        }

        if (toBeProcessedNode ==0) return current.next;
        current.next = current.next.next;
        return head;
    }

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


}


