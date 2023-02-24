package com.ejercicio.conferencia.components;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import com.ejercicio.conferencia.utils.CONSTANT;
import com.ejercicio.conferencia.utils.TemesCompare;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CalendarTeme implements ICalendarTeme 
{
    public List<EventConferenceDto> ScheduleTalksIntoTracks(int numberOfTemes, List<EventConferenceDto> eventConference) 
    {
        int startTeme = 0;
        for(int startkIndex = 0; startkIndex <numberOfTemes; startkIndex++)
        {
           startTeme = SetConfigurations(startkIndex,numberOfTemes,eventConference, startTeme);
        } 
        return eventConference;
    }

   
    public void OutputOfTalksIntoTracks(List<EventConferenceDto> eventConference) 
    {
        for(int trackCountIndex=0;trackCountIndex<eventConference.size();trackCountIndex++)
        {
            if(eventConference.get(trackCountIndex).isLunchFlag())
            {
                EventConferenceDto launchEvent = new EventConferenceDto(
                    eventConference.get(trackCountIndex).getMinutes() , 
                    eventConference.get(trackCountIndex).getLunchTitle(), 
                    eventConference.get(trackCountIndex).getIdLunch(),
                    eventConference.get(trackCountIndex).getconferenceTitle());
                eventConference.add(launchEvent);
            }

            if(eventConference.get(trackCountIndex).isNetworkingFlag())
            {
                EventConferenceDto networkingEvent = new EventConferenceDto(
                    eventConference.get(trackCountIndex).getMinutes() , 
                    eventConference.get(trackCountIndex).getNetworkingTitle(), 
                    eventConference.get(trackCountIndex).getIdLunch(),
                    eventConference.get(trackCountIndex).getconferenceTitle());
                    eventConference.add(networkingEvent);
            }
        }
    }

    int SetConfigurations(int startkIndex, int numberOfTemes, List<EventConferenceDto> eventConference, int startTeme)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);

    int sum180 = CONSTANT.TimeConfiguration.MORNING_TIME_MINUTES;
    int sum240 = CONSTANT.TimeConfiguration.AFTERNOON_TIME_MINUTES;
    int account = 0;    
    int index;

    String sessionTime;
    String SessionTitle;

    for(index=startTeme; index< eventConference.size();index++) {
        if (sum180 >= eventConference.get(index).getMinutes()) {
            account+=1;
            sum180 = sum180 - eventConference.get(index).getMinutes();
            sessionTime = sdf.format(cal.getTime()) + " " + eventConference.get(index).getTitle() + " " + eventConference.get(index).getMinutes() + "min";
            eventConference.get(index).setTitle(sessionTime);
            cal.add(Calendar.MINUTE, eventConference.get(index).getMinutes());
            SessionTitle = "Track" + " " + (startkIndex + 1);
            eventConference.get(index).setconferenceTitle(SessionTitle);
            eventConference.get(index).setId(account);
        }
        if (sum180 < eventConference.get(index).getMinutes())
            break;

        if (sum180 > 0)
            continue;

        if (sum180 <= 0)
            break;
    }
    account+=1;
    eventConference.get(index).setLunchFlag(true);
    sessionTime = "12:00 PM" + " " + "Lunch";
    eventConference.get(index).setLunchTitle(sessionTime);
    eventConference.get(index).setLunchTitle(sessionTime);
    eventConference.get(index).setIdLunch(account);
    eventConference.get(index).setconferenceTitle("Track" + " " + (startkIndex + 1));
    cal.add(Calendar.MINUTE, 60);

    index++;

    for(;index< eventConference.size();index++) {
        
        if (sum240 >= eventConference.get(index).getMinutes()) {
            account+=1;
            sum240 = sum240 - eventConference.get(index).getMinutes();
            sessionTime = sdf.format(cal.getTime()) + " " + eventConference.get(index).getTitle() + " " + eventConference.get(index).getMinutes() + "min";
            eventConference.get(index).setTitle(sessionTime);
            cal.add(Calendar.MINUTE, eventConference.get(index).getMinutes());
            SessionTitle = "Track" + " " + (startkIndex + 1);
            eventConference.get(index).setconferenceTitle(SessionTitle);
            eventConference.get(index).setId(account);
        }
        if (sum240 < eventConference.get(index).getMinutes())
            break;

        if (sum240 > 0)
            continue;

        if (sum240 <= 0)
            break;
    }
    
    if(eventConference.size() == (index))
        --index;
    
    account+=1;
    eventConference.get(index).setNetworkingFlag(true);
    sessionTime = "5:00 PM" + " " + "Networking Event";
    eventConference.get(index).setNetworkingTitle(sessionTime);
    eventConference.get(index).setIdLunch(account);
    index++;
    account = 0;
    return index;
    }
}
