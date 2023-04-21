package com.ll.level2.p42860;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTests {
    @BeforeAll
    void beforeAll() {
        Solution.isDebug = true;
    }

    @Test
    @DisplayName("BAA => 1")
    void t01() {
        assertThat(
                new Solution().solution("BAA")
        ).isEqualTo(
                1
        );
    }
}