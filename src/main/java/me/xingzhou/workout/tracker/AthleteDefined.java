package me.xingzhou.workout.tracker;

import me.xingzhou.simple.event.store.Event;

public record AthleteDefined(String email) implements Event {
}
