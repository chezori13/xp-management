package com.platform.cloud.xpmanagement.repository;

import com.platform.cloud.xpmanagement.model.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Integer> {
    Experience findByPlayerId(Integer playerId);
}
