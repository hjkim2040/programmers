package com.ll.level2.p42860;

public class Main {
}

class Solution{
    public static boolean isDebug = false;

    public int solution(String name) {
        int move = 1;

        char c0 = name.charAt(0);
        char c1 = name.charAt(1);

        int diff0 = c0 - 'A';
        int diff1 = c0 - 'A';

        return diff0 + diff1 + move;
    }

}
