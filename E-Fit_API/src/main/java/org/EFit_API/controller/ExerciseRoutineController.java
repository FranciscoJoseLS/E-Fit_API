package org.EFit_API.controller;

import org.EFit_API.entity.*;
import org.EFit_API.service.ExerciseRoutineServiceImpl;
import org.EFit_API.service.ExerciseService;
import org.EFit_API.service.RoutineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/exerciseRoutine")
public class ExerciseRoutineController {

    private final ExerciseRoutineServiceImpl service;
    private final ExerciseService exerciseService;
    private final RoutineService routineService;

    public ExerciseRoutineController(ExerciseRoutineServiceImpl service, ExerciseService exerciseService, RoutineService routineService) {
        this.service = service;
        this.exerciseService = exerciseService;
        this.routineService = routineService;
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/all
     * Encuentra todas las ExerciseRoutines.
     */
    @GetMapping("/all")
    public ResponseEntity<List<ExerciseRoutine>> findAll() {
        List<ExerciseRoutine> exerciseRoutines = service.findAll();
        if (exerciseRoutines.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exerciseRoutines);
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/{id}
     * Encuentra una ExerciseRoutine por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseRoutine> findById(@PathVariable UUID id) {
        Optional<ExerciseRoutine> exerciseRoutine = service.findById(id);
        return exerciseRoutine.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST http://localhost:8080/exerciseRoutine
     * Crea una nueva ExerciseRoutine.
     */
    @PostMapping("/")
    public ResponseEntity<ExerciseRoutine> createExerciseRoutine(@RequestBody ExerciseRoutineDTO exerciseRoutineDTO) {
        ExerciseRoutine exerciseRoutine = convertToEntity(exerciseRoutineDTO);
        ExerciseRoutine savedExerciseRoutine = service.save(exerciseRoutine);
        if (savedExerciseRoutine == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(savedExerciseRoutine);
    }

    private ExerciseRoutine convertToEntity(ExerciseRoutineDTO exerciseRoutineDTO) {
        Exercise exercise = exerciseService.findById(exerciseRoutineDTO.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        Routine routine = routineService.findById(exerciseRoutineDTO.getRoutineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        ExerciseRoutine exerciseRoutine = new ExerciseRoutine();
        exerciseRoutine.setExercise(exercise);
        exerciseRoutine.setRoutine(routine);
        exerciseRoutine.setnSets(exerciseRoutineDTO.getnSets());
        exerciseRoutine.setSetTypes(exerciseRoutineDTO.getSetTypes());
        exerciseRoutine.setRest(exerciseRoutineDTO.getRest());
        exerciseRoutine.setSuperSerie(exerciseRoutineDTO.getSuperSerie());
        exerciseRoutine.setExerciseType(exerciseRoutineDTO.getExerciseType());
        exerciseRoutine.setOrdered(exerciseRoutineDTO.getOrdered());

        return exerciseRoutine;
    }

    /*
     * DELETE http://localhost:8080/exerciseRoutine/{id}
     * Elimina una ExerciseRoutine por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseRoutine(@PathVariable UUID id) {
        Optional<ExerciseRoutine> exerciseRoutine = service.findById(id);
        if (exerciseRoutine.isPresent()) {
            service.delete(exerciseRoutine.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/routine/{routineId}
     * Encuentra las ExerciseRoutines asociadas a una Routine específica.
     */
    @GetMapping("/routine/{routineId}")
    public ResponseEntity<List<ExerciseRoutine>> findByRoutine(@PathVariable UUID routineId) {
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        List<ExerciseRoutine> exerciseRoutines = service.findByRoutine(routine);
        return ResponseEntity.ok(exerciseRoutines);
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/exercise/{exerciseId}
     * Encuentra las ExerciseRoutines asociadas a un Exercise específico.
     */
    @GetMapping("/exercise/{exerciseId}")
    public ResponseEntity<List<ExerciseRoutine>> findByExercise(@PathVariable Long exerciseId) {
        Exercise exercise = new Exercise();
        exercise.setExerciseId(exerciseId);
        List<ExerciseRoutine> exerciseRoutines = service.findByExercise(exercise);
        if (exerciseRoutines.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exerciseRoutines);
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/user/{userId}
     * Encuentra las ExerciseRoutines asociadas a un User específico.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExerciseRoutine>> findByUser(@PathVariable UUID userId) {
        User user = new User();
        user.setUserId(userId);
        List<ExerciseRoutine> exerciseRoutines = service.findByRoutineUser(user);
        if (exerciseRoutines.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exerciseRoutines);
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/routine/{routineId}/exercise/{exerciseId}
     * Encuentra las ExerciseRoutines asociadas a una Routine y un Exercise específico.
     */
    @GetMapping("/routine/{routineId}/exercise/{exerciseId}")
    public ResponseEntity<List<ExerciseRoutine>> findByRoutineAndExercise(@PathVariable UUID routineId, @PathVariable Long exerciseId) {
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        Exercise exercise = new Exercise();
        exercise.setExerciseId(exerciseId);
        List<ExerciseRoutine> exerciseRoutines = service.findByRoutineAndExercise(routine, exercise);
        if (exerciseRoutines.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exerciseRoutines);
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/user/{userId}/active/{active}
     * Encuentra las ExerciseRoutines asociadas a un User y si la Routine está activa o no.
     */
    @GetMapping("/user/{userId}/active/{active}")
    public ResponseEntity<List<ExerciseRoutine>> findByUserAndActive(@PathVariable UUID userId, @PathVariable Boolean active) {
        User user = new User();
        user.setUserId(userId);
        List<ExerciseRoutine> exerciseRoutines = service.findByRoutineUserAndRoutineActive(user, active);
        if (exerciseRoutines.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(exerciseRoutines);
    }

    /*
     * GET http://localhost:8080/exerciseRoutine/exists/routine/{routineId}/exercise/{exerciseId}
     * Verifica si existe una ExerciseRoutine con la Routine y el Exercise específicos.
     */
    @GetMapping("/exists/routine/{routineId}/exercise/{exerciseId}")
    public ResponseEntity<Boolean> existsByRoutineAndExercise(@PathVariable UUID routineId, @PathVariable Long exerciseId) {
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        Exercise exercise = new Exercise();
        exercise.setExerciseId(exerciseId);
        boolean exists = service.existsByRoutineAndExercise(routine, exercise);
        return ResponseEntity.ok(exists);
    }
}
