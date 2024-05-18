package com.runsmash.web.controller;



import com.runsmash.web.dto.EventDto;
import com.runsmash.web.models.Event;
import com.runsmash.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController
{
    EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/events")
    public String eventList(Model model)
    {
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";

    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") long clubId, Model model)
    {
            Event event = new Event();
            model.addAttribute("clubId" , clubId);
            model.addAttribute("event" , event);
            return "events-create";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId" ) long clubId, @ModelAttribute("event") EventDto eventDto, Model model)
    {
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/" + clubId;
    }
}
