package org.EFit_API.repository;

import org.EFit_API.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {
    List<Score> findByRoutine(Routine routine);
    List<Score> findByUser(User user);
    List<Score> findByExercise(Exercise exercise);
    List<Score> findByUserAndRoutine(User user, Routine routine);
    boolean existsByRoutineAndExercise(Routine routine, Exercise exercise);
    List<Score> findByExerciseAndRoutine(Exercise exercise, Routine routine);
    List<Score> findByRoutineAndUserAndRealizationDateBetween(Routine routine, User user, LocalDate startDate, LocalDate endDate);
}
