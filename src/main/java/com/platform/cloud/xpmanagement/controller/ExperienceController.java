package com.platform.cloud.xpmanagement.controller;

import com.platform.cloud.xpmanagement.domain.ExperienceLog;
import com.platform.cloud.xpmanagement.domain.vo.ExperienceVO;
import com.platform.cloud.xpmanagement.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/experience/{playerId}")
    public ResponseEntity<Object> getExperience(@PathVariable("playerId") Integer playerId) {
        ExperienceVO experienceVO = experienceService.getExperience(playerId);
        return ResponseEntity.ok(experienceVO);
    }

    @PostMapping("/experience/{playerId}")
    public ResponseEntity<Object> getExperience(@PathVariable("playerId") Integer playerId, @RequestBody ExperienceLog experienceLog) {
        experienceLog.setPlayerId(playerId);
        experienceService.addExperience(experienceLog);
        return ResponseEntity.ok("item created");
    }

}
