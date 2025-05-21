package me.xingzhou.workout.tracker.workout;

import java.util.ArrayList;
import java.util.List;
import me.xingzhou.simple.event.store.entities.BaseAggregate;
import me.xingzhou.simple.event.store.ids.StreamName;

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

    public WorkoutId id() {
        return id;
    }

    public WorkoutName name() {
        return name;
    }

    public List<WorkoutSet> sets() {
        return sets;
    }

    @Override
    public StreamName streamName() {
        return new StreamName(id.id());
    }
}
