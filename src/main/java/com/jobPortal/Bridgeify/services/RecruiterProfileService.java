package com.jobPortal.Bridgeify.services;

import com.jobPortal.Bridgeify.entity.RecruiterProfile;
import com.jobPortal.Bridgeify.entity.Users;
import com.jobPortal.Bridgeify.repository.RecruiterProfileRepository;
import com.jobPortal.Bridgeify.repository.UsersRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final UsersRepository usersRepository;

    public RecruiterProfileService(RecruiterProfileRepository recruiterProfileRepository, UsersRepository usersRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.usersRepository = usersRepository;
    }

    public Optional<RecruiterProfile> getOne(Integer id)
    {
        return  recruiterProfileRepository.findById(id);
    }

    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepository.save(recruiterProfile);
    }

    public RecruiterProfile getCurrentRecruiterProfile() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if(!(authentication instanceof AnonymousAuthenticationToken)) {
           String currentUsername=authentication.getName();
           Users user = usersRepository.findByEmail(currentUsername).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
           Optional<RecruiterProfile> recruiterProfile= getOne(user.getUserId());
           return recruiterProfile.orElse(null);
       } else {
           return null;
       }
    }
}
