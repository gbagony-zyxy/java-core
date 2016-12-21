package com.ruyin.code.core.tree.avl.struct;

public class SimpleNode<T> {

    private T[] elements;

    public SimpleNode(T[] elements){
        this.elements = elements;
    }

    public T[] getElements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public int getLength() {
        return elements.length;
    }
}
