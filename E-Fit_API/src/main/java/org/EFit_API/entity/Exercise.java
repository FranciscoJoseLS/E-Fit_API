package org.EFit_API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(length = 75, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MuscularGroup muscularGroup;

    @Column(length = 150, nullable = false)
    private String description;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference("exercise-routines")
    private Set<ExerciseRoutine> exerciseRoutines = new HashSet<>();

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference("exercise-scores")
    private Set<Score> scores = new HashSet<>();

    public Exercise() {}
    public Exercise(String name, MuscularGroup muscularGroup, String description) {
        this.name = name;
        this.muscularGroup = muscularGroup;
        this.description = description;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MuscularGroup getMuscularGroup() {
        return muscularGroup;
    }

    public void setMuscularGroup(MuscularGroup muscularGroup) {
        this.muscularGroup = muscularGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ExerciseRoutine> getExerciseRoutines() {
        return exerciseRoutines;
    }

    public void setExerciseRoutines(Set<ExerciseRoutine> exerciseRoutines) {
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
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", name='" + name + '\'' +
                ", muscularGroup=" + muscularGroup +
                ", description='" + description + '\'' +
                '}';
    }
}