package com.example.academy;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DepthLimitedSearch extends AbstractSearch {

    Node startNode;
    Node goalNode;
    int depth = 0;
    int limit = 2;

    public DepthLimitedSearch(Node start, Node goalNode){
        super(start, goalNode);
        this.startNode = start;
        this.goalNode = goalNode;
    }

    public boolean execute(){
        Stack<Node> nodeStack = new Stack<>();
        ArrayList<Node> visitedNodes = new ArrayList<>();
        nodeStack.add(startNode);

        depth = 0;

        while(!nodeStack.isEmpty()){
            if(depth <= limit) {
                Node current = nodeStack.pop();
                if (current.equals(goalNode)) {
                    System.out.print(visitedNodes);
                    System.out.println("Goal node found");
                    return true;
                } else {
                    visitedNodes.add(current);
                    nodeStack.addAll((Collection<? extends Node>) current.getChildNodes());
                    depth++;

                }
            } else {
                System.out.println("Goal Node not found within depth limit");
                return false;
            }
        }
        return false;
    }
}