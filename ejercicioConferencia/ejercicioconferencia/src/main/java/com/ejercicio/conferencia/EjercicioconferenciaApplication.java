package com.ejercicio.conferencia;

import com.ejercicio.conferencia.components.ICalendarTeme;
import com.ejercicio.conferencia.components.IConferenceLogic;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ejercicio.conferencia.components.IInitialData;
import com.ejercicio.conferencia.dto.EventConferenceDto;
import com.ejercicio.conferencia.dto.TemesDto;

@SpringBootApplication
public class EjercicioconferenciaApplication implements CommandLineRunner 
{
	private IInitialData _initialData;
    private IConferenceLogic _conferenceLogic;
    private ICalendarTeme _calendarTeme;
    public EjercicioconferenciaApplication(IInitialData initialData, IConferenceLogic conferenceLogic, ICalendarTeme calendarTeme)
    {
            _initialData = initialData;
            _conferenceLogic = conferenceLogic;
            _calendarTeme = calendarTeme;
    }
	public static void main(String[] args) 
	{
		SpringApplication.run(EjercicioconferenciaApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception
    {
            _initialData.SetDataConferenceInDataBase();
            List<TemesDto> listData = _initialData.GetData();
            List<EventConferenceDto> list = _conferenceLogic.ListConferenceTemes(listData);
            
            int numberOfTemes = _conferenceLogic.getCountByTeme();
            _calendarTeme.ScheduleTalksIntoTracks(numberOfTemes, list);
            
            for(EventConferenceDto dto : list){
                System.out.println("Conference theme: "+ dto.getTitle() + " in "+ dto.getMinutes() + " minutes");
            }
    }
}
