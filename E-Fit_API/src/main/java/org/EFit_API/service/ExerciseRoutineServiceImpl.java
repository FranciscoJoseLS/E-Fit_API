package org.EFit_API.service;

import org.EFit_API.entity.ExerciseRoutine;
import org.EFit_API.entity.Routine;
import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.User;
import org.EFit_API.repository.ExerciseRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseRoutineServiceImpl implements ExerciseRoutineService {

    private final ExerciseRoutineRepository repository;

    public ExerciseRoutineServiceImpl(ExerciseRoutineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ExerciseRoutine> findAll() {
        return repository.findAll();
    }

    @Override
    public ExerciseRoutine save(ExerciseRoutine exerciseRoutine) {
        return repository.save(exerciseRoutine);
    }

    @Override
    public void delete(ExerciseRoutine exerciseRoutine) {
        if (!repository.existsById(exerciseRoutine.getExerciseRoutineId())) return;
        repository.delete(exerciseRoutine);
    }

    @Override
    public Optional<ExerciseRoutine> findById(UUID exerciseRoutineId) {
        return repository.findById(exerciseRoutineId);
    }

    @Override
    public List<ExerciseRoutine> findByRoutine(Routine routine) {
        return repository.findByRoutine(routine);
    }

    @Override
    public List<ExerciseRoutine> findByExercise(Exercise exercise) {
        return repository.findByExercise(exercise);
    }

    @Override
    public List<ExerciseRoutine> findByRoutineUser(User user) {
        return repository.findByRoutineUser(user);
    }

    @Override
    public List<ExerciseRoutine> findByRoutineAndExercise(Routine routine, Exercise exercise) {
        return repository.findByRoutineAndExercise(routine, exercise);
    }

    @Override
    public List<ExerciseRoutine> findByRoutineUserAndRoutineActive(User user, Boolean active) {
        return repository.findByRoutineUserAndRoutineActive(user, active);
    }

    @Override
    public boolean existsByRoutineAndExercise(Routine routine, Exercise exercise) {
        return repository.existsByRoutineAndExercise(routine, exercise);
    }
}
