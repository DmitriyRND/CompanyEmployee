package org.example.companyemployee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "не может быть пустым")
    private String firstName;
    @NotBlank(message = "не может быть пустым")
    private String lastName;
    @NotBlank(message = "не может быть пустым")
    private String position;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;
}
