package com.personal.Splitwise.service.strategy;

public class SettleUpStrategyFactory {
    public SettleUpStrategy getSettleUpStrategy(SettleUpStrategies settleUpStrategies) {
        switch (settleUpStrategies){
            case HEAPBASED -> {
                return new HeapBasedStrategyImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
