package com.chandler.dubbo.dubboconsumer.controller;

import com.chandler.dubbo.dubboconsumer.service.TeamService;
import com.chandler.dubbo.entity.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Resource
    private TeamService teamService;
    @GetMapping("/getTeam")
    public Team getTeam(@RequestParam("cityName") String cityName){
        return teamService.getTeam(cityName);
    }
}
