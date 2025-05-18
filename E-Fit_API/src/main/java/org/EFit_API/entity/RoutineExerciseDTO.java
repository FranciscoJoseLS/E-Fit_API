package org.EFit_API.entity;

import java.util.List;
import java.util.UUID;

public class RoutineExerciseDTO {
    private UUID exerciseRoutineId;
    private Integer nSets;
    private List<String> setTypes;
    private Long rest;
    private int superSerie;
    private String exerciseType;
    private int ordered;
    private Long exerciseId;
    private String name;
    private String description;
    private String muscularGroup;
    // Añade aquí otros campos de Exercise que necesites

    // Constructores (con y sin argumentos)
    public RoutineExerciseDTO() {
    }

    public RoutineExerciseDTO(UUID exerciseRoutineId, Integer nSets, List<String> setTypes, Long rest, int superSerie, String exerciseType, int ordered, Long exerciseId, String name, String description, String muscularGroup) {
        this.exerciseRoutineId = exerciseRoutineId;
        this.nSets = nSets;
        this.setTypes = setTypes;
        this.rest = rest;
        this.superSerie = superSerie;
        this.exerciseType = exerciseType;
        this.ordered = ordered;
        this.exerciseId = exerciseId;
        this.name = name;
        this.description = description;
        this.muscularGroup = muscularGroup;
    }

    // Getters y setters para todos los campos
    public UUID getExerciseRoutineId() {
        return exerciseRoutineId;
    }

    public void setExerciseRoutineId(UUID exerciseRoutineId) {
        this.exerciseRoutineId = exerciseRoutineId;
    }

    public Integer getnSets() {
        return nSets;
    }

    public void setnSets(Integer nSets) {
        this.nSets = nSets;
    }

    public List<String> getSetTypes() {
        return setTypes;
    }

    public void setSetTypes(List<String> setTypes) {
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

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMuscularGroup() {
        return muscularGroup;
    }

    public void setMuscularGroup(String muscularGroup) {
        this.muscularGroup = muscularGroup;
    }
}