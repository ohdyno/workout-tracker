package me.xingzhou.workout.tracker.feature.states;

import me.xingzhou.simple.event.store.EventStore;
import me.xingzhou.workout.AthleteId;
import me.xingzhou.workout.tracker.WorkoutCommandService;

public class TestState {
    public EventStore eventStore;
    public WorkoutCommandService commandService;
    public AthleteId athleteId;
}
