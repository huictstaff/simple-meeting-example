package nl.hugo.simplemeeting.meeting.domain;

import nl.hugo.simplemeeting.meeting.domain.error.InvalidTimeSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Time slot")
public class TimeSlotTest {
    private static final LocalDateTime JANUARY =
            LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0, 0);
    private static final LocalDateTime FEBRUARY =
            LocalDateTime.of(2020, Month.FEBRUARY, 1, 0, 0, 0);
    private static final LocalDateTime MARCH =
            LocalDateTime.of(2020, Month.MARCH, 1, 0, 0, 0);
    private static final LocalDateTime APRIL =
            LocalDateTime.of(2020, Month.APRIL, 1, 0, 0, 0);

    /**
     * This test is an example of assertions that are valid within JUnit,
     * but often appear in student projects to fluff the coverage and number of tests.
     * These assertions do often not test behavior but simple trivial technical stats instead
     */
    @Test
    void WatchOutTheseAreNotReallyAssertions() {
        TimeSlot timeSlot = new TimeSlot(FEBRUARY, MARCH);

        List<TimeSlot> l = List.of(timeSlot);
        assertEquals(1, l.size());

        assertNotNull(timeSlot);
    }

    /**
     * TODO for the demo implement the tests:
     * noStartAfterEnd
     * successfulCreation
     * beforeADate
     * notBeforeADate
     * afterADate
     * notAfterADate
     * sameTimeSlot
     * notSameTimeSlot
     * inAnotherTimeSlot
     * notInAnotherTimeSlot
     * inAnotherTimeSlotWithSameStart
     * inAnotherTimeSlotWithSameEnd
     * <p>
     * Use the tests with the names starting with 'example' as an example implementation
     */

    @Test
    @DisplayName("cannot be created if start comes after end")
    void exampleNoStartAfterEnd() {
        assertThrows(
                InvalidTimeSlot.class,
                () -> new TimeSlot(MARCH, FEBRUARY)
        );
    }

    @Test
    @DisplayName("is created successfully")
    void ExampleSuccessfulCreation() {
        TimeSlot timeSlot = new TimeSlot(JANUARY, APRIL);

        //More technical assertion compared to the more business readable assertSame below
        assertDoesNotThrow(() -> new TimeSlot(FEBRUARY, MARCH));

        assertSame(JANUARY, timeSlot.getStart());
        assertSame(APRIL, timeSlot.getEnd());
    }

    @Test
    @DisplayName("comes before a date")
    void exampleBeforeADate() {
        TimeSlot timeSlot = new TimeSlot(JANUARY, MARCH);
        boolean isBefore = timeSlot.isBefore(APRIL);
        assertTrue(isBefore);
    }

    @Test
    @DisplayName("does not come before a date")
    void exampleNotBeforeADate() {
        TimeSlot timeSlot = new TimeSlot(JANUARY, MARCH);
        boolean isBefore = timeSlot.isBefore(JANUARY);
        assertFalse(isBefore);
    }

    @Test
    @DisplayName("comes after a date")
    void exampleAfterADate() {
        TimeSlot timeSlot = new TimeSlot(FEBRUARY, MARCH);
        boolean isAfter = timeSlot.isAfter(JANUARY);
        assertTrue(isAfter);
    }

    @Test
    @DisplayName("does not come after a date")
    void exampleNotAfterADate() {
        TimeSlot timeSlot = new TimeSlot(FEBRUARY, MARCH);
        boolean isAfter = timeSlot.isAfter(APRIL);
        assertFalse(isAfter);
    }

    @Test
    @DisplayName("is the same as another time slot")
    void exampleSameTimeSlot() {
        TimeSlot timeSlot = new TimeSlot(FEBRUARY, MARCH);
        TimeSlot sameTimeSlot = new TimeSlot(FEBRUARY, MARCH);

        assertEquals(timeSlot, sameTimeSlot);
        assertEquals(timeSlot.hashCode(), sameTimeSlot.hashCode());
    }

    @Test
    @DisplayName("is not the same as another time slot")
    void exampleNotSameTimeSlot() {
        TimeSlot timeSlot = new TimeSlot(FEBRUARY, MARCH);
        TimeSlot differentTimeSlot = new TimeSlot(JANUARY, FEBRUARY);

        assertNotEquals(timeSlot, differentTimeSlot);
        assertNotEquals(timeSlot.hashCode(), differentTimeSlot.hashCode());
    }

    @Test
    @DisplayName("falls within another time slot")
    void exampleInAnotherTimeSlot() {
        TimeSlot timeSlot = new TimeSlot(JANUARY, APRIL);
        TimeSlot embeddedTimeSlot = new TimeSlot(FEBRUARY, MARCH);

        boolean isWithin = embeddedTimeSlot.isWithin(timeSlot);

        assertTrue(isWithin);
    }

    @Test
    @DisplayName("does not fall within another time slot")
    void exampleNotInAnotherTimeSlot() {
        TimeSlot timeSlot = new TimeSlot(MARCH, APRIL);
        TimeSlot outsideTimeSlot = new TimeSlot(JANUARY, FEBRUARY);

        boolean isWithin = outsideTimeSlot.isWithin(timeSlot);

        assertFalse(isWithin);
    }

    @Test
    @DisplayName("falls within another time slot with the same start")
    void exampleInAnotherTimeSlotWithSameStart() {
        TimeSlot timeSlot = new TimeSlot(JANUARY, APRIL);
        TimeSlot embeddedTimeSlot = new TimeSlot(JANUARY, MARCH);

        boolean isWithin = embeddedTimeSlot.isWithin(timeSlot);

        assertTrue(isWithin);
    }

    @Test
    @DisplayName("falls within another time slot with the same end")
    void exampleInAnotherTimeSlotWithSameEnd() {
        TimeSlot timeSlot = new TimeSlot(JANUARY, APRIL);
        TimeSlot embeddedTimeSlot = new TimeSlot(FEBRUARY, APRIL);

        boolean isWithin = embeddedTimeSlot.isWithin(timeSlot);

        assertTrue(isWithin);
    }
}
