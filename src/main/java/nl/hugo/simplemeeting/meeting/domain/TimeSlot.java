package nl.hugo.simplemeeting.meeting.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeSlot {
    private LocalDateTime start;
    private LocalDateTime end;

    public TimeSlot(LocalDateTime start, LocalDateTime end) {

        // todo implement object instantiation validation here

        this.start = start;
        this.end = end;
    }

    public boolean isBefore(LocalDateTime date) {
        return this.end.isBefore(date);
    }

    public boolean isAfter(LocalDateTime date) {
        return this.start.isAfter(date);
    }

    /**
     * @param other -> timeslot object
     * todo minimal implementation for TDD green.
     * todo TDD refactor: implement logic for isWithin and isSameDate start/end here (see example tests and slides) using TDD
     * @return true or false
     */
    public boolean isWithin(TimeSlot other) {
        return true;
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public LocalDateTime getEnd() {
        return this.end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(start, timeSlot.start) &&
                Objects.equals(end, timeSlot.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
