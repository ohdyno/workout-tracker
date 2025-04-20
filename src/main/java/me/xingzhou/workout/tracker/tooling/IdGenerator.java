package me.xingzhou.workout.tracker.tooling;

import java.util.UUID;

public record IdGenerator() {
    public String generateForWorkout(String workoutName, String athleteId) {
        return String.join("-", "workout", workoutName, athleteId, uuid());
    }

    private static String uuid() {
        return UUID.randomUUID().toString();
    }

    public String generateForAthlete(String email) {
        return String.join("-", "athlete", email, uuid());
    }
}
