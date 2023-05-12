package com.ll.level3.p43163;

public class Main {
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        return 4;
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