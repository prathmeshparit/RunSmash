package com.runsmash.web.controller;



import com.runsmash.web.dto.ClubDto;
import com.runsmash.web.dto.EventDto;
import com.runsmash.web.models.Event;
import com.runsmash.web.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/events/{eventId}")
    public  String viewEvent(Model model, @PathVariable("eventId") Long eventId)
    {
        EventDto eventDto = eventService.findByEvenId(eventId);
        model.addAttribute("event", eventDto);
        return "events-details";
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

    @GetMapping("/events/{eventId}/edit")
    public String editClubForm(@PathVariable("eventId") long eventId,  Model model)
    {
        EventDto eventDto= eventService.findEventById(eventId);
        model.addAttribute("event",eventDto);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId,
                              @ModelAttribute("event") EventDto event) {

        EventDto eventDto = eventService.findByEvenId(eventId);
        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteClub(@PathVariable("eventId") long eventId) {
        eventService.delete(eventId);
        return "redirect:/events";
    }


}
