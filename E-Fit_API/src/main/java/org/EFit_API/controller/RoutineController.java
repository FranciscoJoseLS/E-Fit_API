package org.EFit_API.controller;

import org.EFit_API.entity.Routine;
import org.EFit_API.entity.User;
import org.EFit_API.service.RoutineService;
import org.EFit_API.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private final RoutineService routineService;
    private final UserService userService;

    public RoutineController(RoutineService routineService, UserService userService) {
        this.routineService = routineService;
        this.userService = userService;
    }

    /*
     * GET http://localhost:8080/routine/user/{userId}
     * Obtiene todas las rutinas de un usuario específico
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Routine>> findAllByUser(@PathVariable UUID userId) {
        User user = new User(); // Aquí debería buscarse el usuario por su ID
        user.setUserId(userId); // Este paso es solo un ejemplo de cómo establecer el usuario.

        List<Routine> routines = routineService.findAllByUser(user);
        if (routines.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(routines);
    }

    /*
     * GET http://localhost:8080/routine/{routineId}/user/{userId}
     * Obtiene una rutina específica de un usuario
     */
    @GetMapping("/{routineId}/user/{userId}")
    public ResponseEntity<Routine> findByUserAndRoutineId(@PathVariable UUID routineId, @PathVariable UUID userId) {
        Optional<User> user = userService.findById(userId);

        if(user.isPresent()) {
            Optional<Routine> routine = routineService.findByUserAndRoutineId(user.get(), routineId);
            return routine.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * POST http://localhost:8080/routine/user/{userId}
     * Crea una nueva rutina para un usuario
     */
    @PostMapping("/user/{userId}")
    public ResponseEntity<Routine> createRoutine(@PathVariable UUID userId, @RequestBody Routine routine) {
        User user = new User();
        user.setUserId(userId);
        routine.setUser(user);

        Routine savedRoutine = routineService.save(routine);
        return ResponseEntity.status(201).body(savedRoutine);
    }

    /*
     * PUT http://localhost:8080/routine/{routineId}/user/{userId}
     * Actualiza una rutina específica de un usuario
     */
    @PutMapping("/{routineId}/user/{userId}")
    public ResponseEntity<Routine> updateRoutine(@PathVariable UUID routineId, @PathVariable UUID userId, @RequestBody Routine updatedRoutineDetails) {
        Optional<User> userOptional = userService.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Routine> existingRoutineOptional = routineService.findByUserAndRoutineId(user, routineId);

            if (existingRoutineOptional.isPresent()) {
                Routine existingRoutine = existingRoutineOptional.get();

                // Ignorar las relacion con Exercises
                updatedRoutineDetails.setExerciseRoutines(existingRoutine.getExerciseRoutines());

                // Actualizar los campos permitidos de la rutina existente con los valores del DTO
                existingRoutine.setName(updatedRoutineDetails.getName());
                existingRoutine.setDescription(updatedRoutineDetails.getDescription());
                existingRoutine.setEstimatedDuration(updatedRoutineDetails.getEstimatedDuration());
                existingRoutine.setDefaultDays(updatedRoutineDetails.getDefaultDays());
                existingRoutine.setActive(updatedRoutineDetails.getActive());

                existingRoutine.setUser(user);

                Routine updatedRoutine = routineService.save(existingRoutine);
                return ResponseEntity.ok(updatedRoutine);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build(); // No se encontró el usuario
        }
    }

    /*
     * DELETE http://localhost:8080/routine/{routineId}/user/{userId}
     * Elimina una rutina específica de un usuario
     */
    @DeleteMapping("/{routineId}/user/{userId}")
    public ResponseEntity<Void> deleteRoutine(@PathVariable UUID routineId, @PathVariable UUID userId) {
        User user = new User();
        user.setUserId(userId);

        routineService.delete(user, routineId);
        return ResponseEntity.noContent().build();
    }

    /*
     * GET http://localhost:8080/routine/user/{userId}/name/{name}
     * Busca rutinas de un usuario por nombre
     */
    @GetMapping("/user/{userId}/name/{name}")
    public ResponseEntity<List<Routine>> findByUserAndName(@PathVariable UUID userId, @PathVariable String name) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            List<Routine> routines = routineService.findByUserAndNameContaining(user.get(), name);
            if (routines.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(routines);
        }
        return ResponseEntity.notFound().build();
    }

    /*
     * GET http://localhost:8080/routine/user/{userId}/active/{active}
     * Busca rutinas de un usuario filtradas por estado (activo o no)
     */
    @GetMapping("/user/{userId}/active/{active}")
    public ResponseEntity<List<Routine>> findByUserAndActive(@PathVariable UUID userId, @PathVariable Boolean active) {
        User user = new User();
        user.setUserId(userId);

        List<Routine> routines = routineService.findByUserAndActive(user, active);
        if (routines.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(routines);
    }

    /*
     * GET http://localhost:8080/routine/user/{userId}/range/{startDays}/{endDays}
     * Busca rutinas de un usuario filtradas por rango de días
     */
    @GetMapping("/user/{userId}/range/{startDays}/{endDays}")
    public ResponseEntity<List<Routine>> findByUserAndDefaultDaysBetween(@PathVariable UUID userId, @PathVariable Integer startDays, @PathVariable Integer endDays) {
        User user = new User();
        user.setUserId(userId);

        List<Routine> routines = routineService.findByUserAndDefaultDaysBetween(user, startDays, endDays);
        if (routines.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(routines);
    }
}
