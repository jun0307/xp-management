package com.platform.cloud.xpmanagement.domain.vo;

import java.util.Date;

public class ExperienceVO {
    private Integer balance;

    private Date created_at_timeStamp;

    private Date updated_at_timestamp;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getCreated_at_timeStamp() {
        return created_at_timeStamp;
    }

    public void setCreated_at_timeStamp(Date created_at_timeStamp) {
        this.created_at_timeStamp = created_at_timeStamp;
    }

    public Date getUpdated_at_timestamp() {
        return updated_at_timestamp;
    }

    public void setUpdated_at_timestamp(Date updated_at_timestamp) {
        this.updated_at_timestamp = updated_at_timestamp;
    }
}
