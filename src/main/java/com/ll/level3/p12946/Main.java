package com.ll.level3.p12946;

import java.util.ArrayList;
import java.util.List;

public class Main {
}
class Solution {
    public int[][] solution(int n) {
        return new Hanoi(1, 3, n).toArray();
    }
}

class Hanoi {

    private final List<int[]> paths = new ArrayList<>();

    public Hanoi(int from, int to, int n) {

        calculate(from, to, n);
    }

    public void calculate(int from, int to, int n) {


        if (n == 1) {
            addPath(from, to);
            return;
        }
        int empty = 6 - from -to;
        calculate(from,empty,n-1);
        calculate(from,to,1);
        calculate(empty,to,n-1);

    }
    private void addPath(int from, int to){
        paths.add(new int[]{from,to});
    }
    public int[][] toArray(){
        return paths
                .stream()
                .toArray(int[][]::new);
    }

}
