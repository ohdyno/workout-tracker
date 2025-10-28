Feature: Recording a Set

  Background:
    Given the system is operational
    And the athlete has an account in the system

  Scenario: Record a set with implement, implement weight, and plates
    Given a workout named "Push Day" exists
    When the athlete records a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
    Then the workout "Push Day" should contain a set with:
      | exercise    | implement       | implementWeight | platesPerSide  | reps |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |

  Scenario: Record a set on a plate-loaded machine
    Given a workout named "Push Day" exists
    When the athlete records a set for "Chest Press" with:
      | implement                   | implementWeight | platesPerSide  | reps |
      | Hammer Strength chest press | 90 lb           | [45 lb, 25 lb] | 8    |
    Then the workout "Push Day" should contain a set with:
      | exercise    | implement                   | implementWeight | platesPerSide  | reps |
      | Chest Press | Hammer Strength chest press | 90 lb           | [45 lb, 25 lb] | 8    |

  Scenario: Record a set that reaches technical failure
    Given a workout named "Push Day" exists
    When the athlete records a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps | technicalFailureAtRep |
      | Olympic barbell | 20 kg           | [45 lb, 35 lb] | 12   | 10                    |
    Then the workout "Push Day" should contain a set with:
      | exercise    | implement       | implementWeight | platesPerSide  | reps | technicalFailureAtRep |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 35 lb] | 12   | 10                    |

  Scenario: Record a set with notes
    Given a workout named "Push Day" exists
    When the athlete records a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps | notes                  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   | Felt strong, good form |
    Then the workout "Push Day" should contain a set with notes "Felt strong, good form"

  Scenario: Record multiple sets for the same exercise
    Given a workout named "Push Day" exists
    When the athlete records a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
    And the athlete records a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 8    |
    And the athlete records a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps | technicalFailureAtRep |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 8    | 6                     |
    Then the workout "Push Day" should contain 3 sets for "Bench Press"
