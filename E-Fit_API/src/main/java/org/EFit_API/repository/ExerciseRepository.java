package org.EFit_API.repository;

import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.MuscularGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findExerciseByNameContainingIgnoreCase(String name);
    List<Exercise> findByMuscularGroup(MuscularGroup muscularGroup);
    List<Exercise> findByMuscularGroupAndNameContaining(MuscularGroup muscularGroup, String name);
}
