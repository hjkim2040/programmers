package com.ll.level1.p42840;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().solution(new int[]{1, 2, 3, 4, 5})
                )
        );
        // [1]

//        System.out.println(
//                Arrays.toString(
//                        new Solution().solution(new int[]{1, 3, 2, 4, 2})
//                )
//        );
        // [1, 2, 3]
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int maxPoint = Stream.of(scoreOf1(answers), scoreOf2(answers), scoreOf3(answers))
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        return new int[]{maxPoint};
    }

    private int scoreOf1(int[] answers) {
        return scoreOf(answers, new int[]{1, 2, 3, 4, 5});
    }

    private int scoreOf2(int[] answers) {
        return scoreOf(answers, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
    }

    private int scoreOf3(int[] answers) {
        return scoreOf(answers, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
    }

    private int scoreOf(int[] answers, int[] pattern) {
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                score++;
            }
        }

        return score;
    }
}