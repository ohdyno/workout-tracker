package me.xingzhou.workout.tracker.athlete;

import me.xingzhou.simple.event.store.Event;

public record AthleteDefined(String athleteId, String email) implements Event {}
