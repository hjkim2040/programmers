package com.ll.level2.p42860;

public class Main {
}

class Solution{
    public static boolean isDebug = false;

    public int solution(String name) {
        return nameCost(name) + moveCost(name);
    }

    private int nameCost(String name) {
        int nameCost = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = Math.min(c - 'A', 'Z' - c + 1);

            nameCost += diff;
        }

        return nameCost;
    }

    private int moveCost(String name) {
        int moveCost = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = c - 'A';

            if (diff > 0) {
                moveCost = i;
            }
        }

        return moveCost;
    }
    public int moveCostBy1(String name) {
        int move = 0;

        for ( int i = 0; i < name.length(); i++ ) {
            if ( name.charAt(i) != 'A' ) {
                move = i;
            }
        }

        return move;
    }

}
