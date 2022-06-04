package com.state;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class StaleSessionsCollectorTest {

    CleanerService cleaner = mock(CleanerService.class);
    Session session = mock(Session.class);
    List<Session> repository = new ArrayList<>() {{ add(session); }};
    StaleSessionsCollector staleSessionsCollector = new StaleSessionsCollector(repository, cleaner);

    @Test
    public void should_clean_stale_sessions_without_errors() {
        // given
        when(session.isStale()).thenReturn(true);
        // when - then
        assertDoesNotThrow(staleSessionsCollector::execute);
        verify(cleaner).clean(session);
    }

    @Test
    public void should_not_clean_if_no_stale_sessions_without_errors() {
        // given
        when(session.isStale()).thenReturn(false);
        // when - then
        assertDoesNotThrow(staleSessionsCollector::execute);
        verifyNoMoreInteractions(cleaner);
    }

    @Test
    public void should_fail_clean_stale_sessions_on_cleaner_error() {
        // given
        doThrow(RuntimeException.class).when(cleaner).clean(session);
        when(session.isStale()).thenReturn(true);
        // when - then
        assertThrows(RuntimeException.class, staleSessionsCollector::execute);
    }
}

