package com.jobPortal.Bridgeify.entity;

public class RecruiterJobsDto {
    private Long totalCandidates;
    private Integer jobPostId;
    private String jobTitle;
    private JobLocation jobLocationId;
    private JobCompany jobCompanyId;

    public RecruiterJobsDto() {
    }

    public RecruiterJobsDto(Long totalCandidate, Integer jobPostId, String jobTitle, JobLocation jobLocationId, JobCompany jobCompanyId) {
        this.totalCandidates = totalCandidate;
        this.jobPostId = jobPostId;
        this.jobTitle = jobTitle;
        this.jobLocationId = jobLocationId;
        this.jobCompanyId = jobCompanyId;
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Long totalCandidate) {
        this.totalCandidates = totalCandidate;
    }

    public Integer getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(Integer jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobLocation getJobLocationId() {
        return jobLocationId;
    }

    public void setJobLocationId(JobLocation jobLocationId) {
        this.jobLocationId = jobLocationId;
    }

    public JobCompany getJobCompanyId() {
        return jobCompanyId;
    }

    public void setJobCompanyId(JobCompany jobCompanyId) {
        this.jobCompanyId = jobCompanyId;
    }

    @Override
    public String toString() {
        return "RecruiterJobsDto{" +
                "totalCandidate=" + totalCandidates +
                ", jobPostId=" + jobPostId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobLocationId=" + jobLocationId +
                ", jobCompanyId=" + jobCompanyId +
                '}';
    }
}
