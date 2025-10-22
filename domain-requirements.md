# Domain Requirements - Workout Tracker

## Set Recording Requirements

### Core Set Data

A **set** records the following essential information:
- **Reps**: Number of repetitions performed
- **Weight**: Composed of implement weight + plates loaded

### Weight Recording Model

Athletes think about weight in terms of **plates per side** for barbell or plate-loaded machines, not total weight.

Weight is recorded as:
- **Implement**: The base equipment being used (e.g., "20kg barbell", "126lb machine", "bodyweight")
- **Implement Weight**: The weight of the implement itself
- **Plates Per Side**: The plates loaded on each side

### Set Completion Types

1. **Normal Completion**: Hitting the target reps cleanly with full range of motion maintained throughout
2. **Technical Failure**: When range of motion is reduced compared to the first rep in the set
   - **Must record**: How many reps were completed before technical failure occurred

### Notes and Annotations

- **Format**: Free-form text
- **Purpose**: Must be readable for the athlete
- **Content Examples**:
  - Machine settings (seat position, pin number)
  - Form cues that worked well
  - Intensity techniques (drop sets, myo-reps, rest-pause sets)
  - Observations about difficulty or performance

**Intensity techniques** (drop sets, myo-reps, rest-pause) are recorded as **annotations on a single set**, not as multiple sets.

### Recording Workflow

**Typical pattern**: Record data immediately after each set

**Fallback pattern**: Sometimes athletes forget and batch-record all sets before moving to the next exercise

**System must support both patterns.**

### User Experience Requirements

#### Auto-Population

Each set in the current session should be **auto-populated** with information from:
1. Previous session's corresponding set (if available)
2. Previous set in current session (if available) - takes precedence

This reduces manual data entry and makes it easy to repeat or progress from previous performance.

#### Plate Calculation Assistant

The system must automatically calculate what plates are needed to:
- Match previous weight
- Increase from previous weight

This eliminates mental math during workouts and reduces errors in plate loading.

### Domain Language

- **Implement**: The base equipment (barbell, machine, bodyweight, etc.)
- **Plates per side**: Weight plates loaded on one side of the barbell/machine
- **Technical failure**: Loss of range of motion compared to first rep
- **Set**: A continuous series of repetitions of an exercise

