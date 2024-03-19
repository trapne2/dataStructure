package Queues;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/18 9:25</P>
 **/
public interface Queue<E>{

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/18 9:27</P>
     * <p>@description: 入队</p>
     */
    void enqueue(E e);

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/18 9:27</P>
     * <p>@description: 出队方法</p>
     */
    E dequeue();

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/18 9:27</P>
     * <p>@description: 获取队首</p>
     */
    E getFront();

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/18 9:29</P>
     * <p>@description: 获取队列元素的大小</p>
     */
    int getSize();

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/18 9:29</P>
     * <p>@description: 判断队列是否为空</p>
     */
    boolean isEmpty();
}
