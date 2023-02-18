package com.example.jobs_portal.repo;

import com.example.jobs_portal.entity.Jobs;
import com.example.jobs_portal.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamsRepo  extends JpaRepository<Teams, Integer> {


    @Query(value = "select * from teams where department=?1", nativeQuery = true)
    Optional<Teams> findBydepartment(String department);
}
