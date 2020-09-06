package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.model.ExperienceLog;
import com.platform.cloud.xpmanagement.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExperienceLogService experienceLogService;

    @Override
    public Experience getOrInitiateExperience(Integer playerId) {
        if(null == playerId){
            throw new IllegalArgumentException("PlayerId cannot be null");
        }

        Experience experience = experienceRepository.findByPlayerId(playerId);
        if (null == experience){
            experience = createExperience(playerId);
        }

        return experience;
    }

    @Override
    public Experience createExperience(Integer playerId) {
        if(null == playerId){
            throw new IllegalArgumentException("PlayerId cannot be null");
        }
        Experience experience = new Experience(playerId);
        return experienceRepository.save(experience);

    }

    @Override
    public Experience addExperiencePoints(Integer playerId, Integer points) {
        Experience experience = getOrInitiateExperience(playerId);
        ExperienceLog experienceLog = experienceLogService.createExperienceLog(experience, points);
        if(null != experienceLog){
            experience.addExperienceLog(experienceLog);
            experience.setBalance(sumUpBalance(experience.getExperienceLog()));
        }

        return experienceRepository.save(experience);
    }

    private Integer sumUpBalance(Collection<ExperienceLog> experienceLog){
        return experienceLog.stream().mapToInt(x -> x.getAmount()).sum();
    }
}
