package com.state.state;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    public void should_be_all() {
        Session session = new Session(1);
        assertTrue(session.isActivated());
        assertFalse(session.isCreated());
        assertFalse(session.isTerminated());
        session.activate();
        session.terminate();
        session.isStale();
    }

}