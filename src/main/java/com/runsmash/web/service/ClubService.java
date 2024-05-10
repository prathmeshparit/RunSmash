package com.runsmash.web.service;

import com.runsmash.web.dto.ClubDto;

import java.util.List;

public interface ClubService
{
    List<ClubDto> findAllClubs();
}
