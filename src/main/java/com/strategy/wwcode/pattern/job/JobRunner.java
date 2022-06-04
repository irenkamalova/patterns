package com.strategy.wwcode.pattern.job;

public class JobRunner {

    private final Job job;
    private final ExecutionStrategy executionStrategy;

    public JobRunner(Job job, ExecutionStrategy executionStrategy) {
        this.job = job;
        this.executionStrategy = executionStrategy;
    }

    public void run() {
        executionStrategy.execute(job);
    }
}

