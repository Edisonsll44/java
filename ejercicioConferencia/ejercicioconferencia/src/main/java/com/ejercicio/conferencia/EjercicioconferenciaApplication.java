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
import com.ejercicio.conferencia.service.IConferenceWrapperService;

@SpringBootApplication
public class EjercicioconferenciaApplication implements CommandLineRunner 
{
    private IConferenceWrapperService _conferenceWrapperService;
    public EjercicioconferenciaApplication(IInitialData initialData, IConferenceWrapperService conferenceWrapperService)
    {
            _conferenceWrapperService = conferenceWrapperService;
    }
	public static void main(String[] args) 
	{
		SpringApplication.run(EjercicioconferenciaApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception
    {
            // List<EventConferenceDto> list = _conferenceWrapperService.GeneratedSchedulerConference();
            // for(EventConferenceDto dto : list){
            //     System.out.println("Conference theme: "+ dto.getTitle() + " in "+ dto.getMinutes() + " minutes");
            // }
    }
}
