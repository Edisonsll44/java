package com.ejercicio.conferencia.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import com.ejercicio.conferencia.service.IConferenceWrapperService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/conference")
public class ConferenceController {
    private IConferenceWrapperService _conferenceWrapperService;

    public ConferenceController(IConferenceWrapperService conferenceWrapperService)
    {
        _conferenceWrapperService = conferenceWrapperService;
    }

    @GetMapping
    public ResponseEntity<List<EventConferenceDto>> getScheduleConference() {
        List<EventConferenceDto> conferences = _conferenceWrapperService.GeneratedSchedulerConference();
        return new ResponseEntity<>(conferences,HttpStatus.OK);
    }
}
