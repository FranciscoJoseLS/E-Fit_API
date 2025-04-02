package org.EFit_API.controller;

import org.EFit_API.entity.Score;
import org.EFit_API.entity.User;
import org.EFit_API.entity.Routine;
import org.EFit_API.entity.Exercise;
import org.EFit_API.service.ScoreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreServiceImpl service;

    public ScoreController(ScoreServiceImpl service) {
        this.service = service;
    }

    /*
     * GET http://localhost:8080/score/all
     * Encuentra todos los Scores.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Score>> findAll() {
        List<Score> scores = service.findAll();
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }

    /*
     * GET http://localhost:8080/score/{id}
     * Encuentra un Score por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Score> findById(@PathVariable UUID id) {
        Optional<Score> score = service.findById(id);
        return score.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * POST http://localhost:8080/score
     * Crea un nuevo Score.
     */
    @PostMapping("/")
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        Score savedScore = service.save(score);
        if (savedScore == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(savedScore);
    }

    /*
     * DELETE http://localhost:8080/score/{id}
     * Elimina un Score por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable UUID id) {
        Optional<Score> score = service.findById(id);
        if (score.isPresent()) {
            service.delete(score.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * GET http://localhost:8080/score/routine/{routineId}
     * Encuentra los Scores asociados a una Routine específica.
     */
    @GetMapping("/routine/{routineId}")
    public ResponseEntity<List<Score>> findByRoutine(@PathVariable UUID routineId) {
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        List<Score> scores = service.findByRoutine(routine);
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }

    /*
     * GET http://localhost:8080/score/user/{userId}
     * Encuentra los Scores asociados a un User específico.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Score>> findByUser(@PathVariable UUID userId) {
        User user = new User();
        user.setUserId(userId);
        List<Score> scores = service.findByUser(user);
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }

    /*
     * GET http://localhost:8080/score/exercise/{exerciseId}
     * Encuentra los Scores asociados a un Exercise específico.
     */
    @GetMapping("/exercise/{exerciseId}")
    public ResponseEntity<List<Score>> findByExercise(@PathVariable Long exerciseId) {
        Exercise exercise = new Exercise();
        exercise.setExerciseId(exerciseId);
        List<Score> scores = service.findByExercise(exercise);
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }

    /*
     * GET http://localhost:8080/score/user/{userId}/routine/{routineId}
     * Encuentra los Scores asociados a un User y una Routine específica.
     */
    @GetMapping("/user/{userId}/routine/{routineId}")
    public ResponseEntity<List<Score>> findByUserAndRoutine(@PathVariable UUID userId, @PathVariable UUID routineId) {
        User user = new User();
        user.setUserId(userId);
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        List<Score> scores = service.findByUserAndRoutine(user, routine);
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }

    /*
     * GET http://localhost:8080/score/exists/routine/{routineId}/exercise/{exerciseId}
     * Verifica si existe un Score asociado a una Routine y un Exercise específicos.
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

    /*
     * GET http://localhost:8080/score/exercise/{exerciseId}/routine/{routineId}
     * Encuentra los Scores asociados a un Exercise y una Routine específica.
     */
    @GetMapping("/exercise/{exerciseId}/routine/{routineId}")
    public ResponseEntity<List<Score>> findByExerciseAndRoutine(@PathVariable Long exerciseId, @PathVariable UUID routineId) {
        Exercise exercise = new Exercise();
        exercise.setExerciseId(exerciseId);
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        List<Score> scores = service.findByExerciseAndRoutine(exercise, routine);
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }

    /*
     * GET http://localhost:8080/score/routine/{routineId}/user/{userId}/realizationDateBetween/{startDate}/{endDate}
     * Encuentra los Scores asociados a una Routine y un User entre un rango de fechas.
     */
    @GetMapping("/routine/{routineId}/user/{userId}/realizationDateBetween/{startDate}/{endDate}")
    public ResponseEntity<List<Score>> findByRoutineAndUserAndRealizationDateBetween(
            @PathVariable UUID routineId,
            @PathVariable UUID userId,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        User user = new User();
        user.setUserId(userId);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Score> scores = service.findByRoutineAndUserAndRealizationDateBetween(routine, user, start, end);
        if (scores.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(scores);
    }
}
