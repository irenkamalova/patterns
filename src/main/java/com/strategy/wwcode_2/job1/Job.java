package com.strategy.wwcode_2.job1;

public interface Job {

    void execute();

    default void executeWithReporting() {
        throw new UnsupportedOperationException();
    }
}

