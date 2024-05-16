package com.runsmash.web.service;

import com.runsmash.web.dto.ClubDto;
import com.runsmash.web.models.Club;

import java.util.List;

public interface ClubService
{
      Club saveClub(Club club) ;
    List<ClubDto> findAllClubs();



}
