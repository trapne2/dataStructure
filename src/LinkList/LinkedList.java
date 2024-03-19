package LinkList;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>链表</P>
 * @Date: <P>CREATE IS 2018/10/18 14:06</P>
 **/
public class LinkedList<E> {

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
     * 设置虚拟头节点
     */
    private Node dummyHead;

    /**
     * 链表大小
     */
    private int size;

    public LinkedList() {
        //创建一个空的节点
        dummyHead = new Node(null,null);
        size = 0;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 14:15</P>
     * <p>@description: 判断是否为空</p>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 14:15</P>
     * <p>@description: 获取当前的元素个数</p>
     */
    public int getSize(){
        return size;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 14:34</P>
     * <p>@description: 在链表的index0-based位置上添加元素e</p>
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add fail illegal index");
        }
        Node prev = dummyHead;
        //获取索引前一个node
        for(int i = 0;i<index;i++){
            prev = prev.next;
        }
        //设置索引下一个节点的元素
        prev.next = new Node(e,prev.next);
        size++;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 14:21</P>
     * <p>@description: 在链表头添加新元素e</p>
     */
    public void addFirst(E e){
        add(0,e);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 14:48</P>
     * <p>@description: 在链表末尾添加元素</p>
     */
    public void addLast(E e){
       add(size,e);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 15:20</P>
     * <p>@description: 获取链表第index(0-based)个位置的元素</p>
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add fail illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 15:29</P>
     * <p>@description: 获得链表第一个e</p>
     */
    public E getFirst(){
        return get(0);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 15:29</P>
     * <p>@description: 获得链表最后一个e</p>
     */
    public E getLast(){
        //因为有一个虚拟的头部，占用了一个空间，所以减了一个1
        return get(size - 1);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 15:32</P>
     * <p>@description: 修改链表索引index(0-based)上的元素</p>
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add fail illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 15:38</P>
     * <p>@description: 判断链表中存不存在某个元素</p>
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/19 14:59</P>
     * <p>@description: 删除一个元素</p>
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add fail illegal index");
        }
        Node pre = dummyHead;

        for(int i = 0; i < index;i++){
            pre = pre.next;
        }
        //需要删除的节点
        Node delNode = pre.next;
        E e = delNode.e;
        pre.next = delNode.next;
        delNode.e = null;
        size--;
        return e;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/19 16:01</P>
     * <p>@description: 删除第一个元素</p>
     */
    public E removeFirst(){
        return remove(0);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/19 16:02</P>
     * <p>@description: 删除最后一个元素</p>
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 15:41</P>
     * <p>@description: 重写toString()</p>
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
