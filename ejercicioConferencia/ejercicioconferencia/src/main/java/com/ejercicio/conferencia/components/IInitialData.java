package com.ejercicio.conferencia.components;
import java.util.List;
import com.ejercicio.conferencia.dto.*;

public interface IInitialData {
    void SetDataConferenceInDataBase();
    List<TemesDto> GetData();
}
