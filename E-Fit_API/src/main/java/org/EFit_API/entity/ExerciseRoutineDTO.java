package org.EFit_API.entity;

import java.util.List;
import java.util.UUID;

public class ExerciseRoutineDTO {
    private Long exerciseId;  // ID del Exercise
    private UUID routineId;   // ID del Routine
    private Integer nSets;
    private List<SetType> setTypes;
    private Long rest;
    private int superSerie;
    private ExerciseType exerciseType;
    private int ordered;

    // Constructores
    public ExerciseRoutineDTO() {}

    public ExerciseRoutineDTO(Long exerciseId, UUID routineId, Integer nSets, List<SetType> setTypes, Long rest, int superSerie, ExerciseType exerciseType, int ordered) {
        this.exerciseId = exerciseId;
        this.routineId = routineId;
        this.nSets = nSets;
        this.setTypes = setTypes;
        this.rest = rest;
        this.superSerie = superSerie;
        this.exerciseType = exerciseType;
        this.ordered = ordered;
    }

    // Getters y Setters
    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public UUID getRoutineId() {
        return routineId;
    }

    public void setRoutineId(UUID routineId) {
        this.routineId = routineId;
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
        return "ExerciseRoutineDTO{" +
                "exerciseId=" + exerciseId +
                ", routineId=" + routineId +
                ", nSets=" + nSets +
                ", setTypes=" + setTypes +
                ", rest=" + rest +
                ", superSerie=" + superSerie +
                ", exerciseType=" + exerciseType +
                ", ordered=" + ordered +
                '}';
    }
}
