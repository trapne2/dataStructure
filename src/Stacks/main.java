package Stacks;

import Queues.LoopQueue;
import Queues.Queue;

import java.util.Random;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/19 16:27</P>
 **/
public class main {

    /***
     * <p>@author: James</p>
     * <p>@param: [queue：队列名称, opCount：值]</P>
     * <p>@return: double</P>
     * <p>@date: 2018/10/18 11:16</P>
     * <p>@description: 测试数组队列和循环队列的性能</p>
     */
    private static double testQueue(Stack<Integer> stack, int opCount){
        //开始时间
        long startTime = System.nanoTime();

        Random random = new Random();

        //入栈
        for(int i = 0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        //出栈
        for(int i = 0;i<opCount;i++){
            stack.pop();
        }
        //结束时间
        long endTime = System.nanoTime();
        //这里是纳米级计算时间，换算成秒，要除以10^9
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        //执行100万次数
        int opCount = 1000000;

        //数组栈
        ArrayStack<Integer> arrayArrayStack = new ArrayStack<>();
        double arrayQueueTime = testQueue(arrayArrayStack,opCount);
        System.out.println("数组栈所耗费的时间为\t"+arrayQueueTime+"s");

        //链表栈
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double loopQueueTime = testQueue(linkedListStack,opCount);
        System.out.println("链表栈所耗费的时间为\t"+loopQueueTime+"s");
    }
}
