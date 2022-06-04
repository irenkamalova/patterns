package com.strategy.wwcode.job3;

import com.strategy.wwcode.model.Session;
import com.strategy.wwcode.service.CleanerService;
import com.strategy.wwcode_1.report.Reporter;

import java.time.Clock;
import java.util.List;

public class StaleSessionsCollector implements Job {

    private final List<Session> sessionsRepository;
    private final CleanerService sessionCleanerService;
    private final Reporter reporter;
    private final Long delay;

    public StaleSessionsCollector(List<Session> sessionsRepository,
                                  CleanerService sessionCleanerService,
                                  Reporter reporter,
                                  Long delay) {
        this.sessionsRepository = sessionsRepository;
        this.sessionCleanerService = sessionCleanerService;
        this.reporter = reporter;
        this.delay = delay;
    }

    @Override
    public void execute() {
        sessionsRepository.forEach(session -> {
            if (session.isStale()) {
                sessionCleanerService.clean(session);
            }
        });
    }

    @Override
    public void executeWithReporting() {
        reporter.report(Clock.systemUTC(), "executing job");
        execute();
        reporter.report(Clock.systemUTC(), "job executed");
    }

    @Override
    public void executeWithDelay() {
        try {
            Thread.sleep(delay);
            execute();
        } catch (InterruptedException e) {
            throw new RuntimeException("failed to delay the job");
        }
    }
}
