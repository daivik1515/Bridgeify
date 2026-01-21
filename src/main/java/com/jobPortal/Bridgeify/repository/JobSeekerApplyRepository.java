package com.jobPortal.Bridgeify.repository;
import com.jobPortal.Bridgeify.entity.JobPostActivity;
import com.jobPortal.Bridgeify.entity.JobSeekerApply;
import com.jobPortal.Bridgeify.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply,Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);
    List<JobSeekerApply> findByJob(JobPostActivity job);
}
