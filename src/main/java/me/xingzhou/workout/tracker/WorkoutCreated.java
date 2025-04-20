package me.xingzhou.workout.tracker;

import me.xingzhou.simple.event.store.Event;

public record WorkoutCreated(String athleteId, String workoutName) implements Event {
}
