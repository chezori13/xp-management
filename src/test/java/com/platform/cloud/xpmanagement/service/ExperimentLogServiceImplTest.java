package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.model.ExperienceLog;
import com.platform.cloud.xpmanagement.model.basetype.ExperienceType;
import com.platform.cloud.xpmanagement.repository.ExperienceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExperimentLogServiceImplTest {
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ExperienceLogService experienceLogService;

    Experience experience;

    final Integer playerId = 123;

    @BeforeEach
    void setup() {
        experience = new Experience(playerId);
        experience.setExperienceId(1);
        experienceRepository.save(experience);
    }

    @Test
    void createExperienceLog_shouldSucceed() {
        ExperienceLog experienceLog = experienceLogService.createExperienceLog(experience, 10);
        assertEquals(10, experienceLog.getAmount());
        assertEquals(1, experienceLog.getExperience().getExperienceId());
        assertEquals(playerId, experienceLog.getPlayerId());
        assertNull(experienceLog.getRemarks());

    }

    @Test
    void createExperienceLog_withPositiveValue_shouldBeTypeEARN() {
        ExperienceLog experienceLog = experienceLogService.createExperienceLog(experience, 100);
        assertEquals(100, experienceLog.getAmount());
        assertEquals(1, experienceLog.getExperience().getExperienceId());
        assertEquals(playerId, experienceLog.getPlayerId());
        assertEquals(ExperienceType.EARN, experienceLog.getType());
    }

    @Test
    void createExperienceLog_withNegativeValue_shouldBeTypePENALTY() {
        ExperienceLog experienceLog = experienceLogService.createExperienceLog(experience, -80);
        assertEquals(-80, experienceLog.getAmount());
        assertEquals(1, experienceLog.getExperience().getExperienceId());
        assertEquals(playerId, experienceLog.getPlayerId());
        assertEquals(ExperienceType.PENALTY, experienceLog.getType());
    }


    @Test
    void createExperienceLog_withNull_shouldThrowEx() {

        assertThrows(IllegalArgumentException.class, () -> {
            ExperienceLog experienceLog = experienceLogService.createExperienceLog(experience, null);
        });

    }
}
