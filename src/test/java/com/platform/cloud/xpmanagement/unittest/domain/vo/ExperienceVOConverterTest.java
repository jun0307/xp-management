package com.platform.cloud.xpmanagement.unittest.domain.vo;

import com.platform.cloud.xpmanagement.domain.Experience;
import com.platform.cloud.xpmanagement.domain.vo.ExperienceVO;
import com.platform.cloud.xpmanagement.domain.vo.converter.ExperienceVOConverter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Date;

@SpringBootTest
public class ExperienceVOConverterTest {

    @InjectMocks
    private ExperienceVOConverter experienceVOConverter;

    @BeforeTestMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void convertToTarget_null() {
        ExperienceVO experienceVO = experienceVOConverter.convertToTarget(null);
        Assert.assertEquals(experienceVO, null);
    }

    @Test
    public void convertToTarget_NotNull() {
        Experience experience=new Experience();
        experience.setBalance(1);
        experience.setUpdatedAtTimestamp(new Date());
        experience.setCreatedAtTimeStamp(new Date());
        ExperienceVO experienceVO = experienceVOConverter.convertToTarget(experience);
        Assert.assertEquals(experience.getBalance(), Integer.valueOf(1));
        Assert.assertNotNull(experienceVO.getCreated_at_timeStamp());
        Assert.assertNotNull(experienceVO.getUpdated_at_timestamp());
    }

}
