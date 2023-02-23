package com.ejercicio.conferencia.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejercicio.conferencia.repository.ConferenceRepositoryTest;

@ExtendWith(MockitoExtension.class)
public class ConferenceWrapperServiceTest {
    @Mock private ConferenceRepositoryTest conference;

    private ConferenceWrapperService conferenceWrapperService;

    @BeforeEach void setUp(){
        List<ConferenceRepositoryTest> list = GetData();
       // this.conferenceWrapperService.GeneratedSchedulerConference(list)
    }


    public List<ConferenceRepositoryTest> GetData(){
        ConferenceRepositoryTest conference1 = new ConferenceRepositoryTest("Writing Fast Tests Against Enterprise Rails 60min*");
        ConferenceRepositoryTest conference2 = new ConferenceRepositoryTest ("¡   Overdoing it in Python 45min");
        ConferenceRepositoryTest conference3 = new ConferenceRepositoryTest ("Lua for the Masses 30min");
        ConferenceRepositoryTest conference4 = new ConferenceRepositoryTest ("Ruby Errors from Mismatched Gem Versions 45min"); 
        ConferenceRepositoryTest conference5 = new ConferenceRepositoryTest ("Common Ruby Errors 45min");
        List<ConferenceRepositoryTest> list = Arrays.asList(conference1, conference2,conference3,conference4,conference5);
        return list;
    }



}
