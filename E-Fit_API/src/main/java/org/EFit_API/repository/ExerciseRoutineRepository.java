package org.EFit_API.repository;

import org.EFit_API.entity.ExerciseRoutine;
import org.EFit_API.entity.Routine;
import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExerciseRoutineRepository extends JpaRepository<ExerciseRoutine, UUID> {
    List<ExerciseRoutine> findByRoutine(Routine routine);
    List<ExerciseRoutine> findByExercise(Exercise exercise);
    List<ExerciseRoutine> findByRoutineUser(User user);
    List<ExerciseRoutine> findByRoutineAndExercise(Routine routine, Exercise exercise);
    List<ExerciseRoutine> findByRoutineUserAndRoutineActive(User user, Boolean active);
    boolean existsByRoutineAndExercise(Routine routine, Exercise exercise);
}
