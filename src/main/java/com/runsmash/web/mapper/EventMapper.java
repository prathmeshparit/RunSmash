package com.runsmash.web.mapper;

import com.runsmash.web.dto.EventDto;
import com.runsmash.web.models.Event;

public class EventMapper
{
    public static Event mapTOEvent(EventDto eventDto) {
        Event event = Event.builder()
                .id((int) eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .club(eventDto.getClub())
                .build();
        return event;
    }
    public static EventDto mapToEventDto(Event  event) {
        return EventDto.builder()
                .id((int) event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .club(event.getClub())
                .build();

    }
}
