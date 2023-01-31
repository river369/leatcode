import java.util.ArrayList;
import java.util.Collections;

public class MergeLists {
    public static void main(String[] args){
        MergeLists mergeLists  = new MergeLists();
        ListNode ret = mergeLists.mergeKLists(mergeLists.builder());
        while (ret.next != null){
            System.out.println(ret.val);
            ret = ret.next;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode(0);
        ListNode currentRet = ret;
        int listLength  = lists.length;
        if (listLength == 0) return null;

        boolean[] complete = new boolean[listLength];
        int completeNumber = 0;
        while(completeNumber < listLength) {
            //System.out.println("completeNumber="+completeNumber);
            int selectedNumber = Integer.MAX_VALUE;
            int selectedList = -1;
            for (int i = 0; i< listLength; i++){
                //System.out.println("i="+i+" lists[i].val="+lists[i].val);
                if (complete[i]) continue;
                if (lists[i] == null) {
                    completeNumber++;
                    complete[i] = true;
                    continue;
                }
                if(lists[i].val < selectedNumber) {
                    selectedNumber = lists[i].val;
                    selectedList = i;
                }
            }
            //System.out.println("selectedList="+selectedList);
            if (selectedList >= 0 ) {
                ListNode newNode = new ListNode(lists[selectedList].val);
                currentRet.next = newNode;
                currentRet = currentRet.next;
                if(lists[selectedList].next == null){
                    completeNumber++;
                    complete[selectedList] = true;
                } else {
                    lists[selectedList] = lists[selectedList].next;
                }
            }
        }
        return ret.next;
    }

    public ListNode[] builder(){
        int[][] a2  = new int[][]{
                {1,3,5} ,  {0,2,4} ,  {3,6,9}
        };
        ListNode[] ln = new ListNode[a2.length];
        int row = 0;
        for (int[] a1 : a2) {
            ListNode listNode = new ListNode();
            ListNode current = listNode;
            for(int i : a1) {
                current.next = new ListNode(i);
                current = current.next;
            }
            ln[row] = listNode.next;
            row++;
        }

        /*
        for(int j  = 0; j< arrayLength; j++){
            ArrayList<Integer> al = new ArrayList<Integer>();
            int length = (int)(Math.random()*18);
            for(int i  = 0; i< length; i++){
                al.add((int)(Math.random()*20));
            }
            Collections.sort(al);
            System.out.println("_"+al);

            ListNode listNode = new ListNode(0);
            ListNode current = listNode;
            for(Integer i : al) {
                current.next = new ListNode(i);
                current = current.next;
            }
            ln[j] = listNode.next;
        }
        */
        return ln;
    }


}
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


