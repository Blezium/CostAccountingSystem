package com.cas.costaccountingsystem.entities;

import com.cas.costaccountingsystem.ProjectType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime initializedAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @ManyToMany
    private List<Account> accounts;

    @OneToMany
    private List<Cost> costs;

    public Project(Long id, LocalDateTime initializedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.initializedAt = initializedAt;
        this.updatedAt = updatedAt;
    }

    public Project() {
    }
}
