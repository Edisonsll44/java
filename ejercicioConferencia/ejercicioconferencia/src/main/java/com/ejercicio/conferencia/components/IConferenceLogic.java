package com.ejercicio.conferencia.components;

import com.ejercicio.conferencia.dto.*;
import java.util.List;

public interface IConferenceLogic {
    List<EventConferenceDto> ListConferenceTemes(List<TemesDto> temes);
    int getCountByTeme();
}
