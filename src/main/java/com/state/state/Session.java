package com.state.state;

public class Session {
    public final long timeToLive;
    public long lastUpdatedTime;
    public State state;

    public Session(long timeToLive) {
        this.timeToLive = timeToLive;
        this.lastUpdatedTime = System.currentTimeMillis();;
        this.state = State.CREATED;
    }

    private Session(Builder builder) {
        this.timeToLive = builder.timeToLive;
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.state = builder.state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long timeToLive;
        private Long lastUpdatedTime = System.currentTimeMillis();
        private State state = State.CREATED;

        private Builder() {}

        public Builder timeToLive(long timeToLive) {
            this.timeToLive = timeToLive;
            return this;
        }

        public Builder lastUpdatedTime(long lastUpdatedTime) {
            this.lastUpdatedTime = timeToLive;
            return this;
        }

        public Builder state(State state) {
            this.state = state;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }

    public boolean isCreated() {
        return state == State.CREATED;
    }

    public boolean isActivated() {
        return state == State.ACTIVATED;
    }

    public boolean isTerminated() {
        return state == State.TERMINATED;
    }

    public void activate() {
        if (state != State.CREATED) {
            throw new Error("Incorrect state of session");
        }
        state = State.ACTIVATED;
    }

    public void terminate() {
        if (state != State.ACTIVATED) {
            throw new Error("Incorrect state of session");
        }
        state = State.TERMINATED;
    }

    public boolean isStale() {
        return System.currentTimeMillis() - lastUpdatedTime > timeToLive;
    }
}
