package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.model.ExperienceLog;

public interface ExperienceLogService {
    public ExperienceLog createExperienceLog(Experience experience, Integer points);
    public ExperienceLog createExperienceLog(Experience experience, Integer points, String remarks);
}
