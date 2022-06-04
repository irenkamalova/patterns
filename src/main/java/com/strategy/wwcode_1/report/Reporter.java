package com.strategy.wwcode_1.report;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

public class Reporter {

    private final Map<Clock, String> journal = new HashMap<>();

    public void report(Clock clock, String record) {
        journal.put(clock, record);
    }

    public String get(Clock clock) {
        return journal.get(clock);
    }
}
