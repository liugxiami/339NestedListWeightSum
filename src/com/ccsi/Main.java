package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Node root=buildTree();
        dfs(root,1);
        System.out.println(sum);
    }
    private static int sum=0;
    public static void dfs(Node root,int level){
        sum+=root.val*level;
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i),level+1);
        }
    }
    public static Node buildTree(){
        Node root=new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.get(0).children.add(new Node(7));
        root.children.get(1).children.add(new Node(8));
        root.children.get(1).children.add(new Node(9));
        return root;
    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children=new LinkedList<>();
    }
}
