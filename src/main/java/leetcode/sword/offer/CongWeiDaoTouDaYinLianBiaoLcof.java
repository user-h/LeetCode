package leetcode.sword.offer;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 53 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args){
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        for (int i : solution.reversePrint(listNode)) {
            System.out.println(i);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        return reversePrint3(head);
    }
    /**
     * 4.用字符串怎么样[6.06 89.16] [8.77 77.74]
     */
    public int[] reversePrint4(ListNode head) {
        ListNode ln = head;                             // 指针节点
        if (ln == null) {return new int[0];}

        StringBuilder sb = new StringBuilder();
        while (ln != null) {
            sb.append(ln.val).append(' ');
            ln = ln.next;
        }
        sb.deleteCharAt(sb.length()-1);

        String[] strs = sb.toString().split(" ");
        int length = strs.length;       // 呃...字符串数组为什么不能强转为int数组0.0
        int[] ints = new int[length];
        int i = length-1;
        while ( i >= 0 ) {  // 2
            ints[i] = Integer.parseInt(strs[length-1-i]);     // 2 0
            i--;
        }
        return ints;
    }

        /**
         * 3. 官方解法 使用栈 [43.95 31.93]    [43.95 36.44]
         */
    public int[] reversePrint3(ListNode head) {
        Stack<Integer> stack = new Stack<>();           // 创建栈

        ListNode ln = head;                             // 指针节点
        while (ln != null) {        // 遍历入栈
            stack.push(ln.val);
            ln = ln.next;
        }

        int[] ints = new int[stack.size()];          // 根据栈的大小创建数组
        for (int i = 0; i < ints.length; i++) {      // 出栈给数组赋值
            ints[i] = stack.pop();
        }

        return ints;
    }

    /**
     * 2.遍历两次 [100 31.33] [100 97.54] [100 34.45]
     */
    public int[] reversePrint2(ListNode head) {
        ListNode ln = head;                     // 指针节点

        int index = 0;
        while (ln != null) {                    // 遍历一次获取长度
            index ++;
            ln = ln.next;
        }

        int[] ints = new int[index];
        ln = head;                              // 指针位置 置回头节点
        for (int i = index-1; ln!=null; i--) {          // 再次遍历 反向给数组赋值
            ints[i] = ln.val;
            ln = ln.next;
        }
        return ints;
    }

    /**
     * 1.放入集合转数组(麻烦了) [6.06 14.71]
     */
    public int[] reversePrint1(ListNode head) {
        ListNode ln = head;
        //int[] nums = new int[100];
        List list = new LinkedList<Integer>();
        while (ln != null) {
            list.add(0, ln.val);
            ln = ln.next;
        }
        // 解决方法1：采用流式处理Stream进行处理
        int[] ints = list.stream().mapToInt(value -> Integer.valueOf((Integer) value)).toArray();
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
}