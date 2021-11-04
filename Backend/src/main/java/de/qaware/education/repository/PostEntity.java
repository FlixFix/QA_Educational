package de.qaware.education.repository;

import javax.persistence.*;


@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @Column(name = "id")
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
