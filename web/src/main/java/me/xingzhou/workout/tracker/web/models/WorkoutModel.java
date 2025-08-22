package me.xingzhou.workout.tracker.web.models;

import io.jstach.jstache.JStache;

@JStache(path = "index")
public record WorkoutModel(String message) {
    public WorkoutModel() {
        this(null);
    }

    public boolean hasMessage() {
        return message != null && !message.isEmpty();
    }
}
