package com.swp391.lostandfound.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private int status;
    private String studentCode;
    private String email;
    private String phoneNumber;
    private int role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonIgnore
    private Collection<UserActivity> userActivities;

    @OneToMany(mappedBy = "userCreate", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonIgnore
    private Collection<Post> createUser;

    @OneToMany(mappedBy = "userReturn", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonIgnore
    private Collection<Post> returnUser;
}
