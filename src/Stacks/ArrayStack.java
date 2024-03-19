package Stacks;


import Array.ArrayClass;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/17 15:41</P>
 **/
public class ArrayStack<E> implements Stack<E> {

    ArrayClass<E> array;

    public ArrayStack(ArrayClass<E> array) {
        this.array = array;
    }

    public ArrayStack() {
        array = new ArrayClass();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/19 16:18</P>
     * <p>@description: 获取了数组栈元素个数</p>
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/19 16:19</P>
     * <p>@description: 判断数组栈是不是空的</p>
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 16:17</P>
     * <p>@description: 数组栈的容量</p>
     */
    public int getConpanacity(){
        return array.getConpanacity();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 16:17</P>
     * <p>@description: 数组栈出栈</p>
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 16:17</P>
     * <p>@description: 获取数组栈栈顶元素</p>
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/19 16:17</P>
     * <p>@description: 在数组栈中添加元素</p>
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:\n");
        sb.append("[");
        for(int i = 0;i<array.getSize();i++){
            sb.append(array.get(i));
            if(i != array.getSize() -1){
                sb.append(", ");
            }
        }
        sb.append("]\ttop");
        return sb.toString();
    }
}
