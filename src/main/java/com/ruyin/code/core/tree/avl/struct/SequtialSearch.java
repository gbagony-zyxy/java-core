package com.ruyin.code.core.tree.avl.struct;

//顺序排序
public class SequtialSearch<T> {

    public static void main(String[] args) {
        String[] str = new String[]{"","a","b","c","d","e","f","g","h"};
        SimpleNode<String> node = new SimpleNode<>(str);
        int pos = new SequtialSearch<String>().sequtialSearch(node,"g");
        System.out.println(pos);
    }

    private int sequtialSearch(SimpleNode node,T key){
        int i = 0;
        node.getElements()[0] = key;
        for(i = node.getLength()-1;node.getElements()[i]!=key;i--);
        return i;
    }
}
