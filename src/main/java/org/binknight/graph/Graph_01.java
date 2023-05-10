package org.binknight.graph;

import java.util.LinkedList;

public class Graph_01 {
    /**
     *  基于邻接表的图实现，数组+链表
     * @param args
     */
    private int v;// 定点个数
    private LinkedList<Integer> odj[]; // 邻接表

    public Graph_01(int v) {
        this.v = v;
        odj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            odj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t){
        odj[s].add(t);
        odj[t].add(s);
    }
}
