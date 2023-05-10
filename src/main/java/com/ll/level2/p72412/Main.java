package com.ll.level2.p72412;

import java.util.ArrayList;
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
        for (String infoRow : info) {
            String[] infoRowBits = infoRow.split(" ");

            String languageTypeCode = infoRowBits[0];
            String jobGroupTypeCode = infoRowBits[1];
            String careerTypeCode = infoRowBits[2];
            String foodTypeCode = infoRowBits[3];
            int score = Integer.parseInt(infoRowBits[4]);

            String[] languageTypeCodes = new String[]{"-", languageTypeCode};
            String[] jobGroupTypeCodes = new String[]{"-", jobGroupTypeCode};
            String[] careerTypeCodes = new String[]{"-", careerTypeCode};
            String[] foodTypeCodes = new String[]{"-", foodTypeCode};

            for (String languageTypeCode_ : languageTypeCodes) {
                for (String jobGroupTypeCode_ : jobGroupTypeCodes) {
                    for (String careerTypeCode_ : careerTypeCodes) {
                        for (String foodTypeCode_ : foodTypeCodes) {
                            String key = languageTypeCode_ + " " + jobGroupTypeCode_ + " " + careerTypeCode_ + " " + foodTypeCode_;

                            scoresMap.putIfAbsent(key, new ArrayList<>()); // key가 없으면 새로운 ArrayList를 value로 넣어줌
                            scoresMap.get(key).add(score);
                        }
                    }
                }
            }
        }

        // 정렬
        scoresMap.forEach((key, scores) -> scores.sort(Integer::compareTo));

        return scoresMap;
    }
    public List<String> getAllQueries() {
        String[] languageTypeCodes = new String[]{"-", "cpp", "java", "python"};
        String[] jobGroupTypeCodes = new String[]{"-", "backend", "frontend"};
        String[] careerTypeCodes = new String[]{"-", "junior", "senior"};
        String[] foodTypeCodes = new String[]{"-", "chicken", "pizza"};

        List<String> all = new ArrayList<>();

        for (String languageTypeCode : languageTypeCodes) {
            for (String jobGroupTypeCode : jobGroupTypeCodes) {
                for (String careerTypeCode : careerTypeCodes) {
                    for (String foodTypeCode : foodTypeCodes) {
                        all.add(languageTypeCode + " " + jobGroupTypeCode + " " + careerTypeCode + " " + foodTypeCode);
                    }
                }
            }
        }

        return all;
    }
}

