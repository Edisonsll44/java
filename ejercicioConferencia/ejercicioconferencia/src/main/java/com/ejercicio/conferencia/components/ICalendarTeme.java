package com.ejercicio.conferencia.components;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import java.util.List;

public interface ICalendarTeme {
    int ScheduleTalksIntoTracks(int trackCountIndex, List<EventConferenceDto> trackTalks, int trackCount,int startTalkIndex , int totalTalkCount);
}
