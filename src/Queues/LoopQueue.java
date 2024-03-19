package Queues;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/18 10:01</P>
 **/
public class LoopQueue<E> implements Queue<E> {

    /**
     * 存储的数值
     */
    private E[] data;

    /**
     * 声明队首和队尾
     */
    private int front,tail;

    /**
     * 元素个数
     */
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(1 << 4);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/18 10:07</P>
     * <p>@description: 获得队列容器</p>
     */
    public int getCapacity(){
        return data.length - 1;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/18 10:08</P>
     * <p>@description: 获取</p>
     */
    @Override
    public int getSize() {
        return size;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/18 10:11</P>
     * <p>@description: 判断循环队列中是否为空</p>
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/18 10:12</P>
     * <p>@description: 入队</p>
     */
    @Override
    public void enqueue(E e) {
        //判断队列是否满了
        if((tail + 1) % data.length == front){
            //动态扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 10:14</P>
     * <p>@description: 动态扩容</p>
     */
    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity + 1];
        for(int i = 0;i<size;i++){
            //由于对首的位置为不确定，所以要 i + front ,但是为了确保数组不下标越界，这里求余了
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/18 10:12</P>
     * <p>@description: 出队</p>
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        //返回队首
        E ret = data[front];
        //为了GC回收机制
        data[front] = null;
        //重新设置队首
        front = (front + 1) % data.length;
        //元素个数少一个空间
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2 );
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is Empty");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue:size = %d, capacity = %d \n",size,getCapacity()));
        sb.append("font [");
        for(int i = front;i != tail ;i = (i + 1) % data.length ){
            sb.append(data[i]);
            if((i + 1) % data.length != tail){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
