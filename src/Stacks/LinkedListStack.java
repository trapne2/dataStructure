package Stacks;

import LinkList.LinkedList;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/19 16:12</P>
 **/
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/19 16:18</P>
     * <p>@description: 获取了链表栈元素个数</p>
     */
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/19 16:19</P>
     * <p>@description: 判断链表栈是不是空的</p>
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 16:17</P>
     * <p>@description: 链表出栈</p>
     */
    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 16:17</P>
     * <p>@description: 获取链表栈底的第一个元素</p>
     */
    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/19 16:18</P>
     * <p>@description: 链表入栈</p>
     */
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: java.lang.String</P>
     * <p>@date: 2018/10/19 16:20</P>
     * <p>@description: 重写toString</p>
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("stack：top -> ");
        sb.append(linkedList);
        sb.append(" <- tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack);
    }
}
