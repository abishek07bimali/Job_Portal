package com.example.jobs_portal.repo;

import com.example.jobs_portal.entity.Application;
import com.example.jobs_portal.entity.Jobs;
import com.example.jobs_portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer> {
    @Query(value = "SELECT * FROM application where Applied_User=?1", nativeQuery = true)
    List<Application> findApplicationById(Integer id);



    @Query(value = "SELECT * FROM application where address=?1", nativeQuery = true)
    Optional<Application> findByAddress(String address);

}
