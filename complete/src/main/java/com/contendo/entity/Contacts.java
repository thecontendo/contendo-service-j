package com.contendo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Contacts")
public class Contacts extends BaseEntity{

    @Column(name = "UserId")
    @NotNull
    private String userId;

    @Column(name = "ContactId")
    @NotNull
    private String contactId;

    @Column(name = "InvitationStatus")
    @NotNull
    private int invitationStatus;

    @Column(name = "ContactStatus")
    @NotNull
    private int contactStatus;

}
