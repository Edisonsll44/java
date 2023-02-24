package com.ejercicio.conferencia.components;

import java.util.List;
import org.springframework.stereotype.Component;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import com.ejercicio.conferencia.dto.TemesDto;
import com.ejercicio.conferencia.utils.CONSTANT;
import com.ejercicio.conferencia.utils.TemesCompare;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class ConferenceLogic implements IConferenceLogic {

    private List<EventConferenceDto> temesConference;
    private int totalConferenceMinutes;
    private int countByTeme;
    private int countConference; 

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
    
    public ConferenceLogic(){
        this.temesConference = new ArrayList();
    }
    
    public List<EventConferenceDto> ListConferenceTemes(List<TemesDto> temes) {
        int account=0;
        int intMinutes=0;
        int totalMinutes=0;
        
        for(TemesDto dto: temes)
        {
                String strLine;
            try {
                account =+1 ;
                strLine = dto.getResult();
                String title = strLine.substring(0, strLine.lastIndexOf(" "));
                String minutesString = strLine.substring(strLine.lastIndexOf(" ") + 1);
                String minutes = strLine.replaceAll("\\D+", "");
                if ("lightning".equals(minutesString)) {
                    intMinutes = 5;
                    totalMinutes = totalMinutes + intMinutes;
                } else {
                    intMinutes = Integer.parseInt(minutes);
                    totalMinutes = totalMinutes + intMinutes;
                }
                EventConferenceDto singleTalk = new EventConferenceDto(intMinutes, title, account,"");
                temesConference.add(singleTalk);
           
            } catch (Exception e) {
             e.printStackTrace();
            }
        }
        SetCalculatedTimeofSessionByTeme(account, intMinutes,totalMinutes);
        return getTemeConference();
    }
    
    void SetCalculatedTimeofSessionByTeme(int account, int intMinutes, int totalMinutes)
    {
        setCountConference(account);
        setTotalConferenceMinutes(totalMinutes);
        Double totalMinutesInDouble =  totalMinutes*1.0;
        Double numberOfSession =  totalMinutesInDouble/ CONSTANT.TimeConfiguration.TOTAL_CONFERENCE_TALKS_TRACK_MINUTES;
        double fractionalPart = numberOfSession % 1;
        double integralPart = numberOfSession - fractionalPart;
        int leftMinutes = totalMinutes - (int)integralPart*CONSTANT.TimeConfiguration.TOTAL_CONFERENCE_TALKS_TRACK_MINUTES.intValue();
        SetNoSession(leftMinutes,integralPart);
    }
    
    void SetNoSession(int leftMinutes, double integralPart)
    {
        int noOfSession = 0;
        if (leftMinutes > 0) {
            noOfSession = (int) integralPart + 1;
        }else
        {
            noOfSession = (int) integralPart;
        }
        setCountByTeme(noOfSession);
        //Collections.sort(getTemeConference(),new TemesCompare());
        
    }
}
