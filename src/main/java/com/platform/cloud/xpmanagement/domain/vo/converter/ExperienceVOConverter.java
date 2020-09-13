package com.platform.cloud.xpmanagement.domain.vo.converter;

import com.platform.cloud.xpmanagement.domain.Experience;
import com.platform.cloud.xpmanagement.domain.vo.ExperienceVO;
import org.springframework.stereotype.Component;

@Component
public class ExperienceVOConverter implements Convertable<Experience, ExperienceVO> {

    @Override
    public ExperienceVO convertToTarget(Experience experience) {
        if (null == experience) {
            return null;
        }
        ExperienceVO experienceVO = new ExperienceVO();
        experienceVO.setBalance(experience.getBalance());
        experienceVO.setCreated_at_timeStamp(experience.getCreatedAtTimeStamp());
        experienceVO.setUpdated_at_timestamp(experience.getUpdatedAtTimestamp());
        return experienceVO;
    }
}
