package com.strategy.wwcode_1.no_pattern_with_reporting;

import com.strategy.wwcode_1.job.Job;
import com.strategy.wwcode_1.report.Reporter;

import java.time.Clock;

public class SimpleJobRunner implements JobRunner {

    private final Reporter reporter;
    private final Job job;

    public SimpleJobRunner(Job job, Reporter reporter) {
        this.reporter = reporter;
        this.job = job;
    }

    @Override
    public void run() {
        job.execute();
    }

    @Override
    public void runWithReporting() {
        reporter.report(Clock.systemUTC(), "job executed: " + job.toString());
        job.execute();
    }
}

