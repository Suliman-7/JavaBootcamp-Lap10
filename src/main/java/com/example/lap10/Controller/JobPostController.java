package com.example.lap10.Controller;


import com.example.lap10.Api.ApiResponse;
import com.example.lap10.Model.JobPost;
import com.example.lap10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobpost")

public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getAllJobPost(){
        return ResponseEntity.status(200).body(jobPostService.getAllJopPost());
    }

    @PostMapping("/post")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJopPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("job post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable int id , @Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jobPostService.updateJopPost(id, jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("job post updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("job post update failed"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable int id){
        boolean isDeleted = jobPostService.deleteJopPost(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("job post deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("job post delete failed"));
    }



}
