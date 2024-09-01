package com.company;

import java.util.ArrayList;

public class BinaryTree {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node=" + value;
        }

    }
    private Node root;

    public void insert(int value){
        var node = new Node(value);

        if(root == null){
            root = node;
            return;
        }

        var current = root;

        while(true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

    }

    public boolean find(int value){
        var current = root;
        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            }
            else if(value > current.value){
                current = current.rightChild;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public void traverseLevelOrder(){
        for(var i = 0; i <= height(); i++){
            for(var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int height(){
        return height(root);
    }

    public int min(){
        return min(root);
    }

    public int max(){
        return max(root);
    }

    public boolean equals(BinaryTree other){
        return equals(root, other.root);
    }
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void swapRoot(){
        var node = new Node(11);
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    public int size(){
        var size = 0;
        for(var i = 0; i <= height(); i++){
            for(var value : getNodesAtDistance(i))
                size++;
        }
        return size;
    }

    public int countLeaves(){
        return countLeaves(root);
    }



    private boolean contains(Node root, int value){
        if(root == null)
            return false;

        if(value == root.value)
            return true;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }
    private int countLeaves(Node root){
        if(root == null){
            return 0;
        }
        if(isLeaf(root)){
            return 1;
        }

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);

    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null)
            return;

        if(distance == 0){
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }
    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);

    }

    //myself
    private boolean equals(Node root, Node newRoot){
        if(root == null && newRoot == null)
            return true;

        if(root == null || newRoot == null)
            return false;

        if(root.value != newRoot.value)
            return false;

        return equals(root.leftChild, newRoot.leftChild) &&
                equals(root.rightChild, newRoot.rightChild);

    }
    //there a bug that needs to be fixed; (from mosh code)
    private boolean equals_(Node root, Node newRoot){
        if(root == null && newRoot == null)
            return true;

        if(root != null && newRoot != null)
            return root.value == newRoot.value
                    && equals(root.leftChild, newRoot.leftChild)
                    && equals(root.rightChild, root.rightChild);

        return false;
    }

    private void traversePreOrder(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    private void traverseInOrder(Node root){
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    private void traversePostOrder(Node root){
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
    private int height(Node root){
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // time complexity O(n) (myself) (there is a bug that needs to fixed)
    private int min_(Node root){
        if(root == null)
            return Integer.MAX_VALUE;

        if(isLeaf(root)) {
            return root.value;
        }

        return Math.min(min(root.leftChild), min(root.rightChild));

    }
    private int max_(Node root){
        if(root == null)
            return Integer.MIN_VALUE;

        if(isLeaf(root))
            return root.value;

        return Math.max(max(root.leftChild), max(root.rightChild));
    }

    //For binary search tree-- time complexity O(log n)
    private int minValue(){
        var current = root;
        var last = current;
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }
    private int maxValue(){
        var current = root;
        var last = current;
        while(current != null){
            last = current;
            current = current.rightChild;
        }
        return last.value;
    }

    // from mosh (I added few lines to fix the root == null bug)
    private int min(Node root){
        if(root == null)
            return Integer.MAX_VALUE;

        if(isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }
    private int max(Node root){
        if(root == null)
            return Integer.MIN_VALUE;

        if(isLeaf(root))
            return root.value;

        var left = max(root.leftChild);
        var right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    private boolean isLeaf(Node root){
        return root.leftChild == null && root.rightChild == null;
    }

}
