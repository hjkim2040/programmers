package com.ll.level3.p92343;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
}
class Solution {

    public int solution(int[] info, int[][] edges) {

        if (info.length == 2 && info[1] == 1) {
            return 1;
        }

        PathCalculator pathCalculator = new PathCalculator(
                info,
                edges
        );

        Path path = pathCalculator.wholePath();
        Path maxSheepPath = pathCalculator.getMaxSheepPath();

        return maxSheepPath.getSheepCount();

    }

}




class PathCalculator {

    private final int[] info;

    private Path maxSheepPath;

    private final boolean[][] tree;




    public PathCalculator(int[] info, int[][] edges) {

        this.info = info;





        tree = new boolean[info.length][info.length];




        for (int[] edge : edges) {

            tree[edge[0]][edge[1]] = true;

            tree[edge[1]][edge[0]] = true;

        }

    }


    public Path getMaxSheepPath() {
        return maxSheepPath;
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
    public Path wholePath() {
        Path path = new Path(null, 0, info[0] == 0);

        for (int nextNode : getNextNodes(0)) {
            findPath(path, nextNode);
        }

        return path;
    }

    private void findPath(Path parentPath, int node) {
        Path path = parentPath.addChildPath(node, info[node] == 0);

        if (path.getSheepCount() == 0) return;

        if (maxSheepPath == null || maxSheepPath.getSheepCount() < path.getSheepCount()) {
            maxSheepPath = path;
        }

        List<Integer> nextNodes = getNextNodes(node, path.history());

        for (int nextNode : nextNodes) {
            findPath(path, nextNode);
        }
    }
}

class Path {
    private final int depth;
    private final int node;
    private final Path parentPath;
    private final List<Path> childPaths;
    private final int sheepCount;
    private final int wolfCount;


    Path(Path parentPath, int node, boolean isSheep) {
        this.parentPath = parentPath;
        this.depth = parentPath == null ? 0 : parentPath.depth + 1;
        this.node = node;
        this.childPaths = new ArrayList<>();
        int sheepCount = (isSheep ? 1 : 0) + (parentPath == null ? 0 : parentPath.sheepCount);
        int wolfCount = (isSheep ? 0 : 1) + (parentPath == null ? 0 : parentPath.wolfCount);

        this.sheepCount = sheepCount <= wolfCount ? 0 : sheepCount;
        this.wolfCount = wolfCount;
    }

    public int getSheepCount() {
        return sheepCount;
    }

    public Path addChildPath(int nextNode, boolean isSheep) {
        Path path = new Path(this, nextNode, isSheep);
        childPaths.add(path);

        return path;
    }

    public List<Integer> history() {
        List<Integer> history = new ArrayList<>();

        Path path = this;

        while (path != null) {
            history.add(path.node);
            path = path.parentPath;
        }

        return history;
    }

    @Override
    public String toString() {
        return " ".repeat(depth) + node + "\n" + childPaths.stream().map(Path::toString).collect(Collectors.joining("\n"));
    }

    public int getDepth() {
        return depth;
    }

}