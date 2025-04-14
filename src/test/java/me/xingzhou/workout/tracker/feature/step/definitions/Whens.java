package me.xingzhou.workout.tracker.feature.step.definitions;

import io.cucumber.java.en.When;
import me.xingzhou.workout.tracker.feature.states.TestState;

public class Whens {
    private final TestState state;

    public Whens(TestState state) {
        this.state = state;
    }

    @When("a when")
    public void aWhen() {

    }
}
