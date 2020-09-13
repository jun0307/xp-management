package com.platform.cloud.xpmanagement.unittest.service;

import com.platform.cloud.xpmanagement.domain.Experience;
import com.platform.cloud.xpmanagement.domain.ExperienceLog;
import com.platform.cloud.xpmanagement.domain.vo.ExperienceVO;
import com.platform.cloud.xpmanagement.domain.vo.converter.ExperienceVOConverter;
import com.platform.cloud.xpmanagement.repository.ExperienceLogRepository;
import com.platform.cloud.xpmanagement.repository.ExperienceRepository;
import com.platform.cloud.xpmanagement.service.impl.ExperienceServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ExperienceServiceTest {

    @InjectMocks
    private ExperienceServiceImpl experienceService;

    @Mock
    private ExperienceRepository experienceRepository;

    @Mock
    private ExperienceLogRepository experienceLogRepository;

    @Mock
    private ExperienceVOConverter experienceVOConverter;


    @BeforeTestMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetExperience_Null() {
        Experience experience = null;
        when(experienceRepository.findByPlayerId(any())).thenReturn(experience);
        ExperienceVO experienceVO = experienceService.getExperience(null);
        Assert.assertEquals(experienceVO, null);
        verify(experienceRepository, times(1)).save(any(Experience.class));
    }

    @Test
    public void testGetExperience_NotNull() {
        Experience experience = new Experience();
        experience.setPlayerId(1);
        when(experienceRepository.findByPlayerId(any())).thenReturn(experience);
        ExperienceVO experienceVO = experienceService.getExperience(null);
        Assert.assertEquals(experienceVO, null);
        verify(experienceRepository, times(0)).save(any(Experience.class));
        verify(experienceVOConverter, times(1)).convertToTarget(any(Experience.class));
    }

    @Test
    public void testAddExperience_Null() {
        experienceService.addExperience(null);
        verify(experienceRepository, times(0)).findByPlayerId(any());
    }

    @Test
    public void testAddExperience_NotExist() {
        ExperienceLog experienceLog = new ExperienceLog();
        experienceLog.setPoints(2);
        experienceLog.setPlayerId(1);

        Experience experience = null;
        when(experienceRepository.findByPlayerId(any())).thenReturn(experience);

        experienceService.addExperience(experienceLog);
        verify(experienceRepository, times(2)).save(any(Experience.class));
        verify(experienceLogRepository, times(1)).save(any(ExperienceLog.class));
    }

    @Test
    public void testAddExperience_Exist() {
        ExperienceLog experienceLog = new ExperienceLog();
        experienceLog.setPoints(2);
        experienceLog.setPlayerId(1);

        Experience experience = new Experience();
        experience.setBalance(1);
        when(experienceRepository.findByPlayerId(any())).thenReturn(experience);

        experienceService.addExperience(experienceLog);
        verify(experienceRepository, times(1)).save(any(Experience.class));
        verify(experienceLogRepository, times(1)).save(any(ExperienceLog.class));
    }

}
