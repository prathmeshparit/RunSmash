package com.runsmash.web.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto
{

    private long id;
    @NotEmpty(message=" Club title should not be Empty")
    private String title;
    @NotEmpty(message=" Club photoUrl should not be Empty")
    private String photoUrl;
    @NotEmpty(message=" Club content should not be Empty")
    private String content;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
    private List<EventDto> events;
}
