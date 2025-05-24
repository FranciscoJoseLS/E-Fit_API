package org.EFit_API.service;

import org.EFit_API.entity.*;
import org.EFit_API.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository repository;

    public ScoreServiceImpl(ScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Score> findAll() {
        return repository.findAll();
    }

    @Override
    public Score save(Score score) {
        return repository.save(score);
    }

    @Override
    public void delete(Score score) {
        if (!repository.existsById(score.getScoreId())) return;
        repository.delete(score);
    }

    @Override
    public Optional<Score> findById(UUID scoreId) {
        return repository.findById(scoreId);
    }

    @Override
    public List<Score> findByRoutine(Routine routine) {
        return repository.findByRoutine(routine);
    }

    @Override
    public List<Score> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public List<Score> findByExercise(Exercise exercise) {
        return repository.findByExercise(exercise);
    }


    @Override
    public List<Score> findByUserAndRoutine(User user, Routine routine) {
        return repository.findByUserAndRoutine(user, routine);
    }

    @Override
    public boolean existsByRoutineAndExercise(Routine routine, Exercise exercise) {
        return this.repository.existsByRoutineAndExercise(routine, exercise);
    }

    @Override
    public List<Score> findByExerciseAndRoutine(Exercise exercise, Routine routine) {
        return this.repository.findByExerciseAndRoutine(exercise, routine);
    }

    @Override
    public List<Score> findByRoutineAndUserAndRealizationDateBetween(Routine routine, User user, LocalDate startDate, LocalDate endDate) {
        return repository.findByRoutineAndUserAndRealizationDateBetween(routine, user, startDate, endDate);
    }

}


