package com.strategy.wwcode.pattern.job;

public class DelayingExecution implements ExecutionStrategy {

    private final Long delay;

    public DelayingExecution(Long delay) {
        this.delay = delay;
    }

    @Override
    public void execute(Job job) {
        try {
            Thread.sleep(delay);
            job.execute();
        } catch (InterruptedException e) {
            throw new RuntimeException("failed to delay the job");
        }
    }
}
