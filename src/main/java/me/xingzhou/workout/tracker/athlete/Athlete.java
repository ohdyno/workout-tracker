package me.xingzhou.workout.tracker.athlete;

import me.xingzhou.simple.event.store.entities.BaseAggregate;
import me.xingzhou.simple.event.store.ids.StreamName;

public class Athlete extends BaseAggregate {
    public static Athlete withEmail(String athleteId, String email) {
        return new Athlete(new AthleteId(athleteId), new Email(email));
    }

    private AthleteId id;

    private Email email;

    private Athlete(AthleteId athleteId, Email email) {
        this.email = email;
        this.id = athleteId;
    }

    public void apply(AthleteDefined event) {
        this.id = new AthleteId(event.athleteId());
        this.email = new Email(event.email());
    }

    public AthleteId id() {
        return id;
    }

    @Override
    public StreamName streamName() {
        return new StreamName(id.id());
    }
}
