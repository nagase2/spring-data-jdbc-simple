package hello.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    public Long id;
    public String firstName;
    public LocalDate dob;
}