package com.state;

import com.strategy.wwcode.job.Job;

import java.util.List;

public class StaleSessionsCollector implements Job {

    private final List<Session> sessionsRepository;
    private final CleanerService sessionCleanerService;

    public StaleSessionsCollector(List<Session> sessionsRepository,
                                  CleanerService sessionCleanerService) {
        this.sessionsRepository = sessionsRepository;
        this.sessionCleanerService = sessionCleanerService;
    }

    @Override
    public void execute() {
        sessionsRepository.forEach(session -> {
            if (session.isStale()) {
                sessionCleanerService.clean(session);
            }
        });
    }
}
