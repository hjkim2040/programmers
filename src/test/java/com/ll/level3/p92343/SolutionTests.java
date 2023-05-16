package com.ll.level3.p92343;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SolutionTests {
//    @Test
//    @DisplayName("{0,0,1,1,1,0,1,0,1,0,1,1}, {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}} → 5")
//    void t01() {
//        assertThat(
//                new Solution().solution(
//                        new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
//                        new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}
//                )
//        ).isEqualTo(
//                5
//        );
//    }

    @Test
    @DisplayName("getNextNodes")
    void t02() {
        PathCalculator pathCalculator = new PathCalculator(
                new int[]{0, 0, 0},
                new int[][]{{0, 1}, {0, 2}}
        );

        assertThat(
                pathCalculator.getNextNodes(0)
        )
                .isEqualTo(
                        List.of(1, 2)
                );
    }
}