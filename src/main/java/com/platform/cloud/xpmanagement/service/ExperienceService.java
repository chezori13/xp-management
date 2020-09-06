package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.model.Experience;

public interface ExperienceService {
    public Experience getOrInitiateExperience(Integer playerId);
    public Experience createExperience(Integer playerId);
    public Experience addExperiencePoints(Integer playerId, Integer points);
}
