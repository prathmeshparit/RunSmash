package com.runsmash.web.dto;

import com.runsmash.web.models.Event;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EventDto
{
    private long id;
    @NotEmpty(message = "Event Name Should not be Empty ")
    private String name;
    @NotEmpty(message = "Event Type Should not be Empty ")
    private String type;
    @NotEmpty(message = "Event photo Should not be Empty ")
    private String photoUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;


}
