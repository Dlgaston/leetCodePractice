import java.sql.SQLOutput;

public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //l1 == [1,2,4]
    //l2 == [3,5,6]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {

            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l2_2 = new ListNode(5);
        ListNode l2_3 = new ListNode(6);
        l1.next = l1_2;
        l1_2.next = l1_3;
        l2.next = l2_2;
        l2_2.next = l2_3;
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode result = mergeTwoSortedList.mergeTwoLists(l1, l2);


    }

}

