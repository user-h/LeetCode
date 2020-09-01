package leetcode.editor.cn;//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4825 👎 0

// 两数相加
public class AddTwoNumbers{
    public static void main(String[] args){
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new AddTwoNumbers().new ListNode(2);
        l1.next = new AddTwoNumbers().new ListNode(4);
        l1.next.next = new AddTwoNumbers().new ListNode(3);

        ListNode l2 = new AddTwoNumbers().new ListNode(5);
        l2.next = new AddTwoNumbers().new ListNode(6);
        l2.next.next = new AddTwoNumbers().new ListNode(4);

        ListNode l3 = solution.addTwoNumbers(l1, l2);
        printListNode(l3);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2);
    }

    /**
     * 2.按位置相加 标志位进位
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode listNode1 = l1;    // 指针指向l1
        ListNode listNode2 = l2;    // 指针指向l2
        int flag = 0;   // 标记进位
        ListNode result = new ListNode(0);    // 记总数的链表 初始化节点0(后面要去掉)
        ListNode resultNode = result;           // 结果指针
        int sum;      // 中间和
        int temp1;    // 当前l1的值
        int temp2;    // 当前l2的值
        while (listNode1!=null || listNode2!=null) {
            temp1 = listNode1==null ? 0 : listNode1.val;
            temp2 = listNode2==null ? 0 : listNode2.val;
            sum = temp1 + temp2 + flag;    // 5+5+0
            resultNode.next = new ListNode(sum % 10);       // 10%10s
            flag = sum/10;

            resultNode = resultNode.next;
            if ( listNode1!=null ) listNode1 = listNode1.next;
            if ( listNode2!=null ) listNode2 = listNode2.next;
        }
        if (flag == 1) {
            resultNode.next = new ListNode(1);
        }
        return result.next;
    }
    /*public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        int flag = 0;   // 标记进位
        ListNode result = new ListNode(0);    // 记总数
        ListNode resultNode = result;
        int temp = 0;
        while (listNode1!=null || listNode2!=null) {
            if ( listNode1 == null ) {
                temp = listNode2.val + flag;
            } else if ( listNode2 == null ) {
                temp = listNode1.val + flag;
            } else {
                temp = listNode1.val + listNode2.val + flag;    // 5+5+0
            }
            resultNode.next = new ListNode(temp % 10);       // 10%10s
            flag = temp/10;

            resultNode = resultNode.next;
            listNode1 = listNode1==null?listNode1:listNode1.next;
            listNode2 = listNode2==null?listNode2:listNode2.next;
        }
        if (flag == 1) {
            resultNode.next = new ListNode(1);
        }
        return result.next;
    }*/
    // 2. 结束

    /**
     * 1.链表转化成（int）数字 进行相加
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        int num1 = 0;           // 保存第一个数
        int num2 = 0;           // 保存第二个数
        int index = 0;          // 遍历时的当前下标
        ListNode node = l1;     // 遍历时的当前节点
        while (node!=null) {
            num1 += node.val * Math.pow(10, index);
            node = node.next;
            index ++;
        }
        // System.out.println(num1);

        node = l2;
        index = 0;
        while (node!=null) {
            num2 += node.val * Math.pow(10, index);
            node = node.next;
            index ++;
        }

        char[] chars = String.valueOf(num1 + num2).toCharArray();
        LinkList result = new LinkList();
        for (int i = 0; i < chars.length; i++) {
            result.addfrist(Integer.parseInt(String.valueOf(chars[i])));
            //System.out.println(chars[i]);
        }

        return result.frist;
    }
}

class LinkList{
    public ListNode frist;// 定义一个头节点
    public ListNode last;//尾指针永远指向头节点
    public int size = 0;// 节点的位置

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isis() {
        return size == 0;
    }

    /**
     * 头插法
     */
    public void addfrist(int data) {
        ListNode L = new ListNode(data);
        L.next = frist;
        frist = L;
        size++;
    }

    /**
     * 尾插法
     */
    public void addlast(int data) {

        if (frist == null) {
            frist = new ListNode(data);
            last = frist;
        } else {
            ListNode newL = new ListNode(data);
            last.next = newL;
            last = newL;
        }
        size++;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    // 打印链表
    public static void printListNode(ListNode node) {
        System.out.println("打印链表：" + node);
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println("null");
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}