package me.xingzhou.workout.tracker.web.controller;

import me.xingzhou.workout.tracker.web.service.DemoWorkoutService;
import me.xingzhou.workout.tracker.workout.CreateWorkout;
import me.xingzhou.workout.tracker.workout.WorkoutId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** REST controller for workout operations. */
@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final DemoWorkoutService workoutService;

    public WorkoutController(DemoWorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<WorkoutResponse> createWorkout(@RequestBody CreateWorkoutRequest request) {
        // For demonstration, we're using a fixed athlete ID
        String athleteId = "demo-athlete-1";

        // Create the command using the request data
        CreateWorkout command = new CreateWorkout(athleteId, request.name());

        // Handle the command using our demo service
        WorkoutId workoutId = workoutService.handleCreateWorkout(command);

        // Return the response with the workout ID and name
        return ResponseEntity.ok(new WorkoutResponse(workoutId.id(), request.name()));
    }

    /** Request object for creating a workout. */
    record CreateWorkoutRequest(String name) {}

    /** Response object for workout operations. */
    record WorkoutResponse(String id, String name) {}
}
