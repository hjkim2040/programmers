package com.ll.level2.p72412;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        return answer;
    }
    Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        scoresMap.put("java - - -", List.of(80, 150));
        scoresMap.put("python frontend senior chicken", List.of(150, 210));
        scoresMap.put("python - - -", List.of(50, 150, 210));
        scoresMap.put("- - senior -", List.of(50, 150, 210, 260));

        return scoresMap;
    }
}

