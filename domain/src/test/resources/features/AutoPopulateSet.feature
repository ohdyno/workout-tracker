Feature: Auto-Populate Set Data
  To reduce manual data entry and make progression easier,
  sets should be auto-populated with data from previous sessions or previous sets.

  Background:
    Given the system is operational
    And the athlete has an account in the system

  Scenario: Auto-populate from previous session when starting a new workout
    Given the athlete completed a workout yesterday with:
      | exercise    | implement       | implementWeight | platesPerSide  | reps |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 9    |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 8    |
    When the athlete starts a new workout today
    And begins recording "Bench Press"
    Then the first set should be auto-populated with:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |

  Scenario: Auto-populate second set from first set in current session
    Given a workout named "Push Day" exists
    And the athlete recorded a set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
    When the athlete begins recording the next set for "Bench Press"
    Then the set should be auto-populated with:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |

  Scenario: Auto-populate from corresponding set in previous session
    Given the athlete completed a workout yesterday with:
      | exercise    | implement       | implementWeight | platesPerSide  | reps |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 9    |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 8    |
    And the athlete starts a new workout today
    And recorded the first set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide  | reps |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
    When the athlete begins recording the second set for "Bench Press"
    Then the set should be auto-populated with data from yesterday's second set:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |

  Scenario: Auto-populate prioritizes current session over previous session
    Given the athlete completed a workout yesterday with:
      | exercise    | implement       | implementWeight | platesPerSide  | reps |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
    And the athlete starts a new workout today
    And recorded the first set for "Bench Press" with:
      | implement       | implementWeight | platesPerSide        | reps |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb, 5 lb] | 10   |
    When the athlete begins recording the second set for "Bench Press"
    Then the set should be auto-populated from the first set in current session:
      | implement       | implementWeight | platesPerSide        |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb, 5 lb] |

  Scenario: Fallback to last set from previous session when no corresponding set exists
    Given the athlete completed a workout yesterday with:
      | exercise    | implement       | implementWeight | platesPerSide  | reps |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 10   |
      | Bench Press | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 9    |
    And the athlete starts a new workout today
    And begins recording set 3 for "Bench Press"
    Then the set should be auto-populated from the last set of yesterday's session:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |

  Scenario: No auto-population for first time performing an exercise
    Given the athlete has never performed "Overhead Press"
    When the athlete starts a workout
    And begins recording "Overhead Press"
    Then the set should not be auto-populated
