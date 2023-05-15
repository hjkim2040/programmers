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
    public static int onBridgeWeight = 0;
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
        return secondsAfterOnBridge == bridgeLength + 1;
    }

    // 매 초마다 수행해야 하는 일을 처리
    public void tick() {


        if (isPassed()) return;



        if (isTurnToStart()) {
            started = true;
            onBridgeWeight += weight; // 내가 들어감으로써 다리 위에 있는 무게가 증가
        }

        // 다리 위에 있는 시간을 증가
        if (started) {
            secondsAfterOnBridge++;
            // 다리를 벗어났다면 무게를 감소, 즉 패스처리
            if (secondsAfterOnBridge == bridgeLength + 1) {
                onBridgeWeight -= weight;
            }
        }
    }

    private boolean isTurnToStart() {
        if (isWaitingNumberZero() && canIIn()) {
            return true;
        }

        return false;
    }

    private boolean canIIn() {
        return bridgeAllowableWeight >= onBridgeWeight + weight;
    }

    private boolean isWaitingNumberZero() {
        if (started) return false;
        return prev == null || (prev.started && prev.secondsAfterOnBridge > 1);
    }
}
