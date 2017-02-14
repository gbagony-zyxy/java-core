package com.ruyin.code.interview.title;

/**
 *  链表数据结构
 */
public class ListNode<T> {
    private T element;

    private ListNode next;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
