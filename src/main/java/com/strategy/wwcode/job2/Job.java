package com.strategy.wwcode.job2;

public interface Job {

    void execute();

    default void executeWithReporting() {
        throw new UnsupportedOperationException();
    }
}
