package com.strategy.wwcode_1.no_pattern;

import com.strategy.wwcode_1.job.Job;

public class SimpleJobRunner implements JobRunner {

    private final Job job;

    public SimpleJobRunner(Job job) {
        this.job = job;
    }

    @Override
    public void run() {
        job.execute();
    }
}
