package org.binknight.queue;

public class ArrayQueue<E> {
    // 数组 items
    private E[] items;
    // 数组大小
    private int capacity = 0;
    // header 队头下标
    int header = 0;
    // tail 队尾下标
    int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.items = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    // 入队
    public boolean enqueue(E element){
        // 如果tail == n 并且header == 0 表示队列已经满了
        if(tail == capacity){
            if(header == 0) return false;
            // header !=0说明队列还有空闲空间，进行数据搬移
            for (int i = header; i < tail; i++) {
                items[i-header] = items[i];
            }
            //搬移结束，重置header和 tail
            tail -=header; header = 0;
        }

        items[tail] = element;
        tail++;
        return true;
    }
    // 出队
    public E dequeue(){
        // 如果head == tail 表示队列为空
        if(header == tail) return null;
        E item = items[header];
        header++;
        return item;
    }
}
