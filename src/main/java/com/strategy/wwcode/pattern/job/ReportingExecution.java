package com.strategy.wwcode.pattern.job;

import com.strategy.wwcode_1.report.Reporter;

import java.time.Clock;

public class ReportingExecution implements ExecutionStrategy {

    private final Reporter reporter;

    public ReportingExecution(Reporter reporter) {
        this.reporter = reporter;
    }

    @Override
    public void execute(Job job) {
        reporter.report(Clock.systemUTC(), "executing job");
        job.execute();
        reporter.report(Clock.systemUTC(), "executed job");
    }
}
