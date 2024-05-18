package com.runsmash.web.repository;

import com.runsmash.web.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long>
{

}
