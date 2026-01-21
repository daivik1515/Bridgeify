package com.jobPortal.Bridgeify.repository;

import com.jobPortal.Bridgeify.entity.JobPostActivity;
import com.jobPortal.Bridgeify.entity.JobSeekerProfile;
import com.jobPortal.Bridgeify.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave,Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);
    public List<JobSeekerSave> findByJob(JobPostActivity job);
}
