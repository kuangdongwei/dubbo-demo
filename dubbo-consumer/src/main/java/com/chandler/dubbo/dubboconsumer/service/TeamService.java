package com.chandler.dubbo.dubboconsumer.service;

        import com.alibaba.dubbo.config.annotation.Reference;
        import com.chandler.dubbo.entity.Team;
        import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Reference(proxy = "TeamServer",version = "1.0.0")
    com.chandler.dubbo.service.TeamService teamService;

    public Team getTeam(String cityName){
        return teamService.getTeamInfo(cityName);
    }
}
