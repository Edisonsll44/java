package com.ejercicio.conferencia.service;

import java.util.List;
import com.ejercicio.conferencia.dto.EventConferenceDto;
import com.ejercicio.conferencia.dto.TemesDto;

public interface IConferenceWrapperService {
    List<EventConferenceDto> GeneratedSchedulerConference();

    List<EventConferenceDto> GeneratedSchedulerConference(List<TemesDto> listData);
}
