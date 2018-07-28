package com.example.demo.one.to.one.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "klass",fetch = FetchType.LAZY)
    private Leader leader;

    private int num;

    public Leader getLeader() {
        return leader;
    }

    public Klass(){}

    public Klass(Long id, int num,Leader leader) {
        this.id = id;
        this.num = num;
        this.leader = leader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
