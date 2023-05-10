package com.ll.level2.p72412;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTests {
    private final String[] info = new String[]{
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
    };

    @Test
    @DisplayName("python frontend senior chicken → 150, 210")
    void t1() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("python frontend senior chicken");

        assertThat(scores).containsExactly(150, 210);
    }
}