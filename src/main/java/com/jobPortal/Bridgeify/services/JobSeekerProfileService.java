package com.jobPortal.Bridgeify.services;

import com.jobPortal.Bridgeify.entity.JobSeekerProfile;
import com.jobPortal.Bridgeify.entity.Users;
import com.jobPortal.Bridgeify.repository.JobSeekerProfileRepository;
import com.jobPortal.Bridgeify.repository.UsersRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerProfileService {
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final UsersRepository usersRepository;

    public JobSeekerProfileService(JobSeekerProfileRepository jobSeekerProfileRepository, UsersRepository usersRepository) {
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.usersRepository = usersRepository;
    }

    public Optional<JobSeekerProfile>  getOne(Integer id)
    {
        return jobSeekerProfileRepository.findById(id);
    }

    public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
        return jobSeekerProfileRepository.save(jobSeekerProfile);
    }

    public JobSeekerProfile getCurrentSeekerProfile() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(! (authentication instanceof AnonymousAuthenticationToken)) {
            String name = authentication.getName();
            Users users = usersRepository.findByEmail(name).orElseThrow(()->new UsernameNotFoundException("User Name not found"));
            Optional<JobSeekerProfile> jobSeekerProfile =  getOne(users.getUserId());
            return jobSeekerProfile.orElse(null);
        }
        return null;
    }
}
