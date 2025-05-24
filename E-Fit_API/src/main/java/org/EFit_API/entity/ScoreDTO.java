package org.EFit_API.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ScoreDTO {

    private Long exerciseId;
    private String routineId;
    private String userId;
    private String comment;
    private String load;
    private String realizationDate;

    public ScoreDTO() {}
    public ScoreDTO(Long exerciseId, String routineId, String userId, String comment, String load, String realizationDate) {
        this.exerciseId = exerciseId;
        this.routineId = routineId;
        this.userId = userId;
        this.comment = comment;
        this.load = load;
        this.realizationDate = realizationDate;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public String getRoutineId() {
        return routineId;
    }

    public String getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public String getLoad() {
        return load;
    }

    public String getRealizationDate() {
        return realizationDate;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setRoutineId(String routineId) {
        this.routineId = routineId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public void setRealizationDate(String realizationDate) {
        this.realizationDate = realizationDate;
    }

    @Override
    public String toString() {
        return "ScoresDTO{" +
               "exerciseId=" + exerciseId +
               ", routineId='" + routineId + '\'' +
               ", userId='" + userId + '\'' +
               ", comment='" + comment + '\'' +
               ", load='" + load + '\'' +
               ", realizationDate='" + realizationDate + '\'' +
               '}';
    }
}