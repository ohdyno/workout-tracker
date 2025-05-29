package me.xingzhou.workout.tracker.web.controller;

import me.xingzhou.workout.tracker.web.model.WorkoutCreatedModel;
import me.xingzhou.workout.tracker.web.model.WorkoutFormModel;
import me.xingzhou.workout.tracker.web.service.DemoWorkoutService;
import me.xingzhou.workout.tracker.workout.CreateWorkout;
import me.xingzhou.workout.tracker.workout.WorkoutId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/** Controller for workout operations that returns HTML views. */
@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    private final DemoWorkoutService workoutService;

    public WorkoutController(DemoWorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public WorkoutCreatedModel createWorkout(@ModelAttribute CreateWorkoutRequest request) {
        // For demonstration, we're using a fixed athlete ID
        String athleteId = "demo-athlete-1";

        // Create the command using the request data
        CreateWorkout command = new CreateWorkout(athleteId, request.name());

        // Handle the command using our demo service
        WorkoutId workoutId = workoutService.handleCreateWorkout(command);

        // Return the model for the template
        return new WorkoutCreatedModel(request.name(), workoutId.id());
    }

    @GetMapping
    public WorkoutFormModel getWorkoutForm() {
        return new WorkoutFormModel();
    }

    /** Request object for creating a workout. */
    record CreateWorkoutRequest(String name) {}
}
