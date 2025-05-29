package me.xingzhou.workout.tracker.web.model;

import io.jstach.jstache.JStache;

/** Model for the workout form template. This template doesn't have any dynamic content, so the model is empty. */
@JStache(path = "workout-form")
public record WorkoutFormModel() {
    // No fields needed as the form doesn't have any dynamic content
}
