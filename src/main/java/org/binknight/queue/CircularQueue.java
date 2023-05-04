package org.binknight.queue;

public class CircularQueue<E> {
    private E[] items; // 数组队列
    private int header = 0;// 环形队列头下标
    private int tail = 0; //环形队列尾下标
    private int capacity = 0; // 队列容量

    public CircularQueue(int capacity) {
        this.items = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(E item){
        // 队列满了
        if((tail+1)%capacity == header) return false;
        items[tail] = item;
        tail = (tail+1) % capacity;
        return true;
    }

    public E dequeue(){
        // 如果head == tail 表示队列为空
        if(header == tail) return null;
        E item = items[header];
        header = (header +1) % capacity;
        return item;
    }

    /*public static void main(String[] args) {
        CircularQueue<String> cq = new CircularQueue<String>(4);
        boolean hello = cq.enqueue("hello");
        boolean world = cq.enqueue("world");
        boolean and = cq.enqueue("!");
        boolean shawn = cq.enqueue("shawn");
        System.out.println(hello);
        System.out.println(world);
        System.out.println(and);
        System.out.println(shawn);
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
    }*/
}
