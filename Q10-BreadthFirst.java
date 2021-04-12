package com.example.academy;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirst {
    private int vector;
    private LinkedList<Integer>[] linkedLists;

    @Test
    public void test() {
        BreadthFirst g = new BreadthFirst();
        g.mGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("starting from 1");

        g.BFS(1);



   /*   Output
        starting from 1
        1 2 0 3*/
    }

    void mGraph(int vector) {
        this.vector = vector;
        linkedLists = new LinkedList[vector];
        for (int i = 0; i < vector; ++i)
            linkedLists[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        linkedLists[v].add(w);
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[vector];
        LinkedList<Integer> queue = new LinkedList();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = linkedLists[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
