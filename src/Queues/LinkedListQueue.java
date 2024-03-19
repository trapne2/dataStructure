package Queues;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/19 17:00</P>
 **/
public class LinkedListQueue<E> implements Queue<E> {

    /***
     * <p>@author: James</p>
     * <p>@date: 2018/10/18 14:28</P>
     * <p>@description: 新建节点内部类</p>
     */
    private class Node{

        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * head : 队列头部
     * tail : 队列尾部
     */
    private Node head,tail;

    private int size;

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: </P>
     * <p>@date:  </P>
     * <p>@description: 初始化队列</p>
     */
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/19 17:06</P>
     * <p>@description: 入队</p>
     */
    @Override
    public void enqueue(E e) {
        //判断链表是不是空的
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 17:08</P>
     * <p>@description: 出队</p>
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is Empty");
        }
        //出队节点
        Node retNode = head;
        //将头部节点指向下一个节点
        head = head.next;
        //把出队的节点设置为空
        retNode.next = null;
        //判断头节点是否为空
        if(head == null){
            //尾节点也为空
            tail = null;
        }
        //元素个数自减
        size--;
        return retNode.e;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 17:17</P>
     * <p>@description: 队列头部</p>
     */
    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is Empty");
        }
        return head.e;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/19 17:19</P>
     * <p>@description: 获取队列大小</p>
     */
    @Override
    public int getSize() {
        return size;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/19 17:19</P>
     * <p>@description: 判断队列是不是空的</p>
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/19 17:19</P>
     * <p>@description: 重写toString()方法</p>
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("head -> ");
        Node cur = head;
        while(cur != null){
            sb.append(cur+" -> ");
            cur = cur.next;
        }
        sb.append(" ↖^_^↗  <- tail");
        return sb.toString();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [args]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/19 17:31</P>
     * <p>@description: 测试</p>
     */
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i  = 0 ;i < 10 ; i++){
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if(i % 3 == 2){
                linkedListQueue.dequeue();
            }
        }
    }
}
