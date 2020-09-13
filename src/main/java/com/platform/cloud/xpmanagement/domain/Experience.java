package com.platform.cloud.xpmanagement.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id", nullable = false)
    private Integer experienceId;

    @Column(name = "player_id", nullable = false)
    private Integer playerId;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "created_at_timestamp")
    private Date createdAtTimeStamp;

    @Column(name = "updated_at_timestamp")
    private Date updatedAtTimestamp;

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getCreatedAtTimeStamp() {
        return createdAtTimeStamp;
    }

    public void setCreatedAtTimeStamp(Date createdAtTimeStamp) {
        this.createdAtTimeStamp = createdAtTimeStamp;
    }

    public Date getUpdatedAtTimestamp() {
        return updatedAtTimestamp;
    }

    public void setUpdatedAtTimestamp(Date updatedAtTimestamp) {
        this.updatedAtTimestamp = updatedAtTimestamp;
    }
}
