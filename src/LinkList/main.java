package LinkList;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/18 15:52</P>
 **/
public class main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0;i < 10;i++){
            linkedList.add(i,i);
        }
        System.out.println(linkedList);

        //插入一个元素
        linkedList.add(2,666666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.remove(0);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);


    }
}
