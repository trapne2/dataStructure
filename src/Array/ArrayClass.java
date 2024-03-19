package Array;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>数组</P>
 * @Date: <P>CREATE IS 2018/10/16 16:06</P>
 **/
public class ArrayClass<E> {

    private E[] data;

    private int size;

    /***
     * <p>@author: James</p>
     * <p>@param: [num]</P>
     * <p>@return: </P>
     * <p>@date:  </P>
     * <p>@description: 构造函数初始化数据</p>
     */
    public ArrayClass(int num){
        data = (E[])new Object[num];
        size = 0;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: </P>
     * <p>@date:  </P>
     * <p>@description: 设定默认的数组空间为16个</p>
     */
    public ArrayClass(){
        this(1 << 4);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/17 15:14</P>
     * <p>@description: 获取数组的容量</p>
     */
    public int getConpanacity(){
        return data.length;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/17 15:13</P>
     * <p>@description: 获取数组的元素个数</p>
     */
    public int getSize(){
        return size;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/17 15:13</P>
     * <p>@description: 判断数组是否为空</p>
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/17 15:13</P>
     * <p>@description: 向数组第一个空间添加元素</p>
     */
    public void addFirst(E e){
        add(0,e);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/17 15:13</P>
     * <p>@description: 向所有元素后添加一个元素</p>
     */
    public void addLast(E e){
       add(size,e);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [index, e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/17 15:12</P>
     * <p>@description: 在一个特定的索引中插入一个元素</p>
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引参数非法");
        }
        //数组空间自动扩容
        if(size == data.length - 1){
            resize(2 * data.length);
        }
        for(int i = size;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [newCapacity]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/17 15:12</P>
     * <p>@description: 动态扩容</p>
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: java.lang.String</P>
     * <p>@date: 2018/10/17 15:12</P>
     * <p>@description: 重写toString字符串</p>
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d ,capacity = %d\n",size,data.length));
        stringBuilder.append('[');
        for(int i = 0;i<size;i++){
            stringBuilder.append(data[i]);
            //判断i是否等于最后一个元素
            if(i != size - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [index]</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/17 15:12</P>
     * <p>@description: 根据索引获取值</p>
     */
    public E get(int index){
        //判断传入的参数有没有越界
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("传入的索引存在越界，请重新传入，其中数组最大的索引为："+(size-1));
        }
        return data[index];
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/17 15:50</P>
     * <p>@description: 获取最后一个索引的值</p>
     */
    public E getLast(){
        return get(size -1);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/17 15:51</P>
     * <p>@description: 获取第一个索引的值</p>
     */
    public E first(){
        return get(0);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [index, e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/17 15:11</P>
     * <p>@description: 通过索引修改值</p>
     */
    void set(int index,E e){
        //判断传入的参数有没有越界
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("传入的索引存在越界，请重新传入，其中数组最大的索引为："+(size-1));
        }
        data[index] = e;
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: boolean</P>
     * <p>@date: 2018/10/17 15:11</P>
     * <p>@description: 判断元素存不存在改数组中</p>
     */
    public boolean contains(E e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: int</P>
     * <p>@date: 2018/10/17 15:11</P>
     * <p>@description: 根据元素获取该元素的索引</p>
     */
    public int find(E e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [index]</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/17 15:11</P>
     * <p>@description: 根据索引删除一个元素</p>
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引参数非法");
        }
        E indexValue = data[index];
        for(int i = index + 1;i < size;i++){
            data[i - 1] = data[i];
        }
        size--;
        //为了垃圾回收机制而写
        data[size] = null;
        //容器动态进行减小
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length * 2);
        }
        return indexValue;
    }

    /**
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: E</P>
     * <p>@date: 2018/10/17 15:10</P>
     * <p>@description: 删除第一个元素的值</p>
     */
    public E removeFirst(){
        return remove(0);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: </P>
     * <p>@return: </P>
     * <p>@date:  </P>
     * <p>@description: 删除最后一个值</p>
     */
    public E removeLast(){
        return remove(size);
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [e]</P>
     * <p>@return: void</P>
     * <p>@date: 2018/10/17 15:10</P>
     * <p>@description: 根据元素的值判断存不存在，如果存在，就删除</p>
     */
    public void removeElement(E e){

        int index = find(e);
        if(index != -1){
            remove(index);
        }

    }


    public static void main(String[] args) {
        ArrayClass<Integer> arrayClass = new ArrayClass<>(100);
        for (int i = 0;i < 50;i++ ){
            arrayClass.addLast(i);
        }
        System.out.println(arrayClass);

        arrayClass.remove(0);
        System.out.println(arrayClass);
    }
}
