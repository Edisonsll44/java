package com.ejercicio.conferencia.components;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ejercicio.conferencia.dto.*;
import com.ejercicio.conferencia.utils.CONSTANT;
import com.ejercicio.conferencia.utils.TemesCompare;
import java.util.Collections;

@Component
public class ConferenceLogic implements IConferenceLogic {

    ConferenceDto conferenceDto;
    
    public ConferenceLogic(){
        conferenceDto = new ConferenceDto();
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
                EventConferenceDto singleTalk = new EventConferenceDto(intMinutes, title, account);
                conferenceDto.addTemeConference(singleTalk);
           
            } catch (Exception e) {
             e.printStackTrace();
            }
        }
        SetCalculatedTimeofSessionByTeme(account, intMinutes,totalMinutes);
        return conferenceDto.getTemeConference();
    }
    
    void SetCalculatedTimeofSessionByTeme(int account, int intMinutes, int totalMinutes)
    {
        conferenceDto.setCountConference(account);
        conferenceDto.setTotalConferenceMinutes(totalMinutes);
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
        conferenceDto.setCountByTeme(noOfSession);
        Collections.sort(conferenceDto.getTemeConference(),new TemesCompare());
    }
}
