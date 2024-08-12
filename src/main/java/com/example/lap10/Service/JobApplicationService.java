package com.example.lap10.Service;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Model.JobPost;
import com.example.lap10.Model.User;
import com.example.lap10.Repository.JobApplicationRepository;
import com.example.lap10.Repository.JobPostRepository;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getAllJobApplication(){
        return jobApplicationRepository.findAll();
    }

    public String applyForJob(JobApplication jobApplication){
        User u = userRepository.getById(jobApplication.getUserId());
        JobPost ja = jobPostRepository.getById(jobApplication.getJopPostId());

        if(u == null){
            return "user not exist";
        }
        if(ja == null){
            return "job post not exist";
        }

        jobApplicationRepository.save(jobApplication);
        return "success";
    }

    public boolean withdrawJobApplication(int id){
        JobApplication ja = jobApplicationRepository.getById(id);
        if(ja==null){
            return false;
        }
        jobApplicationRepository.deleteById(id);
        return true;
    }


}
