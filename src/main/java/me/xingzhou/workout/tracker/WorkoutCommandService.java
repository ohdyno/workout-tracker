package me.xingzhou.workout.tracker;

import me.xingzhou.simple.event.store.EventStore;
import me.xingzhou.workout.AthleteId;
import me.xingzhou.workout.tracker.commands.DefineAthlete;
import me.xingzhou.workout.tracker.entities.Athlete;
import me.xingzhou.workout.tracker.entities.Workout;

public class WorkoutCommandService {
    private final EventStore eventStore;
    private final IdGenerator idGenerator;

    public WorkoutCommandService(EventStore eventStore, IdGenerator idGenerator) {
        this.eventStore = eventStore;
        this.idGenerator = idGenerator;
    }

    public RecordedSet handle(RecordSet recordSet) {
        return new RecordedSet();
    }

    public AthleteId handle(DefineAthlete defineAthlete) {
        var athleteId = idGenerator.generateForAthlete(defineAthlete.email());
        var athlete = eventStore.save(new AthleteDefined(athleteId, defineAthlete.email()), Athlete.withEmail(athleteId, defineAthlete.email()));
        return athlete.id();
    }

    public WorkoutId handle(CreateWorkout createWorkout) {
        var workoutId = idGenerator.generateForWorkout(createWorkout.workoutName(), createWorkout.athleteId());
        var workout = eventStore.save(new WorkoutCreated(createWorkout.athleteId(), createWorkout.workoutName()), new Workout(new WorkoutId(workoutId)));
        return workout.id();
    }
}
