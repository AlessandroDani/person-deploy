package com.example.deploy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private Long identification;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
}
