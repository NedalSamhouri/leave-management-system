package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;
    private String status; // e.g., "PENDING"
    private LocalDate startDate;
    private LocalDate endDate;

    // Connects this request to a single specific employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // 1. Default constructor (Required by Hibernate)
    public LeaveRequest() {}

    // 2. Constructor for convenience
    public LeaveRequest(String reason, String status, LocalDate startDate, LocalDate endDate, Employee employee) {
        this.reason = reason;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    // 3. Getters and Setters (Required for Hibernate to access data)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}