package com.strategy.wwcode_2.job;

import com.strategy.wwcode_2.exception.CounterJobReachedUpperBoundException;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterJob implements Job {

    private final AtomicInteger counter;

    public CounterJob(AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public synchronized void execute() {
        if (counter.get() == Integer.MAX_VALUE) {
            throw new CounterJobReachedUpperBoundException("Counter reached it's MAX limit");
        }
        counter.incrementAndGet();
    }

    public Integer getValue() {
        return counter.get();
    }
}

