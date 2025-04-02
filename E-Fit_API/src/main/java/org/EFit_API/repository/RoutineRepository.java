package org.EFit_API.repository;

import org.EFit_API.entity.Routine;
import org.EFit_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, UUID> {
    List<Routine> findByUser(User user);
    List<Routine> findByUserAndNameContainingIgnoreCase(User user, String name);
    List<Routine> findByUserAndActive(User user, Boolean active);
    boolean existsByUserAndName(User user, String name);
    Optional<Routine> findByUserAndRoutineId(User user, UUID routineId);
    List<Routine> findByUserAndNameContainingIgnoreCaseAndActive(User user, String name, Boolean active);
    List<Routine> findByUserAndDefaultDaysBetween(User user, Integer startDays, Integer endDays);
}