package me.xingzhou.workout.tracker.workout;

import me.xingzhou.simple.event.store.entities.BaseAggregate;
import me.xingzhou.simple.event.store.ids.StreamName;

import java.util.ArrayList;
import java.util.List;

public class Workout extends BaseAggregate {
    private final WorkoutId id;
    private final List<WorkoutSet> sets = new ArrayList<>();
    private WorkoutName name;

    public Workout(WorkoutId id) {
        this.id = id;
    }

    public void apply(WorkoutCreated event) {
        this.name = new WorkoutName(event.workoutName());
    }

    @Override
    public StreamName streamName() {
        return new StreamName(id.id());
    }

    public List<WorkoutSet> sets() {
        return sets;
    }

    public WorkoutName name() {
        return name;
    }

    public WorkoutId id() {
        return id;
    }
}
