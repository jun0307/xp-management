package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.domain.ExperienceLog;
import com.platform.cloud.xpmanagement.domain.vo.ExperienceVO;

public interface ExperienceService {

    ExperienceVO getExperience(Integer playerId);

    void addExperience(ExperienceLog experienceLog);
}
