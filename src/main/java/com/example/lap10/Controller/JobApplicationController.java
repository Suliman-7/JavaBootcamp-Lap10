package com.example.lap10.Controller;


import com.example.lap10.Api.ApiResponse;
import com.example.lap10.Model.JobApplication;
import com.example.lap10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobapplication")

public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAllJobApplication(){
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplication());
    }

    @PostMapping("/post")
    public ResponseEntity applyForJob(@Valid @RequestBody JobApplication jobApplication , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobApplicationService.applyForJob(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("job application added successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer id){
        boolean isDeleted = jobApplicationService.withdrawJobApplication(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("job application deleted successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("job application not found"));
    }


}
