package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.model.ExperienceLog;
import com.platform.cloud.xpmanagement.model.basetype.ExperienceType;
import com.platform.cloud.xpmanagement.repository.ExperienceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceLogServiceImpl implements ExperienceLogService {
    @Autowired
    private ExperienceLogRepository experienceLogRepository;

    @Override
    public ExperienceLog createExperienceLog(Experience experience, Integer points) {
        return createExperienceLog(experience, points, null);
    }

    @Override
    public ExperienceLog createExperienceLog(Experience experience, Integer points, String remarks) {
        if(null == points){
            throw new IllegalArgumentException("Points cannot be null");
        }
        ExperienceLog experienceLog = new ExperienceLog();
        experienceLog.setExperience(experience);
        experienceLog.setAmount(points);
        experienceLog.setRemarks(remarks);
        experienceLog.setPlayerId(experience.getPlayerId());

        if(points>=0){
            experienceLog.setType(ExperienceType.EARN);
        }
        else {
            experienceLog.setType(ExperienceType.PENALTY);
        }

        return experienceLogRepository.save(experienceLog);

    }
}
