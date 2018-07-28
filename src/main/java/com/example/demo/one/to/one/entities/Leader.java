package com.example.demo.one.to.one.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klass_id")
    @JsonIgnore
    private Klass klass;

    public Leader(Long id, String name, Klass klass) {
        this.id = id;
        this.name = name;
        this.klass = klass;
    }


    public Leader(Long id, ZonedDateTime createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String leaderName) {
        this.name = name;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
