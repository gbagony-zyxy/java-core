package com.ruyin.code.core.tree.avl.struct;

import java.util.Comparator;

/**
 *  由于在二叉排序树上插入结点而失去平衡的最小子树根结点的指针为a（即a是离插入点最近，且平衡因子绝对值超过1的祖先结点）
 *  url:http://blog.csdn.net/liyong199012/article/details/29219261
 *  另外一篇:http://blog.csdn.net/zxman660/article/details/7940190
 */
public class AvlTree<T extends Comparable<? super T>> {

    private  AvlNode<T> root;
    private Comparator<? super T> cmp;

    /**
     *  AVL树节点数据结构定义
     */
    private class AvlNode<T>{
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T element){
            this(element,null,null);
        }

        AvlNode(T element, AvlNode<T> lt,AvlNode<T> rt){
            this.element = element;
            this.left = lt;
            this.right = rt;
            height = 0;
        }
    }

    public AvlTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public  boolean isEmpty(){
        return  root == null;
    }

    public void insert(T element){
        root = insert(element,root);
    }

    private int nodeCompare(T lhs,T rhs){
        if(cmp != null){
            return  cmp.compare(lhs,rhs);
        }else{
            return  ((Comparable)lhs).compareTo(rhs);
        }
    }

    private int height(AvlNode<T> node){
        return  node == null ? -1 : node.height;
    }

    private AvlNode insert(T element, AvlNode<T> node){
        if(node == null){
            return  new AvlNode(element,null,null);
        }
        int compareResult = nodeCompare(element,node.element);
        if(compareResult < 0){
            node.left = insert(element,node.left);
            if(height(node.left) - height(node.right) == 2){
                if(nodeCompare(element,node.left.element) < 0)   //左左情形
                    node = rotateWithLeftChild(node);
                else                                             //左右情形
                    node = doubleWithLeftChild(node);
            }
        }else if(compareResult > 0){
            node.right = insert(element,node.right);
            if(height(node.right) - height(node.left) == 2){
                if(nodeCompare(element,node.right.element) < 0)   //右左情形
                    node = doubleWithRightChild(node);
                else                                              //右右情形
                    node = rotateWithRightChild(node);
            }
        }
        //更新height值
        node.height = Math.max(height(node.left),height(node.right))+1;
        return  node;
    }

    /**左左情况单旋转*/
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node){
        AvlNode<T> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        newNode.height = Math.max(height(newNode.left),node.height)+1;
        return newNode;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node){
        return  node;
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> node){
        return  node;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> node){
        return  node;
    }
}
