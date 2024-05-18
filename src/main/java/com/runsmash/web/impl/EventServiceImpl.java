package com.runsmash.web.impl;

import com.runsmash.web.dto.ClubDto;
import com.runsmash.web.dto.EventDto;
import com.runsmash.web.models.Club;
import com.runsmash.web.models.Event;
import com.runsmash.web.repository.ClubRepository;
import com.runsmash.web.repository.EventRepository;
import com.runsmash.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.runsmash.web.mapper.EventMapper.mapTOEvent;
import static com.runsmash.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService
{
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository)
    {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }
    @Override
    public void createEvent(long clubId, EventDto eventDto)
    {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapTOEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);

    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }


}
