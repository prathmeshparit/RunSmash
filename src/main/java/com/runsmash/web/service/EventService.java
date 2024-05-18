package com.runsmash.web.service;

import com.runsmash.web.dto.EventDto;
import com.runsmash.web.models.Event;

import java.util.List;

public interface EventService
{
    void createEvent(long clubId, EventDto eventdto);

    List<EventDto> findAllEvents();
}
