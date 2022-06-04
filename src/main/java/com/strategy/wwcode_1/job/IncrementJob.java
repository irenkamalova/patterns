package com.strategy.wwcode_1.job;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementJob implements Job {

    private AtomicInteger counter;

    @Override
    public void execute() {
        // do the job!
        counter.incrementAndGet();
    }

    public Integer getValue() {
        return counter.get();
    }
}
