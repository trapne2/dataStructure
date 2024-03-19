import java.util.Stack;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/17 18:28</P>
 **/
class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public ListNode removeElements(ListNode head, int val) {

        //创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;

        //开始删除中间的元素
        ListNode delNode = dummyHead;
        while(delNode.next != null){
            //判断当前节点的val与要删除的val是否相等
            if(delNode.next.val == val){
                delNode.next = delNode.next.next;
            }else{
                delNode = delNode.next;
            }
        }
        return dummyHead.next;
    }

}
