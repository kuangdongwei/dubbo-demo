package com.chandler.dubbo.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chandler.dubbo.entity.Team;
import com.chandler.dubbo.service.TeamService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Service(version = "1.0.0",proxy = "TeamServer")
public class MyserviceImpl implements TeamService {

    private static HashMap<String,Team> teamHashMap = new HashMap<>(16);
    static {
        Team team1 = new Team();
        team1.setCity("chicago");
        team1.setName("bulls");
        team1.setTopPlayer("jordan&rose");
        Team team2 = new Team();
        team2.setTopPlayer("james&kobe");
        team2.setName("lakers");
        team2.setCity("loss angles");
        teamHashMap.put("chicago",team1);
        teamHashMap.put("lal",team2);
    }
    @Override
    public Team getTeamInfo(String s) {
        return teamHashMap.get(s);
    }
}
