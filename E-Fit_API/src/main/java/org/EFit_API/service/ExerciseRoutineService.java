package org.EFit_API.service;

import org.EFit_API.entity.ExerciseRoutine;
import org.EFit_API.entity.Routine;
import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseRoutineService {
    List<ExerciseRoutine> findAll();
    ExerciseRoutine save(ExerciseRoutine exerciseRoutine);
    void delete(ExerciseRoutine exerciseRoutine);
    Optional<ExerciseRoutine> findById(UUID exerciseRoutineId);
    List<ExerciseRoutine> findByRoutine(Routine routine);
    List<ExerciseRoutine> findByExercise(Exercise exercise);
    List<ExerciseRoutine> findByRoutineUser(User user);
    List<ExerciseRoutine> findByRoutineAndExercise(Routine routine, Exercise exercise);
    List<ExerciseRoutine> findByRoutineUserAndRoutineActive(User user, Boolean active);
    boolean existsByRoutineAndExercise(Routine routine, Exercise exercise);
}