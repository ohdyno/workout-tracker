package me.xingzhou.workout.tracker.feature.step.definitions;

import io.cucumber.java.en.When;
import me.xingzhou.workout.tracker.feature.states.TestState;
import me.xingzhou.workout.tracker.workout.CreateWorkout;

public class Whens {
    private final TestState state;

    public Whens(TestState state) {
        this.state = state;
    }

    @When("the athlete creates a new workout named {string}")
    public void theAthleteCreatesANewWorkoutNamed(String workoutName) {
        state.result = state.commandService.handle(new CreateWorkout(state.athleteId.id(), workoutName));
    }
}
