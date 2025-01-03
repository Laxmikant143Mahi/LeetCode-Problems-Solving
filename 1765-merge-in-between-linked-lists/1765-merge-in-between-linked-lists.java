
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode left = list1;
        ListNode right = list1;


        for(int i=1; i<=b; i++){

            if(i<a){
                left = left.next;
            }

            right = right.next;
        }
       

        left.next = list2;

        while(list2.next!=null){

            list2 = list2.next;
        }

        list2.next = right.next;
        
        return list1;
    }
}