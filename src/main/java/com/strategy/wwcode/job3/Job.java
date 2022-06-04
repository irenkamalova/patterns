package com.strategy.wwcode.job3;

public interface Job {

    void execute();

    default void executeWithReporting() {
        throw new UnsupportedOperationException();
    }

    default void executeWithDelay() {
        throw new UnsupportedOperationException();
    }
}
