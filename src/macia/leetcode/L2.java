package macia.leetcode;

/**
 * @author zengguosheng
 * @Date 2022/8/10 15:14
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class L2 {

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

    public static void main(String[] args) {
        L2 l2 = new L2();
        l2.test();
    }
    public void test() {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        long nodeVal = solution.getNodeVal(listNode);
        System.out.printf("节点解析结果: %d \n",nodeVal);
//        // [1,9,9,9,9,9,9,9,9,9]
//        // 9
//        ListNode l1 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
//        ListNode l2 = new ListNode(9);
//        long nodeVal = solution.getNodeVal(solution.generateNode(solution.getNodeVal(l1) + solution.getNodeVal(l2)));
//        System.out.println(nodeVal);
    }


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int l1V = 0, l2V = 0, sum = 0;
                l1V = l1 == null ? 0 : l1.val;
                l2V = l2 == null ? 0 : l2.val;
                sum = l1V + l2V + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return pre.next;
        }

        public long getNodeVal(ListNode listNode) {
            long i = 1;
            long sum = 0;
            do {
                sum = sum + i * listNode.val;
                listNode = listNode.next;
                i = i * 10;
            } while (listNode != null);
            return sum;
        }

        public ListNode generateNode(long val) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            do{
                int cVal = (int) (val % 10);
                cur.next = new ListNode(cVal);
                cur = cur.next;
                val = val /10;
            }while (0 != val);

            return pre.next;
        }
    }

}
