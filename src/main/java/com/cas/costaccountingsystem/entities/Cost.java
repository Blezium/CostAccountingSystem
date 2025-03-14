package com.cas.costaccountingsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema="public", name="cost")
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false, updatable = false)
    private LocalDateTime initializedAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    private Project project;

    public Cost(Long id, Long price, LocalDateTime initializedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.price = price;
        this.initializedAt = initializedAt;
        this.updatedAt = updatedAt;
    }

    public Cost() {
    }
}
