Feature: Planning a Workout

  Background:
    Given the system is operational
    And the athlete has an account in the system

  Scenario: An athlete creates a new workout
    When the athlete creates a new workout named "Monday Strength"
    Then the workout "Monday Strength" should be created
    And the workout "Monday Strength" should have 0 sets

  Scenario: An athlete adds a set to an existing workout
    Given a workout named "Monday Strength" exists
    When the athlete adds a set with exercise "Squat" for 3 repetitions with 100kg to "Monday Strength"
    Then the workout "Monday Strength" should have 1 set
    And the workout "Monday Strength" should contain a set with exercise "Squat", 3 repetitions, and 100kg

  Scenario: An athlete adds multiple sets to an existing workout
    Given a workout named "Tuesday Cardio" exists
    When the athlete adds a set with exercise "Running" for 1 repetition with 5km to "Tuesday Cardio"
    And the athlete adds a set with exercise "Jumping Jacks" for 3 repetitions with 1 minute each to "Tuesday Cardio"
    Then the workout "Tuesday Cardio" should have 2 sets
    And the workout "Tuesday Cardio" should contain a set with exercise "Running", 1 repetition, and 5km
    And the workout "Tuesday Cardio" should contain a set with exercise "Jumping Jacks", 3 repetitions, and 1 minute each

  Scenario: An athlete removes a set from an existing workout
    Given a workout named "Monday Strength" exists
    And the workout "Monday Strength" contains a set with exercise "Squat", 3 repetitions, and 100kg
    When the athlete removes the set with exercise "Squat" from "Monday Strength"
    Then the workout "Monday Strength" should have 0 sets
    And the workout "Monday Strength" should not contain a set with exercise "Squat"

  Scenario: An athlete modifies a set in an existing workout
    Given a workout named "Monday Strength" exists
    And the workout "Monday Strength" contains a set with exercise "Squat", 3 repetitions, and 100kg
    When the athlete modifies the "Squat" set to have 5 repetitions and 80kg
    Then the workout "Monday Strength" should contain a set with exercise "Squat", 5 repetitions, and 80kg
    And the workout "Monday Strength" should not contain a set with exercise "Squat", 3 repetitions, and 100kg
