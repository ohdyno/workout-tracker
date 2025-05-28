package me.xingzhou.workout.tracker;

import me.xingzhou.simple.event.store.EventStore;
import me.xingzhou.workout.tracker.athlete.Athlete;
import me.xingzhou.workout.tracker.athlete.AthleteDefined;
import me.xingzhou.workout.tracker.athlete.AthleteId;
import me.xingzhou.workout.tracker.athlete.DefineAthlete;
import me.xingzhou.workout.tracker.tooling.IdGenerator;
import me.xingzhou.workout.tracker.workout.*;

public class WorkoutCommandService {
    private final EventStore eventStore;
    private final IdGenerator idGenerator;

    public WorkoutCommandService(EventStore eventStore, IdGenerator idGenerator) {
        this.eventStore = eventStore;
        this.idGenerator = idGenerator;
    }

    public WorkoutId handle(CreateWorkout createWorkout) {
        var workoutId = idGenerator.generateForWorkout(createWorkout.workoutName(), createWorkout.athleteId());
        var workout = eventStore.save(
                new WorkoutCreated(createWorkout.athleteId(), createWorkout.workoutName()),
                new Workout(new WorkoutId(workoutId)));
        return workout.id();
    }

    public AthleteId handle(DefineAthlete defineAthlete) {
        var athleteId = idGenerator.generateForAthlete(defineAthlete.email());
        var athlete = eventStore.save(
                new AthleteDefined(athleteId, defineAthlete.email()),
                Athlete.withEmail(athleteId, defineAthlete.email()));
        return athlete.id();
    }
}
