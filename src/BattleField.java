
public class BattleField {
    public static void main(String[] args) {
        Solution solution= new Solution();
        LeetCodeListNode one= new LeetCodeListNode(1);
        LeetCodeListNode two= new LeetCodeListNode(2);
        LeetCodeListNode three= new LeetCodeListNode(3);
        LeetCodeListNode four= new LeetCodeListNode(4);
        one.next=three;
        two.next=four;
        LeetCodeListNode list1= one;
        LeetCodeListNode list2= two;
        LeetCodeListNode node =  solution.mergeTwoLists(list1,list2);
        while(node!=null)
        {
            System.out.print(node.val);
            node=node.next;
            System.out.print("->");
        }
    }
}

   class LeetCodeListNode {
      int val;
      LeetCodeListNode next;
      LeetCodeListNode() {}
      LeetCodeListNode(int val) { this.val = val; }
      LeetCodeListNode(int val, LeetCodeListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public LeetCodeListNode mergeTwoLists(LeetCodeListNode list1, LeetCodeListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        LeetCodeListNode start=list1.val>list2.val?list2:list1;
        LeetCodeListNode pointer=new LeetCodeListNode();
        while(list1!=null && list2!=null){


            if(list1.val<list2.val){
                pointer=list1;
                list1=list1.next;

            }
            else{
                pointer=list2;
                list2=list2.next;
            }
            pointer=pointer.next;
        }
        if(pointer!=null){
            if(list1==null)
                pointer=list2;
            else
                pointer=list1;
        }
        return start;
    }
}