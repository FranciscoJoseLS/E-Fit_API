package org.EFit_API.service;

import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.MuscularGroup;
import org.EFit_API.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        if (!exerciseRepository.existsById(exercise.getExerciseId())) return;
        exerciseRepository.delete(exercise);
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public List<Exercise> findByNameContaining(String name) {
        return exerciseRepository.findExerciseByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Exercise> findByMuscularGroup(MuscularGroup muscularGroup) {
        return exerciseRepository.findByMuscularGroup(muscularGroup);
    }

    @Override
    public List<Exercise> findByMuscularGroupAndNameContaining(MuscularGroup muscularGroup, String name) {
        return exerciseRepository.findByMuscularGroupAndNameContaining(muscularGroup, name);
    }

    public List<Exercise> findByMuscularGroup(String muscularGroup) {
        try {
            MuscularGroup group = MuscularGroup.valueOf(muscularGroup.toUpperCase());
            return findByMuscularGroup(group);
        } catch (IllegalArgumentException e) {
            return List.of(); // Retorna lista vacía si el valor no es válido
        }
    }
}
