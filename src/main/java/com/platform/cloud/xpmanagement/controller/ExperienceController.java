package com.platform.cloud.xpmanagement.controller;

import com.platform.cloud.xpmanagement.model.Experience;
import com.platform.cloud.xpmanagement.view.ExperienceLog;
import com.platform.cloud.xpmanagement.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping(value="/{player_id}")
    @ResponseStatus(HttpStatus.OK)
    public Experience getExperienceByPlayerId(@PathVariable(name="player_id") Integer playerId){
        Experience experience = experienceService.getOrInitiateExperience(playerId);
        return experience;
    }

    @PostMapping(value="/{player_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExperiencePoints (@PathVariable(name="player_id") Integer playerId, @Valid @RequestBody ExperienceLog experienceLog){

        experienceService.addExperiencePoints(playerId, experienceLog.getPoints());
    }
}
