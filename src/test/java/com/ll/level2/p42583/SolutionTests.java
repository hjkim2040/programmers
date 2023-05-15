package com.ll.level2.p42583;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTests {

    @Test
    @DisplayName("100, 100, {10} → 101")
    void t01() {
        assertThat(
                new Solution().solution(100, 100, new int[]{10})
        ).isEqualTo(
                101
        );
    }
}