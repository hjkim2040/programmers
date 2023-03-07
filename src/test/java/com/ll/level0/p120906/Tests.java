package com.ll.level0.p120906;

import com.ll.level0.p120906.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {

    @Test
    @DisplayName("2, 3 => -1")
    void t1() {
        assertThat(new Solution().solution(1234)).isEqualTo(10);
    }

    @Test
    @DisplayName("11, 11 => 1")
    void t2() {
        assertThat(new Solution().solution(930211)).isEqualTo(16);
    }

}