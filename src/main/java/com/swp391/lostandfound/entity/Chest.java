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
@Table(name = "Chest")
public class Chest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int status;
    private String location;

    @OneToMany(mappedBy = "chest", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonIgnore
    private Collection<ChestItem> chestItem;
}
