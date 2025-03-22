package com.cas.costaccountingsystem.entities;

import com.cas.costaccountingsystem.AccountType;
import com.cas.costaccountingsystem.FullName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Embedded
    private FullName fullName;

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

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            schema = "public",
            name= "project_account",
            joinColumns = @JoinColumn(name= "project_id"),
            inverseJoinColumns = @JoinColumn(name= "account_id")
    )
    private List<Project> projects;
}
