package com.ejercicio.conferencia.dto;

import java.util.ArrayList;
import java.util.List;

public class ConferenceDto {
    private List<EventConferenceDto> temesConference;
    private int totalConferenceMinutes;
    private int countByTeme;
    private int countConference; 

    public ConferenceDto(){
        this.temesConference = new ArrayList();
    }

    public List<EventConferenceDto> getTemeConference(){
        return temesConference;
    }

    public void setTemeConference(List<EventConferenceDto> temesConference){
        this.temesConference = temesConference;
    }

    public int getTotalConferenceMinutes(){
        return totalConferenceMinutes;
    }

    public void setTotalConferenceMinutes(int totalConferenceMinutes){
        this.totalConferenceMinutes = totalConferenceMinutes;
    }

    public int getCountByTeme(){
        return countByTeme;
    }

    public void setCountByTeme(int countByTeme){
        this.countByTeme = countByTeme;
    }

    public int getCountConference(){
        return countConference;
    }

    public void setCountConference(int countConference){
        this.countConference = countConference;
    }
    
    public void addTemeConference(EventConferenceDto dto){
        this.temesConference.add(dto);
    }
}
