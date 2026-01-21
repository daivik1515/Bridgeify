package com.jobPortal.Bridgeify.services;

import com.jobPortal.Bridgeify.entity.JobPostActivity;
import com.jobPortal.Bridgeify.entity.JobSeekerApply;
import com.jobPortal.Bridgeify.entity.JobSeekerProfile;
import com.jobPortal.Bridgeify.repository.JobSeekerApplyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerApplyService {
    private final JobSeekerApplyRepository jobSeekerApplyRepository;

    public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
        this.jobSeekerApplyRepository = jobSeekerApplyRepository;
    }

    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId)
    {
        return jobSeekerApplyRepository.findByUserId(userAccountId);
    }
    public List<JobSeekerApply> getJobCandidates(JobPostActivity job)
    {
        return jobSeekerApplyRepository.findByJob(job);
    }


    public void addNew(JobSeekerApply jobSeekerApply) {
        jobSeekerApplyRepository.save(jobSeekerApply);
    }
}
