package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.repository.ExperienceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ExperimentServiceImplTest {
    @Autowired
    ExperienceService experienceService;

    @Autowired
    ExperienceRepository experienceRepository;

    @Test
    public void getOrInitiateExperience_withNewPlayerId_shouldReturnNewExperience(){
        //Ensure no player record
        Experience experience = experienceRepository.findByPlayerId(123);
        assertNull(experience);

        experience = experienceService.getOrInitiateExperience(123);

        assertEquals(0, experience.getBalance());
        assertEquals(123, experience.getPlayerId());
        assertEquals(0, experience.getExperienceLog().size());
    }

    @Test
    public void addExperiencePoints_balanceShouldTally(){

        Experience experience = experienceService.addExperiencePoints(124, 100);

        assertEquals(100, experience.getBalance());
        assertEquals(124, experience.getPlayerId());
        assertEquals(1, experience.getExperienceLog().size());
    }

    @Test
    public void addExperiencePointsMultipleTimes_balanceShouldTally(){

        experienceService.addExperiencePoints(125, 100);
        experienceService.addExperiencePoints(125, 100);
        experienceService.addExperiencePoints(125, 100);
        Experience experience = experienceService.addExperiencePoints(125, -50);

        assertEquals(125, experience.getPlayerId());
        assertEquals(250, experience.getBalance());
        assertEquals(4, experience.getExperienceLog().size());
    }

}
