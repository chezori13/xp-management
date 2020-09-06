package com.platform.cloud.xpmanagement.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.repository.ExperienceRepository;
import com.platform.cloud.xpmanagement.view.ExperienceLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExperienceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ExperienceRepository experienceRepository;


    @Test
    void getExperienceByPlayerId_shouldCreateExperienceRecord() throws Exception {

        mockMvc.perform(get("/experience/{player_id}", 99)
                .contentType("application/json")).andExpect(status().isOk());

        Experience experience = experienceRepository.findByPlayerId(99);
        assertEquals(0, experience.getBalance());
        assertEquals(99, experience.getPlayerId());
        assertEquals(0, experience.getExperienceLog().size());

    }

    @Test
    void addExperiencePoints_shouldCreateExperienceLogRecordAndUpdateBalance() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ExperienceLog experienceLog = new ExperienceLog();
        experienceLog.setPoints(888);


        mockMvc.perform(post("/experience/{player_id}", 88)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(experienceLog)))
                .andExpect(status().isCreated());

        Experience experience = experienceRepository.findByPlayerId(88);
        assertEquals(888, experience.getBalance());
        assertEquals(88, experience.getPlayerId());
        assertEquals(1, experience.getExperienceLog().size());

    }
}
