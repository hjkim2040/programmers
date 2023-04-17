package com.ll.level2.p87377;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().intersection(new int[]{1, -1, 0}, new int []{2, -1 ,0}));

    }
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        return answer;
    }
    public Point intersection(int[] line1,int[] line2){
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = (A * D - B * C);

        if (divisor == 0){return null;}


        double x = (B * F - E * D) / divisor;
        double y = (E * C - A * F) / divisor;

        if(x != (long)x){return null;}
        if(y != (long)y){return null;}
            return Point.of(x,y);
    }
}
class Point{
    public final long x;
    public final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
    public static Point of (long x, long y){
        return new Point(x,y);
    }
    public static Point of(double x, double y){
        return of((long) x, (long) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

}
