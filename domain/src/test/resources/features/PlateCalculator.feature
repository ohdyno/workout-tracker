Feature: Plate Calculator
  To eliminate mental math during workouts and reduce plate loading errors,
  the system should calculate what plates are needed based on previous and current weights.

  Background:
    Given the system is operational
    And the athlete has an account in the system

  Scenario: Calculate plates to add when increasing weight
    Given the previous set used:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |
    When the athlete selects for the current set:
      | implement       | implementWeight | platesPerSide        |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb, 5 lb] |
    Then the plate calculator should suggest: "Add 5 lb plate to each side (+10 lb total)"

  Scenario: Calculate plates to remove when decreasing weight
    Given the previous set used:
      | implement       | implementWeight | platesPerSide        |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb, 5 lb] |
    When the athlete selects for the current set:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |
    Then the plate calculator should suggest: "Remove 5 lb plate from each side (-10 lb total)"

  Scenario: Same weight as previous set
    Given the previous set used:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |
    When the athlete selects for the current set:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |
    Then the plate calculator should suggest: "Same as previous"

  Scenario: Calculate total weight for display
    Given the athlete is recording a set with:
      | implement       | implementWeight | platesPerSide  |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] |
    Then the total weight should be calculated as "20 kg + 140 lb"

  Scenario: Compare weights across different implements
    Given the previous set used:
      | implement                | implementWeight | platesPerSide  |
      | Life Fitness chest press | 126 lb          | [45 lb, 25 lb] |
    When the athlete switches to:
      | implement                   | implementWeight | platesPerSide  |
      | Hammer Strength chest press | 90 lb           | [45 lb, 25 lb] |
    Then the plate calculator should note: "Same plates, but implement is 36 lb lighter"

  Scenario: Calculate plates needed to match previous total weight
    Given the previous set used:
      | implement       | implementWeight | platesPerSide        | totalWeight |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb, 5 lb] | 170 lb      |
    When the athlete wants to match the total weight of 170 lb
    And the implement is "Olympic barbell" with weight 20 kg
    Then the plate calculator should suggest: "[45 lb, 25 lb, 5 lb] per side"

  Scenario: Calculate plates needed to increase by specific amount
    Given the previous set used:
      | implement       | implementWeight | platesPerSide  | totalWeight |
      | Olympic barbell | 20 kg           | [45 lb, 25 lb] | 160 lb      |
    When the athlete wants to increase by 10 lb
    Then the plate calculator should suggest: "Add [5 lb] per side to reach 170 lb total"
