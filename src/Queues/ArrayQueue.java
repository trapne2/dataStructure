package Queues;

import Array.ArrayClass;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/18 9:30</P>
 **/
public class ArrayQueue<E> implements Queue<E> {

    private ArrayClass<E> arrayClass;

    public ArrayQueue(int capacity) {
        arrayClass = new ArrayClass<>(capacity);
    }

    public ArrayQueue() {
        this(1 << 4);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/18:34</P>
     * <p>@description: 入队</p>
     */
    @Override
    public void enqueue(E e) {
        arrayClass.addLast(e);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/18 9:34</P>
     * <p>@description: 出队</p>
     */
    @Override
    public E dequeue() {
        return arrayClass.removeFirst();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/18 9:34</P>
     * <p>@description: 获取队首</p>
     */
    @Override
    public E getFront() {
        return arrayClass.first();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/18 9:35</P>
     * <p>@description: 获取队列元素个数</p>
     */
    @Override
    public int getSize() {
        return arrayClass.getSize();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/18 9:35</P>
     * <p>@description: 判断是否为空</p>
     */
    @Override
    public boolean isEmpty() {
        return arrayClass.isEmpty();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 9:36</P>
     * <p>@description: 获取容量</p>
     */
    public int getCapacity(){
       return arrayClass.getConpanacity();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date: 2018/10/18 9:37</P>
     * <p>@description: 重写toString()</p>
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:\t");
        sb.append("front\t[");
        for(int i = 0;i<arrayClass.getSize();i++){
            sb.append(arrayClass.get(i));
            if(i != arrayClass.getSize() -1){
                sb.append(", ");
            }
        }
        sb.append("]\ttail");
        return sb.toString();
    }
}
