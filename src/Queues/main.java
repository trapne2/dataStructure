package Queues;

import Queues.ArrayQueue;
import Queues.LoopQueue;
import Queues.Queue;

import java.util.Random;

/**
 * @version <p>V1.0</p>
 * @Author: <H2>james</H2>
 * @Description: <P>添加说明</P>
 * @Date: <P>CREATE IS 2018/10/17 15:59</P>
 **/
public class main {

    /***
     * <p>@author: James</p>
     * <p>@param: [queue：队列名称, opCount：值]</P>
     * <p>@return: double</P>
     * <p>@date: 2018/10/18 11:16</P>
     * <p>@description: 测试数组队列和循环队列的性能</p>
     */
    private static double testQueue(Queue<Integer> queue,int opCount){
        //开始时间
        long startTime = System.nanoTime();

        Random random = new Random();

        //入队
        for(int i = 0;i<opCount;i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        //出队
        for(int i = 0;i<opCount;i++){
            queue.dequeue();
        }
        //结束时间
        long endTime = System.nanoTime();
        //这里是纳米级计算时间，换算成秒，要除以10^9
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        //执行此数
        int opCount = 100000;

        //数组队列
        /*ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue,opCount);
        System.out.println("数组队列所耗费的时间为\t"+arrayQueueTime+"s");*/

        //循环队列
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue,opCount);
        System.out.println("循环队列所耗费的时间为\t"+loopQueueTime+"s");

        //链表队列
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkedListQueueTime= testQueue(linkedListQueue,opCount);
        System.out.println("链表队列所耗费的时间为\t"+linkedListQueueTime+"s");
    }

}
