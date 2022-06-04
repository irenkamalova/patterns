package com.strategy.wwcode.model;

public class Session {
    public final long timeToLive;
    public long lastUpdatedTime;

    public Session(long timeToLive) {
        this.timeToLive = timeToLive;
        this.lastUpdatedTime = System.currentTimeMillis();
    }

    public boolean isStale() {
        return System.currentTimeMillis() - lastUpdatedTime > timeToLive;
    }
}
