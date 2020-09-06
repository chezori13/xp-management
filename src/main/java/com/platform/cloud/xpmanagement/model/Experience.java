package com.platform.cloud.xpmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Experience {

    public Experience(){
    }

    public Experience(Integer playerId){
        this.playerId= playerId;
    }

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer experienceId;

    @JsonIgnore
    @Column(nullable = false)
    private Integer playerId;

    @Column
    private Integer balance = 0;

    @JsonIgnore
    @OneToMany(mappedBy="experience", fetch=FetchType.EAGER)
    private Set<ExperienceLog> experienceLog = new HashSet<>();

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS'Z'")
    private OffsetDateTime createdAtTimestamp;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS'Z'")
    private OffsetDateTime updatedAtTimestamp;

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

    public Set<ExperienceLog> getExperienceLog() {
        return experienceLog;
    }

    public void setExperienceLog(Set<ExperienceLog> experienceLog) {
        this.experienceLog = experienceLog;
    }

    public void addExperienceLog(ExperienceLog experienceLog) {
        this.experienceLog.add(experienceLog);
    }

    public OffsetDateTime getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public OffsetDateTime getUpdatedAtTimestamp() {
        return updatedAtTimestamp;
    }

    public void setUpdatedAtTimestamp(OffsetDateTime updatedAtTimestamp) {
        this.updatedAtTimestamp = updatedAtTimestamp;
    }
}
