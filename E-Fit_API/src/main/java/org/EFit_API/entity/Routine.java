package org.EFit_API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "routines")
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "routine_id")
    private UUID routineId;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(length = 6, name = "estimated_duration")
    private String estimatedDuration;

    @Column(name = "default_days")
    private Integer defaultDays;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference("routine-exercises")
    private List<ExerciseRoutine> exerciseRoutines = new ArrayList<>();

    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference("routine-scores")
    private Set<Score> scores = new HashSet<>();

    public Routine() {}
    public Routine(String name, String estimatedDuration, Integer defaultDays, String description, Boolean active) {
        this.name = name;
        this.estimatedDuration = estimatedDuration;
        this.defaultDays = defaultDays;
        this.description = description;
        this.active = active;
    }
    public Routine(String name, String estimatedDuration, Integer defaultDays, String description, Boolean active, User user) {
        this.name = name;
        this.estimatedDuration = estimatedDuration;
        this.defaultDays = defaultDays;
        this.description = description;
        this.active = active;
        this.user = user;
    }

    public UUID getRoutineId() {
        return routineId;
    }

    public void setRoutineId(UUID routineId) {
        this.routineId = routineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(String estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Integer getDefaultDays() {
        return defaultDays;
    }

    public void setDefaultDays(Integer defaultDays) {
        this.defaultDays = defaultDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ExerciseRoutine> getExerciseRoutines() {
        return exerciseRoutines;
    }

    public void setExerciseRoutines(List<ExerciseRoutine> exerciseRoutines) {
        this.exerciseRoutines = exerciseRoutines;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "routineId='" + routineId + '\'' +
                ", name='" + name + '\'' +
                ", estimatedDuration='" + estimatedDuration + '\'' +
                ", defaultDays=" + defaultDays +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}