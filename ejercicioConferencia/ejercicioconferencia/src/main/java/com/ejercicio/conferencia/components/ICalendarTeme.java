package com.ejercicio.conferencia.components;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import java.util.List;

public interface ICalendarTeme {
    List<EventConferenceDto> ScheduleTalksIntoTracks(int numberOfTemes, List<EventConferenceDto> eventConference);

    void OutputOfTalksIntoTracks(List<EventConferenceDto> trackTalks);
}
