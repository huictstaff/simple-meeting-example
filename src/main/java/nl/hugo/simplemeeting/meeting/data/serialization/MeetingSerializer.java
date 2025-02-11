package nl.hugo.simplemeeting.meeting.data.serialization;

import nl.hugo.simplemeeting.meeting.domain.Meeting;

import java.util.List;

public interface MeetingSerializer {
    String serialize(List<Meeting> meetings);
    List<Meeting> deserialize(String meetingsData);
}
