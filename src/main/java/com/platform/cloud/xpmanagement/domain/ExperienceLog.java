package com.platform.cloud.xpmanagement.domain;


import com.platform.cloud.xpmanagement.common.constant.Type;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "experience_log")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid2")
public class ExperienceLog {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "experience_log_id", nullable = false)
    private String experienceLogId;

    @Column(name = "experience_id", nullable = false)
    private Integer experienceId;

    @Column(name = "player_id", nullable = false)
    private Integer playerId;

    @Column(name = "amount")
    private int points;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_at_timestamp")
    private Date createdAtTimestamp;

    public String getExperienceLogId() {
        return experienceLogId;
    }

    public void setExperienceLogId(String experienceLogId) {
        this.experienceLogId = experienceLogId;
    }

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public void setCreatedAtTimestamp(Date createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
    }
}
