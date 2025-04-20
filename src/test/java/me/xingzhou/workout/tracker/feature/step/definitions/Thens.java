package me.xingzhou.workout.tracker.feature.step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import me.xingzhou.workout.tracker.WorkoutId;
import me.xingzhou.workout.tracker.entities.Workout;
import me.xingzhou.workout.tracker.entities.WorkoutName;
import me.xingzhou.workout.tracker.feature.states.TestState;

import static org.assertj.core.api.Assertions.assertThat;

public class Thens {
    private final TestState state;

    public Thens(TestState state) {
        this.state = state;
    }

    @Then("the workout {string} should be created")
    public void theWorkoutShouldBeCreated(String workoutName) {
        var workoutId = (WorkoutId) state.result;
        var workout = state.eventStore.enrich(new Workout(workoutId));
        assertThat(workout.isDefined()).isTrue();
        assertThat(workout.name()).isEqualTo(new WorkoutName(workoutName));
    }

    @And("the workout {string} should have {int} sets")
    public void theWorkoutShouldHaveSets(String workoutName, int numberOfSets) {
        var workoutId = (WorkoutId) state.result;
        var workout = state.eventStore.enrich(new Workout(workoutId));
        assertThat(workout.sets().size()).isEqualTo(numberOfSets);
    }
}
