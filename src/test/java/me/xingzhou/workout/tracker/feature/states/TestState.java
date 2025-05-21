package me.xingzhou.workout.tracker.feature.states;

import me.xingzhou.simple.event.store.EventStore;
import me.xingzhou.workout.tracker.WorkoutCommandService;
import me.xingzhou.workout.tracker.athlete.AthleteId;

public class TestState {
    public EventStore eventStore;
    public WorkoutCommandService commandService;
    public AthleteId athleteId;
    public Object result;
}
