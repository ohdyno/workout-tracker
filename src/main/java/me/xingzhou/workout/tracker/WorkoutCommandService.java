package me.xingzhou.workout.tracker;

import me.xingzhou.simple.event.store.EventStore;
import me.xingzhou.workout.AthleteId;
import me.xingzhou.workout.tracker.commands.DefineAthlete;
import me.xingzhou.workout.tracker.entities.Athlete;

public class WorkoutCommandService {
    private final EventStore eventStore;

    public WorkoutCommandService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public RecordedSet handle(RecordSet recordSet) {
        return new RecordedSet();
    }

    public AthleteId handle(DefineAthlete defineAthlete) {
        var athlete = eventStore.save(new AthleteDefined(defineAthlete.email()), new Athlete(defineAthlete.email()));
        return athlete.id();
    }
}
