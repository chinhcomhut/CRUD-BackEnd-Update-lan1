package com.security.demospringsecurity.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name="NAME", nullable = false)
    private String title;
@Column(name = "AGE", nullable = false)
  private String author;
@Column(name = "SALARY", nullable = false)
    private String description;

    public Employee() {
    }

    public Employee(@NotEmpty String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setTitle() {
    }

    public void setAuthor() {
    }

    public void setDescription() {
    }

    public void setId() {
    }
}
