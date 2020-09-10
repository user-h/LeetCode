package leetcode.sword.offer;
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 113 👎 0


import java.util.Stack;

/**
 * 剑09 用两个栈实现队列20200908
 */
public class YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args){
        CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        solution.appendTail(5);
        System.out.println(solution.deleteHead());

        solution.appendTail(6);
        solution.appendTail(7);
        System.out.println(solution.deleteHead());

        solution.appendTail(8);
        System.out.println(solution.deleteHead());
        System.out.println(solution.deleteHead());
        System.out.println(solution.deleteHead());
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
     *
     * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。
     * 为了维护队列先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，在执行删除操作的时候我们首先看下第二个栈是否为空。
     * 如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除的元素的顺序，
     * 要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
     *
     * https://assets.leetcode-cn.com/solution-static/jianzhi_09/jianzhi_9.gif
     */
    class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack();            // 用于添加
        stack2 = new Stack();            // 用于删除
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if ( stack2.empty() && stack1.empty() ) return -1;            // 若stack2和1都为空 返回-1

        if ( stack2.empty() ) {                     // 若2为空  将stack1中元素弹出 压入stack2中
            while ( !stack1.empty() ) {             // 为啥这里用for循环不好使???
                //System.out.println("test===" + stack1.peek());
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();                        // 否则 弹出栈顶元素
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}