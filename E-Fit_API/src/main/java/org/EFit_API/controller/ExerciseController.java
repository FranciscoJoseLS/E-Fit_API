package org.EFit_API.controller;

import org.EFit_API.entity.Exercise;
import org.EFit_API.entity.MuscularGroup;
import org.EFit_API.service.ExerciseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseServiceImpl service;

    public ExerciseController(ExerciseServiceImpl service) {
        this.service = service;
    }

    /*
     * GET http://localhost:8080/exercise/exercises
     */
    @GetMapping("/exercises")
    public ResponseEntity<List<Exercise>> findAll() {
        List<Exercise> exercises = service.findAll();
        if (exercises.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exercises);
    }

    /*
     * GET http://localhost:8080/exercise/exercises/{id}
     */
    @GetMapping("/exercises/{id}")
    public ResponseEntity<Exercise> findById(@PathVariable Long id) {
        Optional<Exercise> exercise = service.findById(id);
        return exercise.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST http://localhost:8080/exercise/exercises
     */
    @PostMapping("/exercises")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        Exercise savedExercise = service.save(exercise);
        if (savedExercise == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(savedExercise);
    }

    /*
     * DELETE http://localhost:8080/exercise/exercises/{id}
     */
    @DeleteMapping("/exercises/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        Optional<Exercise> exercise = service.findById(id);
        if (exercise.isPresent()) {
            service.delete(exercise.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * PUT http://localhost:8080/exercise/exercises/{id}
     */
    @PutMapping("/exercises/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        Optional<Exercise> existingExercise = service.findById(id);
        if (existingExercise.isPresent()) {
            exercise.setExerciseId(id);
            Exercise updatedExercise = service.save(exercise);
            return ResponseEntity.ok(updatedExercise);
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * GET http://localhost:8080/exercise/exercises/name/{name}
     */
    @GetMapping("/exercises/name/{name}")
    public ResponseEntity<List<Exercise>> findByName(@PathVariable String name) {
        List<Exercise> exercises = service.findByNameContaining(name);
        if (exercises.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exercises);
    }

    /*
     * GET http://localhost:8080/exercise/exercises/muscularGroup/{muscularGroup}
     */
    @GetMapping("/exercises/muscularGroup/{muscularGroup}")
    public ResponseEntity<List<Exercise>> findByMuscularGroup(@PathVariable String muscularGroup) {
        List<Exercise> exercises = service.findByMuscularGroup(muscularGroup);
        if (exercises.isEmpty())return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exercises);
    }

    /*
     * GET http://localhost:8080/exercise/exercises/muscularGroup/{muscularGroup}/name/{name}
     */
    @GetMapping("/exercises/muscularGroup/{muscularGroup}/name/{name}")
    public ResponseEntity<List<Exercise>> findByMuscularGroupAndName(@PathVariable String muscularGroup, @PathVariable String name) {
        List<Exercise> exercises = service.findByMuscularGroupAndNameContaining(MuscularGroup.valueOf(muscularGroup.toUpperCase()), name);
        if (exercises.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exercises);
    }
}
