package com.ll.level0.p120837;

public class Main {
    public static void main (String[] args){

    }
}

class Solution {
    public int solution(int hp) {
        int generalAntsCount = 0;
        int soldierAntsCount = 0;
        int workerAntsCount = 0;

        generalAntsCount = hp / 5;
        hp %= 5;

        soldierAntsCount = hp / 3;
        hp %= 3;

        workerAntsCount = hp;

        return generalAntsCount + soldierAntsCount + workerAntsCount;
    }

}
