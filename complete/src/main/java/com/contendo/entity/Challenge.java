package com.contendo.entity;

import com.contendo.enums.ChallengeStatus;
import com.contendo.enums.ChallengeType;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Challenges")
@AllArgsConstructor
public class Challenge extends BaseEntity{

    @NotNull
    @ManyToOne
    @JoinColumn(name="UserId")
    private User user;

    /*@NotNull
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "Id")
    private UUID receiverId;

    @NotNull
    @ManyToOne(targetEntity = Workout.class)
    @JoinColumn(name = "Id")
    private UUID workoutId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "Id")
    private UUID winnerId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "Id")
    private UUID loserId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "Id")
    private UUID runnerId;*/

    @Column(name = "Duration")
    @NotNull
    private int duration;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Status")
    @NotNull
    private ChallengeStatus status;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Type")
    private ChallengeType type;

    @Column(name = "ChallengerProgress")
    @NotNull
    private String challengerProgress;

    @Column(name = "ReceiverProgress")
    @NotNull
    private String receiverProgress;

    @Column(name = "ChallengerStartTime")
    @NotNull
    private Date challengerStartTime;

    @Column(name = "ReceiverStartTime")
    @NotNull
    private Date receiverStartTime;

    @Column(name = "ChallengerEndTime")
    @NotNull
    private Date challengerEndTime;

    @Column(name = "ReceiverEndTime")
    @NotNull
    private Date receiverEndTime;

    public Challenge() {
    }
}
