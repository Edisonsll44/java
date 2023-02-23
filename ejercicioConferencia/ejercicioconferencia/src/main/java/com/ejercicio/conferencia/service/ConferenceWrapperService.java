package com.ejercicio.conferencia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicio.conferencia.components.ICalendarTeme;
import com.ejercicio.conferencia.components.IConferenceLogic;
import com.ejercicio.conferencia.components.IInitialData;
import com.ejercicio.conferencia.dto.EventConferenceDto;
import com.ejercicio.conferencia.dto.TemesDto;
@Service
public class ConferenceWrapperService implements IConferenceWrapperService
{
    private IInitialData _initialData;
    private IConferenceLogic _conferenceLogic;
    private ICalendarTeme _calendarTeme;

    public ConferenceWrapperService(ICalendarTeme calendarTeme, IConferenceLogic conferenceLogic, IInitialData initialData)
    {
        _initialData = initialData;
        _conferenceLogic = conferenceLogic;
        _calendarTeme = calendarTeme;
    }
    public List<EventConferenceDto> GeneratedSchedulerConference()
    {
        _initialData.SetDataConferenceInDataBase();
        List<TemesDto> listData = _initialData.GetData();
        List<EventConferenceDto> list = _conferenceLogic.ListConferenceTemes(listData);
        int numberOfTemes = _conferenceLogic.getCountByTeme();
        _calendarTeme.ScheduleTalksIntoTracks(numberOfTemes, list);
        return list;
    }
}
