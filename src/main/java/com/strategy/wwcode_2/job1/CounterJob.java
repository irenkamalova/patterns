package com.strategy.wwcode_2.job1;

import com.strategy.wwcode_2.exception.CounterJobReachedUpperBoundException;
import com.strategy.wwcode_1.report.Reporter;

import java.time.Clock;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterJob implements Job {

    private final AtomicInteger counter;
    private final Reporter reporter;

    public CounterJob(AtomicInteger counter, Reporter reporter) {
        this.counter = counter;
        this.reporter = reporter;
    }

    @Override
    public synchronized void execute() {
        // do the job!
        if (counter.get() == Integer.MAX_VALUE) {
            throw new CounterJobReachedUpperBoundException("Counter reached it's MAX limit");
        }
        counter.incrementAndGet();
    }

    @Override
    public void executeWithReporting() {
        reporter.report(Clock.systemUTC(), "executing job");
        execute();
        reporter.report(Clock.systemUTC(), "job executed");
    }

    public Integer getValue() {
        return counter.get();
    }
}
