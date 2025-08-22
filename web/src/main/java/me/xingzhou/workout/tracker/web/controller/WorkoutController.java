package me.xingzhou.workout.tracker.web.controller;

import me.xingzhou.workout.tracker.web.models.WorkoutModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/** Controller for workout operations that returns HTML views. */
@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    @GetMapping
    public WorkoutModel displayWorkouts(@ModelAttribute("message") String message) {
        return new WorkoutModel(message);
    }

    @PostMapping("/record")
    public String recordWorkout(
            @RequestParam("exercise") String exercise,
            @RequestParam("reps") int reps,
            @RequestParam("weight") double weight,
            RedirectAttributes redirectAttributes) {

        // Here we would typically save the workout data to a database
        // For now, we'll just add a success message

        redirectAttributes.addFlashAttribute(
                "message", "Workout recorded successfully: " + exercise + " - " + reps + " reps with " + weight + "kg");

        return "redirect:/workouts";
    }
}
