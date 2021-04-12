package com.example.academy;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstAlgorithm {

    private int vertex;
    private LinkedList<Integer> linkedLists[];

    @Test
    public void depthFirst() {
        DepthFirstAlgorithm g = new DepthFirstAlgorithm();
        g.initDataList(10);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(5, 5);
        g.addEdge(8, 4);
        g.addEdge(5, 7);
        g.addEdge(2, 4);

        System.out.println("Depth First: ");

        g.DFS();

       /* My OutPut: 0 1 2 4 3 5 7 6 8 9*/
    }

    void initDataList(int vertex) {
        this.vertex = vertex;
        linkedLists = new LinkedList[vertex];
        for (int i = 0; i < vertex; ++i)
            linkedLists[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        linkedLists[v].add(w); // Add w to v's list.
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = linkedLists[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS() {
        boolean visited[] = new boolean[vertex];
        for (int i = 0; i < vertex; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }
}
