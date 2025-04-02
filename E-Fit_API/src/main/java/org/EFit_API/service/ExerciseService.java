package org.EFit_API.service;

import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.MuscularGroup;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    List<Exercise> findAll();
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);

    Optional<Exercise> findById(Long id);
    List<Exercise> findByNameContaining(String name);
    List<Exercise> findByMuscularGroup(MuscularGroup muscularGroup);
    List<Exercise> findByMuscularGroupAndNameContaining(MuscularGroup muscularGroup, String name);
}
