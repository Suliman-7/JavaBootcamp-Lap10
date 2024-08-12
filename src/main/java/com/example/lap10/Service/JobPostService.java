package com.example.lap10.Service;


import com.example.lap10.Model.JobPost;
import com.example.lap10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPost> getAllJopPost(){
        return jobPostRepository.findAll();
    }

    public void addJopPost(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }

    public boolean updateJopPost(int id , JobPost jobPost){
        JobPost findJobPost = jobPostRepository.getById(id);
        if(findJobPost == null){
            return false;
        }
        findJobPost.setPostingDate(jobPost.getPostingDate());
        findJobPost.setDescription(jobPost.getDescription());
        findJobPost.setTitle(jobPost.getTitle());
        findJobPost.setLocation(jobPost.getLocation());
        findJobPost.setSalary(jobPost.getSalary());
        jobPostRepository.save(jobPost);
        return true;
    }

    public boolean deleteJopPost(int id){
        JobPost findJobPost = jobPostRepository.getById(id);
        if(findJobPost.equals(null)){
            return false;
        }
        jobPostRepository.delete(findJobPost);
        return true;
    }
}
