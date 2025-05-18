package org.EFit_API.service;

import org.EFit_API.entity.Routine;
import org.EFit_API.entity.User;
import org.EFit_API.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineServiceImpl(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    @Override
    public List<Routine> findAllByUser(User user) {
        return routineRepository.findByUser(user);
    }

    @Override
    public Routine save(Routine routine) {
        return routineRepository.save(routine);
    }

    @Override
    public void delete(User user, UUID routineId) {
        Optional<Routine> routine = routineRepository.findById(routineId);
        if (routine.isPresent() && routine.get().getUser().equals(user)) {
            routineRepository.delete(routine.get());
        }
    }

    @Override
    public Optional<Routine> findByUserAndRoutineId(User user, UUID routineId) {
        return routineRepository.findById(routineId).filter(routine -> routine.getUser().equals(user));
    }

    @Override
    public List<Routine> findByUserAndNameContaining(User user, String name) {
        return routineRepository.findByUserAndNameContainingIgnoreCase(user, name);
    }

    @Override
    public List<Routine> findByUserAndActive(User user, Boolean active) {
        return routineRepository.findByUserAndActive(user, active);
    }

    @Override
    public boolean existsByUserAndName(User user, String name) {
        return routineRepository.existsByUserAndName(user, name);
    }

    @Override
    public List<Routine> findByUserAndNameContainingIgnoreCaseAndActive(User user, String name, Boolean active) {
        return routineRepository.findByUserAndNameContainingIgnoreCaseAndActive(user, name, active);
    }

    @Override
    public List<Routine> findByUserAndDefaultDaysBetween(User user, Integer startDays, Integer endDays) {
        return routineRepository.findByUserAndDefaultDaysBetween(user, startDays, endDays);
    }

    @Override
    public Optional<Routine> findById(UUID id) {
        return routineRepository.findById(id);
    }

}
