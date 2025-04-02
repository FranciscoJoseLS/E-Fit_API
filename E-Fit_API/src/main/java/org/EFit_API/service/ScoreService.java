package org.EFit_API.service;

import org.EFit_API.entity.Score;
import org.EFit_API.entity.User;
import org.EFit_API.entity.Routine;
import org.EFit_API.entity.Exercise;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScoreService {
    List<Score> findAll();
    Score save(Score score);
    void delete(Score score);
    Optional<Score> findById(UUID scoreId);
    List<Score> findByRoutine(Routine routine);
    List<Score> findByUser(User user);
    List<Score> findByExercise(Exercise exercise);
    List<Score> findByUserAndRoutine(User user, Routine routine);
    boolean existsByRoutineAndExercise(Routine routine, Exercise exercise);

        //Encuentra Scores por Exercise y Routine
    List<Score> findByExerciseAndRoutine(Exercise exercise, Routine routine);
        //Encuentra Scores por Routine, User y fecha entre un rango de fechas
    List<Score> findByRoutineAndUserAndRealizationDateBetween(Routine routine, User user, LocalDate startDate, LocalDate endDate);
}