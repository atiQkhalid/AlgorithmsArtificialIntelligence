package com.example.academy;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class IterativeDeepeningAlgorithm {

    @Test
    public void depthFirst() {

        IterativeDeepeningAlgorithm iterativeDeepeningAlgorithm = new IterativeDeepeningAlgorithm();
        iterativeDeepeningAlgorithm.initIterativeDeepeningAlgorithm(10);
        iterativeDeepeningAlgorithm.addEdge(1, 2);
        iterativeDeepeningAlgorithm.addEdge(5, 2);
        iterativeDeepeningAlgorithm.addEdge(6, 6);
        iterativeDeepeningAlgorithm.addEdge(0, 8);
        iterativeDeepeningAlgorithm.addEdge(8, 9);

        System.out.println("Following is the Depth First Traversal");
        iterativeDeepeningAlgorithm.DFS(0);

        /* My OutPut: 0 8 9 */
    }


    int vertex;
    LinkedList<Integer>[] adj;

    void initIterativeDeepeningAlgorithm(int vertex) {
        this.vertex = vertex;
        adj = new LinkedList[vertex];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();

    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int s) {

        Vector<Boolean> visited = new Vector<Boolean>(vertex);
        for (int i = 0; i < vertex; i++)
            visited.add(false);
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while (stack.empty() == false) {
            s = stack.peek();
            stack.pop();
            if (visited.get(s) == false) {
                System.out.print(s + " ");
                visited.set(s, true);
            }
            Iterator<Integer> itr = adj[s].iterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if (!visited.get(v))
                    stack.push(v);
            }

        }
    }
}
