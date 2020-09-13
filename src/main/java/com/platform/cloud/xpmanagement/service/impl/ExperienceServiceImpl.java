package com.platform.cloud.xpmanagement.service.impl;

import com.platform.cloud.xpmanagement.common.constant.Type;
import com.platform.cloud.xpmanagement.domain.Experience;
import com.platform.cloud.xpmanagement.domain.ExperienceLog;
import com.platform.cloud.xpmanagement.domain.vo.ExperienceVO;
import com.platform.cloud.xpmanagement.domain.vo.converter.ExperienceVOConverter;
import com.platform.cloud.xpmanagement.repository.ExperienceLogRepository;
import com.platform.cloud.xpmanagement.repository.ExperienceRepository;
import com.platform.cloud.xpmanagement.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExperienceLogRepository experienceLogRepository;

    @Autowired
    private ExperienceVOConverter experienceVOConverter;

    @Override
    public ExperienceVO getExperience(Integer playerId) {
        Experience experience = experienceRepository.findByPlayerId(playerId);
        if (null == experience) {
            experience = insertExperience(playerId);
        }
        return experienceVOConverter.convertToTarget(experience);
    }

    private Experience insertExperience(Integer playerId) {
        Experience experience = new Experience();
        experience.setBalance(0);
        experience.setPlayerId(playerId);
        experience.setCreatedAtTimeStamp(new Date());
        experience.setUpdatedAtTimestamp(new Date());
        experienceRepository.save(experience);
        return experience;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addExperience(ExperienceLog experienceLog) {
        if (null == experienceLog) {
            return;
        }

        Experience experience = experienceRepository.findByPlayerId(experienceLog.getPlayerId());
        if (null == experience) {
            experience = insertExperience(experienceLog.getPlayerId());
        }
        experienceLog.setExperienceId(experience.getExperienceId());
        insertExperienceLog(experienceLog);
        updateExperienceBalance(experience, experienceLog);
    }

    private void updateExperienceBalance(Experience experience, ExperienceLog experienceLog) {
        if (null == experience || null == experienceLog) {
            return;
        }
        experience.setBalance(experience.getBalance() + experienceLog.getPoints());
        experience.setUpdatedAtTimestamp(new Date());
        experienceRepository.save(experience);
    }

    private void insertExperienceLog(ExperienceLog experienceLog) {
        if (null == experienceLog) {
            return;
        }

        experienceLog.setCreatedAtTimestamp(new Date());
        if (experienceLog.getPoints() >= 0) {
            experienceLog.setType(Type.EARN);
        } else {
            experienceLog.setType(Type.PENALTY);
        }

        experienceLogRepository.save(experienceLog);
    }
}
