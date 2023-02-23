package com.ejercicio.conferencia.components;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import java.util.List;

public interface ICalendarTeme {
    int ScheduleTalksIntoTracks(int account, List<EventConferenceDto> eventsConference, int trackCount,int index , int countConference);
}
