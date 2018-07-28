package com.example.demo.one.to.one.dto;



import com.example.demo.one.to.one.entities.Klass;

import java.time.ZonedDateTime;

public class KlassDTO {
    private final Long id;
    private final int classNum;
    private final ZonedDateTime createDate;
    private final LeaderDTO leaderDTO;

    public Long getId() {
        return id;
    }

    public int getName() {
        return classNum;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public LeaderDTO getLeaderDTO() {
        return leaderDTO;
    }

    public KlassDTO(Klass klass) {
        this.id = klass.getId();
        this.classNum = klass.getNum();
        this.createDate = klass.getCreatedDate();
        this.leaderDTO = new LeaderDTO(klass.getLeader());
    }
}
