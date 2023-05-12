package com.ll.level3.p43163;

import java.util.Arrays;

public class Main {
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean exists = Arrays.stream(words)
                .filter(e -> e.equals(target))
                .count() == 1L;

        if (!exists) return 0;

        boolean[] visited = new boolean[words.length];

        String current = begin;

        int whileCount = 0;
        int depth = 0;

        while (true) {
            whileCount++;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                if (isConvertible(current, words[i])) {
                    visited[i] = true;

                    if (words[i].equals(target)) return depth;

                    current = words[i];
                    System.out.println(current);
                    depth++;
                }
            }

            if (whileCount > 1000) break;
        }

        return depth;
    }
    public boolean isConvertible(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                diffCount++;

            if (diffCount > 1) return false;
        }

        return true;
    }
}