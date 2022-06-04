package com.strategy.wwcode.pattern.job;

import com.strategy.wwcode_1.report.Reporter;

import java.time.Clock;

public class DelayingWithReportingExecution implements ExecutionStrategy {

    private final Reporter reporter;
    private final Long delay;

    public DelayingWithReportingExecution(Reporter reporter, Long delay) {
        this.reporter = reporter;
        this.delay = delay;
    }

    @Override
    public void execute(Job job) {
        try {
            Thread.sleep(delay);
            reporter.report(Clock.systemUTC(), "executing job");
            job.execute();
            reporter.report(Clock.systemUTC(), "job executed");
        } catch (InterruptedException e) {
            reporter.report(Clock.systemUTC(), "job failed to be delayed");
        }
    }
}
