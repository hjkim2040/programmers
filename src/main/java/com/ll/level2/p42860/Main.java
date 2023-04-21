package com.ll.level2.p42860;

public class Main {
}

class Solution{
    public static boolean isDebug = false;

    public int solution(String name) {
        int moveCost = 0; // 위치 바꾸는데 드는 비용, 즉 좌/우
        int nameCost = 0; // 문자 바꾸는데 드는 비용, 즉 위/아래

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = c - 'A';

            nameCost += diff;

            if (diff > 0) {
                moveCost = i;
            }
        }

        return nameCost + moveCost;
    }

}
