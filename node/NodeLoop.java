import java.util.Set;
import java.util.HashSet;

/**
 * 循环链表的入口节点
 */
class ListNode {
  public int value;
  public ListNode next;
  
  public ListNode(int value) {
     this.value = value;
  }
  
}


public class NodeLoop{
  
  public static ListNode entryLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (pHead != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
  }
  
  public static ListNode entryLoop2(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //当快指针 与 慢指针相遇时
            if (fast == slow) {
                fast = pHead;
                //再次相遇
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
  }
  
}
