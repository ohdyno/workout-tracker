package me.xingzhou.workout.tracker.web.controller;

import me.xingzhou.workout.tracker.web.models.WorkoutModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Controller for workout operations that returns HTML views. */
@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    @GetMapping
    public WorkoutModel displayWorkouts() {
        return new WorkoutModel();
    }
}
