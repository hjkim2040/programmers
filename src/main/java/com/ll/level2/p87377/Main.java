package com.ll.level2.p87377;

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
    public long [] intersection(int[] line1,int[] line2){
        long A = line1[0];
        long B = line1[1];
        long E = line1[2];

        long C = line2[0];
        long D = line2[1];
        long F = line2[2];

        if ((A * D - B * C) == 0){
            return null;
        }


        double x = (double)(B * F - E * D) / (A * D - B * C);
        double y = (double)(E * C - A * F) / (A * D - B * C);

        if(x != (long)x){return null;}
        if(y != (long)y){return null;}
            return new long[]{(long)x,(long)y};
    }
}
