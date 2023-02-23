package com.ejercicio.conferencia.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import com.ejercicio.conferencia.dto.*;
import com.ejercicio.conferencia.data.models.Conference;
import com.ejercicio.conferencia.repository.IConferenceRepository;

@Component
public class InitialData implements IInitialData {
    private IConferenceRepository _conferenceRepository;
    public InitialData(IConferenceRepository conferenceRepository)
    {
        _conferenceRepository = conferenceRepository;
    }
    public void SetDataConferenceInDataBase(){
        Conference conference1 = new Conference("Writing Fast Tests Against Enterprise Rails 60min*");
        Conference conference2 = new Conference ("¡   Overdoing it in Python 45min");
        Conference conference3 = new Conference ("Lua for the Masses 30min");
        Conference conference4 = new Conference ("Ruby Errors from Mismatched Gem Versions 45min"); 
        Conference conference5 = new Conference ("Common Ruby Errors 45min");
        Conference conference6 = new Conference ("Rails for Python Developers lightning");
        Conference conference7 = new Conference ("Communicating Over Distance 60min");
        Conference conference8 = new Conference ("Accounting-Driven Development 45min");
        Conference conference9 = new Conference ("Woah 30min");
        Conference conference10 = new Conference ("Sit Down and Write 30min");
        Conference conference11 = new Conference ("Pair Programming vs Noise 45min");
        Conference conference12 = new Conference ("Rails Magic 60min");
        Conference conference13 = new Conference ("Ruby on Rails: Why We Should Move On 60min");
        Conference conference14 = new Conference ("Clojure Ate Scala (on my project) 45min");
        Conference conference15 = new Conference ("Programming in the Boondocks of Seattle 30min");
        Conference conference16 = new Conference ("Ruby vs. Clojure for Back-End Development 30min");
        Conference conference17 = new Conference ("Ruby on Rails Legacy App Maintenance 60min");
        Conference conference18 = new Conference ("A World Without HackerNews 30min");
        Conference conference19 = new Conference ("User Interface CSS in Rails Apps 30min");
        List<Conference> list = Arrays.asList(conference1,conference2,conference3,conference4,conference5,
        conference6,conference7,conference8,conference9,conference10,
        conference11,conference12,conference13,conference14,conference15,
        conference16,conference17,conference18,conference19);
		_conferenceRepository.saveAll(list);
    }

    public List<TemesDto> GetData()
	{
        List<TemesDto> list = new ArrayList<>();
		_conferenceRepository.findAll()
		.stream()
                .forEach(d-> {
                       TemesDto teme = new TemesDto();
                       teme.setResult(d.getDescription());
                       list.add(teme);
                });
        return list;
	}
}
