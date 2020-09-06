package com.platform.cloud.xpmanagement.model;

import com.platform.cloud.xpmanagement.model.basetype.ExperienceType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
public class ExperienceLog {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID experienceLogId;

    @ManyToOne
    @JoinColumn(name="experience_id", nullable=false)
    private Experience experience;

    @Column(nullable = false)
    private Integer playerId;

    @Column
    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Column
    private ExperienceType type;

    @Column
    private String remarks;

    @CreationTimestamp
    private OffsetDateTime createdAtTimestamp;

    public UUID getExperienceLogId() {
        return experienceLogId;
    }

    public void setExperienceLogId(UUID experienceLogId) {
        this.experienceLogId = experienceLogId;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ExperienceType getType() {
        return type;
    }

    public void setType(ExperienceType type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public OffsetDateTime getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

}
