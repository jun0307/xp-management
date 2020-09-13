package com.platform.cloud.xpmanagement.repository;

import com.platform.cloud.xpmanagement.domain.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    Experience findByPlayerId(Integer playerId);
}
