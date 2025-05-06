package org.EFit_API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "exercises_routines")
public class ExerciseRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_routine_id")
    private UUID exerciseRoutineId;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    @JsonBackReference("exercise-routines")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id", nullable = false)
    @JsonBackReference("routine-exercises")
    private Routine routine;

    @Column(nullable = false, name = "n_sets")
    private Integer nSets;

    @ElementCollection
    @CollectionTable(name = "exercise_routine_sets", joinColumns = @JoinColumn(name = "exercise_routine_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "set_type")
    private List<SetType> setTypes;

    @Column(nullable = false)
    private Long rest;

    @Column(name = "super_serie")
    private int superSerie;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExerciseType exerciseType;

    @Column(nullable = false)
    private int ordered;

    public ExerciseRoutine() {}
    public ExerciseRoutine(Exercise exercise, Routine routine, Integer nSets, List<SetType> setTypes, Long rest, int superSerie, ExerciseType exerciseType, int ordered) {
        this.exercise = exercise;
        this.routine = routine;
        this.nSets = nSets;
        this.setTypes = setTypes;
        this.rest = rest;
        this.superSerie = superSerie;
        this.exerciseType = exerciseType;
        this.ordered = ordered;
    }
    public ExerciseRoutine(Exercise exercise, Routine routine, Integer nSets, Long rest, int superSerie, ExerciseType exerciseType, int ordered, List<SetType> setTypes) {
        this.exercise = exercise;
        this.routine = routine;
        this.nSets = nSets;
        this.rest = rest;
        this.superSerie = superSerie;
        this.exerciseType = exerciseType;
        this.ordered = ordered;
        this.setTypes = setTypes;
    }

    public UUID getExerciseRoutineId() {
        return exerciseRoutineId;
    }

    public void setExerciseRoutineId(UUID exerciseRoutineId) {
        this.exerciseRoutineId = exerciseRoutineId;
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

    public Integer getnSets() {
        return nSets;
    }

    public void setnSets(Integer nSets) {
        this.nSets = nSets;
    }

    public List<SetType> getSetTypes() {
        return setTypes;
    }

    public void setSetTypes(List<SetType> setTypes) {
        this.setTypes = setTypes;
    }

    public Long getRest() {
        return rest;
    }

    public void setRest(Long rest) {
        this.rest = rest;
    }

    public int getSuperSerie() {
        return superSerie;
    }

    public void setSuperSerie(int superSerie) {
        this.superSerie = superSerie;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    @Override
    public String toString() {
        return "ExerciseRoutine{" +
                "exerciseRoutineId=" + exerciseRoutineId +
                ", exercise=" + exercise +
                ", routine=" + routine +
                ", nSets=" + nSets +
                ", setTypes=" + setTypes +
                ", rest=" + rest +
                ", superSerie=" + superSerie +
                ", exerciseType=" + exerciseType +
                ", ordered=" + ordered +
                '}';
    }
}