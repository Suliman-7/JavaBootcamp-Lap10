package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Size(min = 5 , message = "name length should be mote than 4 characters")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Email(message = "email should be formatted successfully")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotNull(message = "age can't be empty")
    @Positive
    @Min( value = 22 , message = "age should be more than 21 ")
    @Column(columnDefinition = "int not null ")
    @Check(constraints = "age>21")
    private int age;

    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$")
    @Column(columnDefinition = "varchar(20) not null ")
    @Check(constraints = "role==JOB_SEEKER or role=EMPLOYER")
    private String role;
}
