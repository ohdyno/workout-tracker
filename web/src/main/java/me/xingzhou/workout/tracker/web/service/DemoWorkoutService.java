package me.xingzhou.workout.tracker.web.service;

import me.xingzhou.workout.tracker.tooling.IdGenerator;
import me.xingzhou.workout.tracker.workout.CreateWorkout;
import me.xingzhou.workout.tracker.workout.WorkoutId;
import org.springframework.stereotype.Service;

/**
 * A simplified service for workout operations. This is used for demonstration purposes instead of the actual
 * WorkoutCommandService to avoid dealing with the EventStore implementation.
 */
@Service
public class DemoWorkoutService {

    private final IdGenerator idGenerator;

    public DemoWorkoutService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    /** Handles the CreateWorkout command and returns a WorkoutId. */
    public WorkoutId handleCreateWorkout(CreateWorkout createWorkout) {
        String workoutIdValue = idGenerator.generateForWorkout(createWorkout.workoutName(), createWorkout.athleteId());

        // Log the operation for demonstration
        System.out.println("Created workout: " + workoutIdValue);

        return new WorkoutId(workoutIdValue);
    }
}
