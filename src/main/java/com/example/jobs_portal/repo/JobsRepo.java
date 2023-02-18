package com.example.jobs_portal.repo;

import com.example.jobs_portal.entity.Application;
import com.example.jobs_portal.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface JobsRepo  extends JpaRepository<Jobs, Integer> {


//    @Query (value ="select * from jps_jobs limit 2 offset ?1", nativeQuery=true)
//    Optional<Jobs> findListedData(Integer offsetCount);


@Query(value = "SELECT * FROM jobs ORDER BY RANDOM() LIMIT 6", nativeQuery = true)
List<Jobs> findFourRandomData();

//    @Query(value = "SELECT * FROM jobs where id=?1", nativeQuery = true)
//    List<Jobs> fetchAllById(Integer id);
    @Query(value = "select * from jobs where job_title=?1", nativeQuery = true)
    Optional<Jobs> findByjob_title(String jobtitle);



}
