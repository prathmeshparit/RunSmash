package com.runsmash.web.repository;

import com.runsmash.web.dto.ClubDto;
import com.runsmash.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClubRepository extends JpaRepository<Club, Long>
{

    Optional<Club> findByTitle(String url);

}
