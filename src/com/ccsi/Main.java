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

//标准方法
package com.ccsi;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    //1.recursion DFS+level
    public static int depthSum(List<NestedInteger> nestedInteger) {
        return dfs(nestedInteger,1);
    }

    public static int dfs(List<NestedInteger> nestedInteger, int dep) {
        if(nestedInteger==null||nestedInteger.size()==0)return 0;

        int sum=0;
        for (int i = 0; i < nestedInteger.size(); i++) {
            if(nestedInteger.get(i).isInteger()){
                sum+=nestedInteger.get(i).getInteger()*dep;
            }else{
                sum+=dfs(nestedInteger.get(i).getList(),dep+1);
            }
        }
        return sum;
    }
    //2.BFS+level  双queue
    public static int depthSum1(List<NestedInteger> nestedInteger){
        if(nestedInteger==null||nestedInteger.size()==0)return 0;

        Queue<NestedInteger> data=new LinkedList<>();
        Queue<Integer> level=new LinkedList<>();
        int sum=0;

        for(NestedInteger ni:nestedInteger){
            data.offer(ni);
            level.offer(1);
        }

        while(!data.isEmpty()){
            NestedInteger curr=data.poll();
            Integer currLever=level.poll();

            if(curr.isInteger())sum+=curr.getInteger()*currLever;
            else{
                for(NestedInteger ni:curr.getList()){
                    data.offer(ni);
                    level.offer(currLever+1);
                }
            }
        }
        return sum;
    }
}

interface NestedInteger{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*





