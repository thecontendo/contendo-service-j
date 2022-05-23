package com.contendo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users")
public class User extends BaseEntity{

    @Column(name = "FirstName")
    @NotNull
    private String firstName;

    @Column(name = "LastName")
    @NotNull
    private String lastName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "Email")
    @NotNull
    private String email;

}
