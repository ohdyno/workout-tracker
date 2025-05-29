package me.xingzhou.workout.tracker.web.controller;

import me.xingzhou.workout.tracker.web.service.DemoWorkoutService;
import me.xingzhou.workout.tracker.workout.CreateWorkout;
import me.xingzhou.workout.tracker.workout.WorkoutId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String createWorkout(@ModelAttribute CreateWorkoutRequest request, Model model) {
        // For demonstration, we're using a fixed athlete ID
        String athleteId = "demo-athlete-1";

        // Create the command using the request data
        CreateWorkout command = new CreateWorkout(athleteId, request.name());

        // Handle the command using our demo service
        WorkoutId workoutId = workoutService.handleCreateWorkout(command);

        // Add attributes to the model for the template
        model.addAttribute("id", workoutId.id());
        model.addAttribute("name", request.name());

        // Return the template name
        return "workout-created";
    }

    @GetMapping
    public String getWorkoutForm() {
        return "workout-form";
    }

    /** Request object for creating a workout. */
    record CreateWorkoutRequest(String name) {}
}
