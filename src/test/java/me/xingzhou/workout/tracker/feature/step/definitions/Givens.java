package me.xingzhou.workout.tracker.feature.step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import me.xingzhou.simple.event.store.Event;
import me.xingzhou.simple.event.store.EventStoreBuilder;
import me.xingzhou.workout.tracker.AthleteDefined;
import me.xingzhou.workout.tracker.IdGenerator;
import me.xingzhou.workout.tracker.WorkoutCommandService;
import me.xingzhou.workout.tracker.WorkoutCreated;
import me.xingzhou.workout.tracker.commands.DefineAthlete;
import me.xingzhou.workout.tracker.feature.states.TestState;

import java.util.Map;

public class Givens {
    private final TestState state;

    public Givens(TestState state) {
        this.state = state;
    }

    @Given("the system is operational")
    public void theSystemIsOperational() {
        var mapping = Map.<String, Class<? extends Event>>of(
                AthleteDefined.class.getSimpleName(), AthleteDefined.class,
                WorkoutCreated.class.getSimpleName(), WorkoutCreated.class
        );
        state.eventStore = EventStoreBuilder.buildWithDefaults(mapping);
        state.commandService = new WorkoutCommandService(state.eventStore, new IdGenerator());
    }

    @And("the athlete has an account in the system")
    public void theAthleteHasAnAccountInTheSystem() {
        state.athleteId = state.commandService.handle(new DefineAthlete("jane@example.com"));
    }
}
