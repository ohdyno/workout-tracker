package me.xingzhou.workout.tracker.feature.step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import me.xingzhou.workout.tracker.workout.WorkoutId;
import me.xingzhou.workout.tracker.workout.Workout;
import me.xingzhou.workout.tracker.workout.WorkoutName;
import me.xingzhou.workout.tracker.feature.states.TestState;

import static org.assertj.core.api.Assertions.assertThat;

public class Thens {
    private final TestState state;

    public Thens(TestState state) {
        this.state = state;
    }

    @And("the workout should have {int} sets")
    public void theWorkoutShouldHaveSets(int numberOfSets) {
        var workoutId = (WorkoutId) state.result;
        var workout = state.eventStore.enrich(new Workout(workoutId));
        assertThat(workout.sets().size()).isEqualTo(numberOfSets);
    }

    @Then("the workout should be created with name {string}")
    public void theWorkoutShouldBeCreatedWithName(String workoutName) {
        var workoutId = (WorkoutId) state.result;
        var workout = state.eventStore.enrich(new Workout(workoutId));
        assertThat(workout.isDefined()).isTrue();
        assertThat(workout.name()).isEqualTo(new WorkoutName(workoutName));
    }
}
