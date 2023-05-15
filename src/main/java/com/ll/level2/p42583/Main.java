package com.ll.level2.p42583;

import java.util.ArrayList;
import java.util.List;

public class Main {
}
class Solution {
    private List<TruckPass> truckPasses = new ArrayList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        TruckPass.seconds = 0;
        TruckPass.bridgeLength = bridge_length;
        TruckPass.bridgeAllowableWeight = weight;

        TruckPass oldTruckPass = null;

        for (int truck_weight : truck_weights) {
            TruckPass truckPass = new TruckPass(truck_weight, oldTruckPass);
            truckPasses.add(truckPass);
            oldTruckPass = truckPass;
        }

        while (!isAllPassed()) {
            TruckPass.seconds++;
            truckPasses.forEach(TruckPass::tick);
        }

        return TruckPass.seconds;
    }

    private boolean isAllPassed() {
        return truckPasses.stream().allMatch(TruckPass::isPassed);
    }
}

class TruckPass {
    // 다리 길이
    public static int bridgeLength;
    // 다리가 버틸 수 있는 하중
    public static int bridgeAllowableWeight;
    public static int bridgeWeight = 0;
    public static int seconds;
    // 이 트럭의 무게
    private final int weight;
    // 이 트럭이 다리에 진입한 후 지난 시간
    private int secondsAfterOnBridge = 0;
    // 이 트럭이 다리에 진입했는지 여부
    private boolean started = false;
    // 내 바로앞의 트럭
    private TruckPass prev;

    public TruckPass(int weight, TruckPass prev) {
        this.weight = weight;
        this.prev = prev;
    }

    public boolean isPassed() {
        if (!started) return false;
        return secondsAfterOnBridge == bridgeLength;
    }

    // 매 초마다 수행해야 하는 일을 처리
    public void tick() {
        // 이제 막 빠지는 경우
        if (started && secondsAfterOnBridge == bridgeLength) {
            bridgeWeight -= weight;
            return;
        }

        if (isPassed()) return;

        if (started) {
            bridgeWeight += weight;
            secondsAfterOnBridge++;
            return;
        }

        if (isTurnToStart()) {
            started = true;
            secondsAfterOnBridge++;
        }
    }

    private boolean isTurnToStart() {
        if (isWaitingNumberZero() && isBridgeAllowableWeight()) {
            return true;
        }

        return false;
    }

    private boolean isBridgeAllowableWeight() {
        return bridgeAllowableWeight >= bridgeWeight + weight;
    }

    private boolean isWaitingNumberZero() {
        return prev == null || (prev.started && prev.secondsAfterOnBridge > 0);
    }
}
