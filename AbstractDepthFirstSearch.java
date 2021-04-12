package com.example.academy;

import org.w3c.dom.Node;

public abstract class AbstractDepthFirstSearch {

    Node initialNode;
    Node destinationNode;

    public AbstractDepthFirstSearch(Node initialNode, Node destinationNode){
        this.initialNode = initialNode;
        this.destinationNode = destinationNode;
    }

}
