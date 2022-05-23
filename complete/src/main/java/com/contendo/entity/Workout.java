package com.contendo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Workouts")
public class Workout extends BaseEntity{

    @Column(name = "Title")
    @NotNull
    private String title;

    @Column(name = "Image")
    @NotNull
    private String image;

    @Column(name = "Url")
    @NotNull
    private String url;

}
