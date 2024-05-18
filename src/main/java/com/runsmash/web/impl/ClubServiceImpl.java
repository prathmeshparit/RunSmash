package com.runsmash.web.impl;

import com.runsmash.web.dto.ClubDto;
import com.runsmash.web.models.Club;
import com.runsmash.web.repository.ClubRepository;
import com.runsmash.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.runsmash.web.mapper.ClubMapper.mapTOClub;
import static com.runsmash.web.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;


    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository)
    {
        this.clubRepository = clubRepository;
    }


    @Override
    public Club saveClub(Club club) {

        return clubRepository.save(club);
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();

       return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public ClubDto findClubById(long clubId) {
       Club club =  clubRepository.findById( clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto dto) {
        Club clubs = mapTOClub(dto);
        clubRepository.save(clubs);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);

    }

    @Override
    public List<ClubDto> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
