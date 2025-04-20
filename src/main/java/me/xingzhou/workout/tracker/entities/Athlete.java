package me.xingzhou.workout.tracker.entities;

import com.dynatrace.hash4j.hashing.Hashing;
import me.xingzhou.simple.event.store.entities.BaseAggregate;
import me.xingzhou.simple.event.store.ids.StreamName;
import me.xingzhou.workout.AthleteId;
import me.xingzhou.workout.tracker.Email;

public class Athlete extends BaseAggregate {
    private final AthleteId id;
    private final Email email;

    public Athlete(String email) {
        this.id = new AthleteId(generateId());
        this.email = new Email(email);
    }

    private String generateId() {
        return Hashing.xxh3_128(email.email().hashCode()).hashCharsTo128Bits(email.email()).toString();
    }

    @Override
    public StreamName streamName() {
        return new StreamName(id.id());
    }

    public AthleteId id() {
        return id;
    }
}
