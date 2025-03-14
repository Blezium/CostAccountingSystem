package com.cas.costaccountingsystem.entities;

import com.cas.costaccountingsystem.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String nickname;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    private LocalDateTime initializedAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToMany
    private List<Project> projects;

    public Account(Long id, String nickname, String firstName, String secondName, String password, String email, LocalDateTime initializedAt, LocalDateTime updatedAt, AccountType type) {
        this.id = id;
        this.nickname = nickname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.initializedAt = initializedAt;
        this.updatedAt = updatedAt;
        this.type = type;
    }

    public Account() {
    }
}
