package com.ejercicio.conferencia.components;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CalendarTeme implements ICalendarTeme {
    public int ScheduleTalksIntoTracks(int account, List<EventConferenceDto> eventsConference, int trackCount, int index, int countConference) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);

    int sum180 = TrackConfiguration.MORNING_TIME_MINUTES;
    int sum240 = TrackConfiguration.AFTERNOON_TIME_MINUTES;

    int TalkIndex;

    String sessionTime;
    String SessionTitle;

    for(TalkIndex=startTalkIndex; TalkIndex< totalTalkCount;TalkIndex++) {


        // Get the combination of 180 and fill it
        if (sum180 >= trackTalks.get(TalkIndex).getMinutes()) {
            sum180 = sum180 - trackTalks.get(TalkIndex).getMinutes();
            sessionTime = sdf.format(cal.getTime()) + " " + trackTalks.get(TalkIndex).getTitle() + " " + trackTalks.get(TalkIndex).getMinutes() + "min";
            trackTalks.get(TalkIndex).setTitle(sessionTime);
            cal.add(Calendar.MINUTE, trackTalks.get(TalkIndex).getMinutes());
            SessionTitle = "Track" + " " + (trackCountIndex + 1);
            trackTalks.get(TalkIndex).setTrackTitle(SessionTitle);
        }
        if (sum180 < trackTalks.get(TalkIndex).getMinutes())
            break;

        if (sum180 > 0)
            continue;

        if (sum180 <= 0)
            break;
    }

    trackTalks.get(TalkIndex).setLunchFlag(true);
    sessionTime = "12:00 PM" + " " + "Lunch";
    trackTalks.get(TalkIndex).setLunchTitle(sessionTime);
    cal.add(Calendar.MINUTE, 60);

    TalkIndex++;

    for(;TalkIndex< totalTalkCount;TalkIndex++) {
        // Get the combination of 180 and fill it
        if (sum240 >= trackTalks.get(TalkIndex).getMinutes()) {
            sum240 = sum240 - trackTalks.get(TalkIndex).getMinutes();
            sessionTime = sdf.format(cal.getTime()) + " " + trackTalks.get(TalkIndex).getTitle() + " " + trackTalks.get(TalkIndex).getMinutes() + "min";
            trackTalks.get(TalkIndex).setTitle(sessionTime);
            cal.add(Calendar.MINUTE, trackTalks.get(TalkIndex).getMinutes());
            SessionTitle = "Track" + " " + (trackCountIndex + 1);
            trackTalks.get(TalkIndex).setTrackTitle(SessionTitle);
        }
        if (sum240 < trackTalks.get(TalkIndex).getMinutes())
            break;

        if (sum240 > 0)
            continue;

        if (sum240 <= 0)
            break;
    }

    if(totalTalkCount == (TalkIndex))
        --TalkIndex;
    trackTalks.get(TalkIndex).setNetworkingFlag(true);
    sessionTime = "5:00 PM" + " " + "Networking Event";
    trackTalks.get(TalkIndex).setNetworkingTitle(sessionTime);

    // TBD : Add rules to re-evaluate the Schedule of Talks into Tracks e.g. If on evaluation its found that on Track-1
    // we have 30 free minutes and on Track-2 we have 45 free minutes, and one talk of 60 minutes need to schedule.
    // We can shuffle 30 mins talks from Track-1 to Track-2 , and accommodate this 60 mins talk to track-1
    // Only varieties of input will provide right sense.

    TalkIndex++;
    return TalkIndex;
    }
    
}
