package com.state;

import com.state.state.State;

public class Session {
    public final long timeToLive;
    public long lastUpdatedTime;
    public State state = State.CREATED;

    public Session(long timeToLive) {
        this.timeToLive = timeToLive;
        this.lastUpdatedTime = System.currentTimeMillis();
    }

    public boolean isStale() {
            return System.currentTimeMillis() - this.lastUpdatedTime > this.timeToLive;
    }
}
