package com.cas.costaccountingsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema="public", name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private LocalDateTime initializedAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Project(Long id, LocalDateTime initializedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.initializedAt = initializedAt;
        this.updatedAt = updatedAt;
    }

    public Project() {
    }
}
