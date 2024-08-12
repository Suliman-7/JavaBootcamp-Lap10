package com.example.lap10.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title can't be empty")
    @Size(min = 5 , message = "title length should be mote than 4 characters")
    @Column(columnDefinition = "varchar(20) not null ")
    private String title;

    @NotEmpty(message = "description can't be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String description;

    @NotEmpty(message = "location can't be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String location;

    @NotNull(message = "salary can't be empty")
    @Positive(message = "salary should be positive")
    @Column(columnDefinition = "int not null ")
    private int salary;

    @Column(columnDefinition = "datetime")
    private LocalDate postingDate ;
}
