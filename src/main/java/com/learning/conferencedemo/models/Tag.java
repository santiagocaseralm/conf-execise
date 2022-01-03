package com.learning.conferencedemo.models;

import lombok.Data;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "session_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private List<Session> sessionList;
}
