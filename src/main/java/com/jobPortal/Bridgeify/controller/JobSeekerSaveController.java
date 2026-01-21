package com.jobPortal.Bridgeify.controller;

import com.jobPortal.Bridgeify.entity.JobPostActivity;
import com.jobPortal.Bridgeify.entity.JobSeekerProfile;
import com.jobPortal.Bridgeify.entity.JobSeekerSave;
import com.jobPortal.Bridgeify.entity.Users;
import com.jobPortal.Bridgeify.services.JobPostActivityService;
import com.jobPortal.Bridgeify.services.JobSeekerProfileService;
import com.jobPortal.Bridgeify.services.JobSeekerSaveService;
import com.jobPortal.Bridgeify.services.UsersService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class JobSeekerSaveController {

    private final UsersService usersService;
    private final JobSeekerProfileService jobSeekerProfileService;
    private final JobPostActivityService jobPostActivityService;
    private final JobSeekerSaveService jobSeekerSaveService;

    public JobSeekerSaveController(UsersService usersService, JobSeekerProfileService jobSeekerProfileService, JobPostActivityService jobPostActivityService, JobSeekerSaveService jobSeekerSaveService) {
        this.usersService = usersService;
        this.jobSeekerProfileService = jobSeekerProfileService;
        this.jobPostActivityService = jobPostActivityService;
        this.jobSeekerSaveService = jobSeekerSaveService;
    }
    @PostMapping("/job-details/save/{id}")
    public String save(@PathVariable int id) {

        JobSeekerSave jobSeekerSave = new JobSeekerSave();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Users user = usersService.findByEmail(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        JobSeekerProfile profile = jobSeekerProfileService
                .getOne(user.getUserId())
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        JobPostActivity job = jobPostActivityService.getOne(id);

        jobSeekerSave.setUserId(profile);
        jobSeekerSave.setJob(job);

        jobSeekerSaveService.addNew(jobSeekerSave);

        return "redirect:/dashboard/";
    }


    @GetMapping("saved-jobs/")
    public String savedJobs(Model model) {
        List<JobPostActivity> jobPost=new ArrayList<>();
        Object currentUser=usersService.getCurrentUserProfile();
        List<JobSeekerSave> jobSeekerSaveList = jobSeekerSaveService.getCandidatesJob((JobSeekerProfile) currentUser);
        for(JobSeekerSave jobSeekerSave:jobSeekerSaveList) {
            jobPost.add(jobSeekerSave.getJob());
        }
        model.addAttribute("jobPost",jobPost);
        model.addAttribute("user",currentUser);
        return "saved-jobs";
    }
}
