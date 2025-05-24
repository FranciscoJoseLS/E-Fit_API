package org.EFit_API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime; 
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "score_id")
    private UUID scoreId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-scores")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    @JsonBackReference("exercise-scores")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id", nullable = false)
    @JsonBackReference("routine-scores")
    private Routine routine;

    @Column(name = "realization_date", nullable = false)
    private LocalDate realizationDate;

    @Column(length = 100)
    private String comments;

    @Column(length = 100, name = "load_value")
    private String loadValue;

    public Score() {}
    public Score(User user, Exercise exercise, Routine routine, LocalDate realizationDate, String comments, String load) {
        this.user = user;
        this.exercise = exercise;
        this.routine = routine;
        this.realizationDate = realizationDate;
        this.comments = comments;
        this.loadValue = load;
    }

    public UUID getScoreId() {
        return scoreId;
    }

    public void setScoreId(UUID scoreId) {
        this.scoreId = scoreId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public LocalDate getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(LocalDate realizationDate) {
        this.realizationDate = realizationDate;
    }

    public void setRealizationDate() {
        this.realizationDate = LocalDate.now();
    }

    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLoadValue() {
        return loadValue;
    }

    public void setLoadValue(String loadValue) {
        this.loadValue = loadValue;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", user=" + user +
                ", exercise=" + exercise +
                ", routine=" + routine +
                ", realizationDate=" + realizationDate +
                ", comments='" + comments + '\'' +
                ", loadValue='" + loadValue + '\'' +
                '}';
    }
}
