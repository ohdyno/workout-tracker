package me.xingzhou.workout.tracker.entities;

import me.xingzhou.simple.event.store.entities.BaseAggregate;
import me.xingzhou.simple.event.store.ids.StreamName;
import me.xingzhou.workout.AthleteId;
import me.xingzhou.workout.tracker.AthleteDefined;
import me.xingzhou.workout.tracker.Email;
import me.xingzhou.workout.tracker.WorkoutCreated;
import me.xingzhou.workout.tracker.WorkoutId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Athlete extends BaseAggregate {
    private AthleteId id;
    private Email email;

    private final List<WorkoutId> workouts = new ArrayList<>();

    private Athlete(AthleteId athleteId) {
        this.id = athleteId;
    }

    private Athlete(AthleteId athleteId, Email email) {
        this.email = email;
        this.id = athleteId;
    }

    public static Athlete withId(String id) {
        return new Athlete(new AthleteId(id));
    }

    public static Athlete withEmail(String athleteId, String email) {
        return new Athlete(new AthleteId(athleteId), new Email(email));
    }

    public void apply(AthleteDefined event) {
        this.id = new AthleteId(event.athleteId());
        this.email = new Email(event.email());
    }

    @Override
    public StreamName streamName() {
        return new StreamName(id.id());
    }

    public AthleteId id() {
        return id;
    }

    public WorkoutId findWorkout(WorkoutId workoutId) {
        return workouts.stream().filter(workoutId::equals).findFirst().orElse(null);
    }
}
