package hello.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    Long id;
    String firstName;
    LocalDate dob;
}