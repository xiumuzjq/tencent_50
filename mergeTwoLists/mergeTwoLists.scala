/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
        val dummy = new ListNode()
        
        var cur = dummy
        
        var (c1, c2) = (l1, l2)
        var (n1, n2) = (0, 0)
        
        while (c1 != null && c2 != null) {
            n1 = if (c1 != null) c1.x else Int.MaxValue
            n2 = if (c2 != null) c2.x else Int.MaxValue
            
            if (n1 < n2) {
                cur.next = new ListNode(n1)
                c1 = c1.next
            } else {
                cur.next = new ListNode(n2)
                c2 = c2.next
            }
            
            cur = cur.next
        }
        
        if (c1 == null) cur.next = c2 else cur.next = c1
        
        dummy.next
    }
}
