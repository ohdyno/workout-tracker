package me.xingzhou.workout.tracker.web.model;

import io.jstach.jstache.JStache;

/** Model for the workout created template. This template displays the workout name and ID. */
@JStache(path = "workout-created")
public record WorkoutCreatedModel(String name, String id) {
    // The name and id fields are used in the template
}
