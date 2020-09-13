package com.platform.cloud.xpmanagement.repository;

import com.platform.cloud.xpmanagement.domain.ExperienceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceLogRepository extends JpaRepository<ExperienceLog, Integer> {
    List<ExperienceLog> findByExperienceId(Integer experienceId);
}
