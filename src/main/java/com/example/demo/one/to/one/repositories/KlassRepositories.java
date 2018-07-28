package com.example.demo.one.to.one.repositories;

import com.example.demo.one.to.one.entities.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlassRepositories extends JpaRepository<Klass,Long> {
}
