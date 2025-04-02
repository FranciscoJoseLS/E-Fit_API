package org.EFit_API.service;

import org.EFit_API.entity.Routine;
import org.EFit_API.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineService {
    List<Routine> findAllByUser(User user);
    Routine save(Routine routine);
    void delete(User user, UUID routineId);
    Optional<Routine> findByUserAndRoutineId(User user, UUID routineId);
    List<Routine> findByUserAndNameContaining(User user, String name);
    List<Routine> findByUserAndActive(User user, Boolean active);
    boolean existsByUserAndName(User user, String name);
    List<Routine> findByUserAndNameContainingIgnoreCaseAndActive(User user, String name, Boolean active);
    List<Routine> findByUserAndDefaultDaysBetween(User user, Integer startDays, Integer endDays);
}