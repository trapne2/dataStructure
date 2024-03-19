package Stacks;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>自定义栈接口类</P>
 * @Date: <P>CREATE IS 2018/10/17 15:39</P>
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    E pop();
    E peek();
    void push(E e);
}
