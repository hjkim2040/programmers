package com.ll.level3.p92343;

import java.util.ArrayList;
import java.util.List;

public class Main {
}
class Solution {

    public int solution(int[] info, int[][] edges) {

        return 3;

    }

}




class PathCalculator {

    private final int[] info;

    private final int[][] edges;

    private final boolean[][] tree;




    public PathCalculator(int[] info, int[][] edges) {

        this.info = info;

        this.edges = edges;




        tree = new boolean[info.length][info.length];




        for (int[] edge : edges) {

            tree[edge[0]][edge[1]] = true;

            tree[edge[1]][edge[0]] = true;

        }

    }




    public List<Integer> getNextNodes(int currentNode) {

        List<Integer> nextNodes = new ArrayList<>();




        for (int i = 0; i < tree[currentNode].length; i++) {

            if (tree[currentNode][i]) {

                nextNodes.add(i);

            }

        }




        return nextNodes;

    }
    public List<Integer> getNextNodes(int currentNode, List<Integer> history) {
        return getNextNodes(currentNode, history, new ArrayList<>());
    }

    public List<Integer> getNextNodes(int currentNode, List<Integer> history, List<Integer> prevent) {
        prevent.add(currentNode);
        List<Integer> nextNodes = new ArrayList<>();

        List<Integer> _nextNodes = getNextNodes(currentNode);

        for (int nextNode : _nextNodes) {
            if (prevent.contains(nextNode)) {
                continue;
            }

            if (history.contains(nextNode)) {
                nextNodes.addAll(getNextNodes(nextNode, history, prevent));
            } else {
                nextNodes.add(nextNode);
            }
        }

        return nextNodes;
    }

}